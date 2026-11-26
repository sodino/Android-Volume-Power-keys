package com.sodino.virtualkeys;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Button;
import java.util.function.IntPredicate;

public final class VolumeButton extends Button {
    private static final int STEP_DISTANCE_DP = 28;

    private enum TouchState { IDLE, PRESSING, DRAGGING }

    private final int touchSlop;
    private final float stepDistance;
    private TouchState touchState = TouchState.IDLE;
    private IntPredicate adjustVolume;
    private int tapDirection;
    private float startX;
    private float startY;
    private float lastStepY;

    public VolumeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        stepDistance = STEP_DISTANCE_DP * getResources().getDisplayMetrics().density;
    }

    void setVolumeAdjustment(int tapDirection, IntPredicate adjustVolume) {
        this.tapDirection = tapDirection;
        this.adjustVolume = adjustVolume;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled() || adjustVolume == null) {
            return super.onTouchEvent(event);
        }

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                touchState = TouchState.PRESSING;
                drawableHotspotChanged(startX, startY);
                setPressed(true);
                break;
            case MotionEvent.ACTION_MOVE:
                trackMovement(event);
                break;
            case MotionEvent.ACTION_UP:
                trackMovement(event);
                boolean tap = touchState == TouchState.PRESSING;
                finishTouch();
                if (tap) {
                    performClick();
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_CANCEL:
                finishTouch();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        boolean handled = super.performClick();
        if (adjustVolume != null) {
            adjustVolume.test(tapDirection);
            return true;
        }
        return handled;
    }

    @Override
    protected void onDetachedFromWindow() {
        finishTouch();
        super.onDetachedFromWindow();
    }

    private void trackMovement(MotionEvent event) {
        float y = event.getY();
        if (touchState == TouchState.PRESSING) {
            float vertical = startY - y;
            float horizontal = Math.abs(event.getX() - startX);
            if (Math.max(Math.abs(vertical), horizontal) <= touchSlop) {
                return;
            }
            if (horizontal >= Math.abs(vertical) || !adjustVolume.test(volumeDirection(vertical))) {
                finishTouch();
                return;
            }

            // Apply the first step at the touch threshold, then use distance for further steps.
            lastStepY = startY - Math.copySign(touchSlop, vertical);
            touchState = TouchState.DRAGGING;
        }
        if (touchState == TouchState.DRAGGING) {
            adjustForDrag(y);
        }
    }

    private void adjustForDrag(float y) {
        float distance = lastStepY - y;
        int steps = (int) (Math.abs(distance) / stepDistance);
        int direction = volumeDirection(distance);
        for (int step = 0; step < steps; step++) {
            if (!adjustVolume.test(direction)) {
                finishTouch();
                return;
            }
        }
        lastStepY -= Math.copySign(steps * stepDistance, distance);
    }

    private static int volumeDirection(float upwardDistance) {
        return upwardDistance > 0 ? AudioManager.ADJUST_RAISE : AudioManager.ADJUST_LOWER;
    }

    private void finishTouch() {
        setPressed(false);
        touchState = TouchState.IDLE;
    }
}
