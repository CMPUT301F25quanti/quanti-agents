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
import com.quantiagents.app.App;
import com.quantiagents.app.R;
import com.quantiagents.app.domain.User;
import com.quantiagents.app.domain.UserService;
import com.quantiagents.app.ui.auth.SignUpActivity;

import java.text.DateFormat;
import java.util.Date;

public class ProfileFragment extends Fragment {

    private UserService userService;
    private TextView nameView;
    private TextView emailView;
    private TextView phoneView;
    private TextView deviceView;
    private TextView createdView;

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
        userService = ((App) requireActivity().getApplication()).locator().userService();
        // Grab handles to the profile fields once.
        nameView = view.findViewById(R.id.text_profile_name);
        emailView = view.findViewById(R.id.text_profile_email);
        phoneView = view.findViewById(R.id.text_profile_phone);
        deviceView = view.findViewById(R.id.text_profile_device);
        createdView = view.findViewById(R.id.text_profile_created);
        MaterialButton editButton = view.findViewById(R.id.button_edit_profile);
        editButton.setOnClickListener(v -> openEdit());
    }

    @Override
    public void onResume() {
        super.onResume();
        bindUser();
    }

    private void bindUser() {
        User user = userService.getCurrentUser();
        if (user == null) {
            Toast.makeText(requireContext(), R.string.error_profile_missing, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(requireContext(), SignUpActivity.class));
            requireActivity().finish();
            return;
        }
        // Fill the card with the latest profile snapshot.
        nameView.setText(user.getName());
        emailView.setText(user.getEmail());
        if (TextUtils.isEmpty(user.getPhone())) {
            phoneView.setText(R.string.profile_phone_placeholder);
        } else {
            phoneView.setText(user.getPhone());
        }
        deviceView.setText(user.getDeviceId());
        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        createdView.setText(format.format(new Date(user.getCreatedOn())));
    }

    private void openEdit() {
        startActivity(new Intent(requireContext(), EditProfileActivity.class));
    }
}
