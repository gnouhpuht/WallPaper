package com.phuong.wallpaper.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.phuong.wallpaper.R;
import com.phuong.wallpaper.databinding.ActivityMainBinding;
import com.phuong.wallpaper.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frame_main,  new FragmentHome(),FragmentHome.class.getName()).commit();

    }




}
