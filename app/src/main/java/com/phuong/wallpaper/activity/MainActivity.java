package com.phuong.wallpaper.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import com.phuong.wallpaper.R;
import com.phuong.wallpaper.adapter.ViewPagerAdapter;
import com.phuong.wallpaper.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frame_main,  new FragmentHome(),FragmentHome.class.getName()).commit();

    }




}
