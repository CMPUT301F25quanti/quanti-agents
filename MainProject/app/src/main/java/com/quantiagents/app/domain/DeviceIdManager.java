package com.quantiagents.app.domain;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.UUID;

public class DeviceIdManager {

    private static final String PREF_NAME = "device_identity_store";
    private static final String KEY_DEVICE_ID = "device_id";
    private final SharedPreferences preferences;

    public DeviceIdManager(Context context) {
        // Store device id locally so I can re-use it.
        this.preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public String ensureDeviceId() {
        String existing = preferences.getString(KEY_DEVICE_ID, null);
        if (existing != null && !existing.isEmpty()) {
            return existing;
        }
        String generated = UUID.randomUUID().toString();
        preferences.edit().putString(KEY_DEVICE_ID, generated).apply();
        return generated;
    }

    public String getDeviceId() {
        String current = preferences.getString(KEY_DEVICE_ID, null);
        if (current == null || current.isEmpty()) {
            return ensureDeviceId();
        }
        return current;
    }

    public void reset() {
        // Rarely touch this, only for full reset.
        preferences.edit().remove(KEY_DEVICE_ID).apply();
    }
}
