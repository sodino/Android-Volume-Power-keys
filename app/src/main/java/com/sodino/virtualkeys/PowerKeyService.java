package com.sodino.virtualkeys;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;

public final class PowerKeyService extends AccessibilityService {
    private static PowerKeyService connectedService;

    static PowerKeyService getConnectedService() {
        return connectedService;
    }

    @Override
    protected void onServiceConnected() {
        connectedService = this;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        if (connectedService == this) {
            connectedService = null;
        }
        return super.onUnbind(intent);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // The service subscribes to no events. It only performs requested power actions.
    }

    @Override
    public void onInterrupt() {
    }
}
