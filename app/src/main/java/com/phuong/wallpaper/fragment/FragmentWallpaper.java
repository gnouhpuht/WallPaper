package com.phuong.wallpaper.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.phuong.wallpaper.adapter.ViewPagerAdapter;
import com.phuong.wallpaper.databinding.FragmentWallpaperBinding;

public class FragmentWallpaper extends Fragment {
    private FragmentWallpaperBinding binding;
    private View view;
    private final String[] PERMISTION = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE

    };
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private FragmentPopular popular=new FragmentPopular();
    private FragmentCategory category=new FragmentCategory();
    private FragmentFavorite favorite =new FragmentFavorite();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentWallpaperBinding.inflate(inflater,container,false);

        if (checkPermistion()){
            initView(binding);
        }
        return binding.getRoot();
    }

    private void initView(FragmentWallpaperBinding binding) {
    }



    public boolean checkPermistion(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            for (String p: PERMISTION){
                if (getActivity().checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(PERMISTION, 0);
                    return false;
                }
            }
        }
        return true;
    }
}
