package com.example.zue.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.zue.R;
import com.example.zue.base.BaseActivity;
import com.example.zue.databinding.FragmentLoginBinding;
import com.jeffmony.playersdk.PlayerType;
import com.jeffmony.playersdk.utils.HttpUtils;

public class LoginActivity extends BaseActivity  {

    FragmentLoginBinding binding;
    @Override
    protected View getCustomRootView() {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
