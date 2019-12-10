package com.phuong.wallpaper.untils;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public abstract class FragmentCommon extends Fragment {
    public Activity activity;
    public abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity=getActivity();
        View view=LayoutInflater.from(activity).inflate(getLayout(),container,false);
        return view;
    }
    public abstract void init(DataBindingUtil bindingUtil);

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
