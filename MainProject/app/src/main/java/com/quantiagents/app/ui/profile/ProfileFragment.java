package com.quantiagents.app.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.quantiagents.app.App;
import com.quantiagents.app.R;
import com.quantiagents.app.Services.LoginService; // ADDED
import com.quantiagents.app.models.User;
import com.quantiagents.app.Services.UserService;
import com.quantiagents.app.ui.auth.SignUpActivity;

public class ProfileFragment extends Fragment {

    private UserService userService;
    private LoginService loginService;
    private TextView firstNameView;
    private TextView lastNameView;
    private TextView emailView;
    private TextView phoneView;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App app = (App) requireActivity().getApplication();
        userService = app.locator().userService();
        loginService = app.locator().loginService();

        firstNameView = view.findViewById(R.id.text_profile_first_name);
        lastNameView = view.findViewById(R.id.text_profile_last_name);
        emailView = view.findViewById(R.id.text_profile_email);
        phoneView = view.findViewById(R.id.text_profile_phone);
        MaterialButton editButton = view.findViewById(R.id.button_edit_profile);
        editButton.setOnClickListener(v -> openEdit());
        MaterialButton deleteButton = view.findViewById(R.id.button_delete_profile);
        deleteButton.setOnClickListener(v -> confirmDeletion());
    }

    @Override
    public void onResume() {
        super.onResume();
        bindUser();
    }

    private void bindUser() {
        // checking memory cache first to avoid race condition with DB update
        User cachedUser = loginService.getActiveUser();

        if (cachedUser != null) {
            populateUI(cachedUser);
        } else {
            // fallback to database if memory is empty (e.g. fresh launch)
            userService.getCurrentUser(
                    user -> {
                        if (user == null) {
                            Toast.makeText(requireContext(), R.string.error_profile_missing, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(requireContext(), SignUpActivity.class));
                            requireActivity().finish();
                            return;
                        }
                        populateUI(user);
                    },
                    e -> {
                        Toast.makeText(requireContext(), R.string.error_profile_missing, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(requireContext(), SignUpActivity.class));
                        requireActivity().finish();
                    }
            );
        }
    }

    private void populateUI(User user) {
        // Split name into first and last name
        String fullName = user.getName() != null ? user.getName().trim() : "";
        String[] nameParts = fullName.split(" ", 2);
        if (nameParts.length > 0) {
            firstNameView.setText(nameParts[0]);
        } else {
            firstNameView.setText("");
        }
        if (nameParts.length > 1) {
            lastNameView.setText(nameParts[1]);
        } else {
            lastNameView.setText("");
        }

        emailView.setText(user.getEmail() != null ? user.getEmail() : "");
        if (TextUtils.isEmpty(user.getPhone())) {
            phoneView.setText(R.string.profile_phone_placeholder);
        } else {
            phoneView.setText(user.getPhone());
        }
    }

    private void openEdit() {
        startActivity(new Intent(requireContext(), EditProfileActivity.class));
    }

    /**
     * Shows the confirmation dialog before we wipe the profile.
     */
    private void confirmDeletion() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.delete_profile_title)
                .setMessage(R.string.delete_profile_body)
                .setPositiveButton(R.string.delete_profile_confirm, (dialog, which) -> deleteProfile())
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /**
     * Clears local session, deletes the profile, and routes back to sign-up.
     */
    private void deleteProfile() {
        loginService.logout();
        userService.deleteUserProfile(
                aVoid -> {
                    ((App) requireActivity().getApplication()).locator().deviceIdManager().reset();
                    Toast.makeText(requireContext(), R.string.message_profile_deleted, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(requireContext(), SignUpActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    requireActivity().finish();
                },
                e -> Toast.makeText(requireContext(), R.string.error_profile_missing, Toast.LENGTH_SHORT).show()
        );
    }
}