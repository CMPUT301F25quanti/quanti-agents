package com.quantiagents.app.data;

import android.content.Context;

import com.quantiagents.app.domain.DeviceIdManager;
import com.quantiagents.app.domain.LoginService;
import com.quantiagents.app.domain.UserService;

public class ServiceLocator {

    private final Context appContext;
    private DeviceIdManager deviceIdManager;
    private UserRepository userRepository;
    private UserService userService;
    private LoginService loginService;

    public ServiceLocator(Context context) {
        // Stick with the app context to avoid leaks.
        this.appContext = context.getApplicationContext();
    }

    public synchronized DeviceIdManager deviceIdManager() {
        if (deviceIdManager == null) {
            // Keep device id generation in one place.
            deviceIdManager = new DeviceIdManager(appContext);
        }
        return deviceIdManager;
    }

    public synchronized UserRepository userRepository() {
        if (userRepository == null) {
            // Shared prefs store my entrant snapshot.
            userRepository = new UserRepository(appContext);
        }
        return userRepository;
    }

    public synchronized UserService userService() {
        if (userService == null) {
            // Build user logic around the repo and device id.
            userService = new UserService(userRepository(), deviceIdManager());
        }
        return userService;
    }

    public synchronized LoginService loginService() {
        if (loginService == null) {
            // Light wrapper to handle auth checks.
            loginService = new LoginService(userService());
        }
        return loginService;
    }
}
