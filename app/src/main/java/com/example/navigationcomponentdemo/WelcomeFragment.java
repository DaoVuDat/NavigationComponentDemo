package com.example.navigationcomponentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class WelcomeFragment extends Fragment {

    private TextView tvUsername;
    private TextView tvPassword;
    private Button btnOkay;
    private WelcomeFragmentArgs args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        tvUsername = view.findViewById(R.id.tvUsername);
        tvPassword = view.findViewById(R.id.tvPassword);
        btnOkay = view.findViewById(R.id.btnOk);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        args = WelcomeFragmentArgs.fromBundle(getArguments());

        tvUsername.setText(args.getUsername());
        tvPassword.setText(args.getPassword());

        btnOkay.setOnClickListener(v -> {
            NavDirections action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment2();
//            Navigation.findNavController(v).navigate(action);
            NavHostFragment.findNavController(this).navigate(action);
        });
    }
}
