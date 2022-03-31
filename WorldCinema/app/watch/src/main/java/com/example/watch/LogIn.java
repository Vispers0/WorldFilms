package com.example.watch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.watch.databinding.ActivityLogInBinding;

public class LogIn extends Activity {

    private TextView mTextView;
    private ActivityLogInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}