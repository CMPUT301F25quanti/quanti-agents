package com.quantiagents.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantiagents.app.App;
import com.quantiagents.app.R;
import com.quantiagents.app.domain.DeviceIdManager;
import com.quantiagents.app.domain.LoginService;
import com.quantiagents.app.domain.UserService;
import com.quantiagents.app.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.post(this::routeToNextScreen);
    }

    private void routeToNextScreen() {
        App app = (App) getApplication();
        DeviceIdManager deviceIdManager = app.locator().deviceIdManager();
        UserService userService = app.locator().userService();
        LoginService loginService = app.locator().loginService();
        String deviceId = deviceIdManager.ensureDeviceId();
        // Try silent device login first; fall back to manual entry.
        if (loginService.loginWithDevice(deviceId)) {
            launchHome();
        } else if (userService.getCurrentUser() == null) {
            launchSignUp();
        } else {
            launchLogin();
        }
        finish();
    }

    private void launchSignUp() {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    private void launchLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void launchHome() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
