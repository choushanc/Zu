package com.example.zue.fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zue.base.BaseFragment;
import com.example.zue.databinding.ActivityMainBinding;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.enums.CoreAnim;

@Page(name = "XPage", anim = CoreAnim.none)
public class MainFragment extends BaseFragment {
    ActivityMainBinding binding;

    @Nullable
    @Override
    protected View onCreateContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, boolean attachToRoot) {
        binding = ActivityMainBinding.inflate(inflater, container, attachToRoot);
        return binding.getRoot();
    }


    @Override
    protected void initViews() {
    }

}
