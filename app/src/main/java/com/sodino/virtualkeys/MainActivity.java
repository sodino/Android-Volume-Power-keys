package com.sodino.virtualkeys;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.widget.Button;
import android.widget.Toast;

public final class MainActivity extends Activity {
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = getSystemService(AudioManager.class);

        setupVolumeButton(R.id.volume_down, AudioManager.ADJUST_LOWER);
        setupVolumeButton(R.id.volume_up, AudioManager.ADJUST_RAISE);

        Button power = findViewById(R.id.power);
        setButtonHint(power, R.string.power_hint);
        power.setOnClickListener(view -> runPowerAction(
                AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN, R.string.lock_failed));
        power.setOnLongClickListener(view -> {
            runPowerAction(AccessibilityService.GLOBAL_ACTION_POWER_DIALOG, R.string.menu_failed);
            return true;
        });
    }

    private void setupVolumeButton(int buttonId, int tapDirection) {
        VolumeButton button = findViewById(buttonId);
        setButtonHint(button, R.string.volume_hint);
        button.setVolumeAdjustment(tapDirection, this::adjustVolume);
    }

    private void setButtonHint(Button button, int hint) {
        CharSequence title = button.getText();
        SpannableString label = new SpannableString(title + "\n" + getString(hint));
        label.setSpan(new RelativeSizeSpan(0.56f), title.length() + 1, label.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        button.setText(label);
    }

    private boolean adjustVolume(int direction) {
        try {
            audioManager.adjustVolume(direction, AudioManager.FLAG_SHOW_UI);
            return true;
        } catch (SecurityException exception) {
            Toast.makeText(this, R.string.volume_restricted, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void runPowerAction(int action, int errorMessage) {
        PowerKeyService service = PowerKeyService.getConnectedService();
        if (service == null) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.enable_power_title)
                    .setMessage(getString(R.string.enable_power_message, getString(R.string.app_name)))
                    .setNegativeButton(android.R.string.cancel, null)
                    .setPositiveButton(R.string.open_settings, (dialog, which) ->
                            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)))
                    .show();
            return;
        }

        if (!service.performGlobalAction(action)) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
