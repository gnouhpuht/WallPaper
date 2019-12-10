package com.phuong.wallpaper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.phuong.wallpaper.databinding.FragmentVideoWallpaperBinding;

public class FragmentVideoWallpaper extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentVideoWallpaperBinding binding=FragmentVideoWallpaperBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

//
}
