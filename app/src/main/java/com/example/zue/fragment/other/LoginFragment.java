package com.example.zue.fragment.other;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zue.R;
import com.example.zue.base.BaseFragment;
import com.example.zue.databinding.FragmentLoginBinding;
import com.xuexiang.xpage.annotation.Page;

@Page(name = "Login")
public class LoginFragment extends BaseFragment {
    FragmentLoginBinding binding;
    @Nullable
    @Override
    protected View onCreateContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, boolean attachToRoot) {
        binding = FragmentLoginBinding.inflate(inflater,container,attachToRoot);
        return binding.getRoot();
    }

    @Override
    protected void initViews() {

    }
}
