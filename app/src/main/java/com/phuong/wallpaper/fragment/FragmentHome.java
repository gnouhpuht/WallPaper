package com.phuong.wallpaper.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.phuong.wallpaper.R;
import com.phuong.wallpaper.adapter.ViewPagerAdapter;
import com.phuong.wallpaper.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {
    private FragmentHomeBinding binding;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private AppBarLayout appBarLayout;

    final int[] ICONS = new int[]{
            R.drawable.icon_wallpaper,
            R.drawable.icon_video_wallpaper,
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater,container,false);
        initView(binding);
        return binding.getRoot();
    }

    @SuppressLint("ResourceAsColor")
    private void initView(FragmentHomeBinding binding) {
        viewPager= binding.viewPager;
        final TabLayout tabs = binding.tapbar;
        appBarLayout=binding.banner;
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), this);
        viewPagerAdapter.addFragment(new FragmentWallpaper(), "wallpaper");
        viewPagerAdapter.addFragment(new FragmentVideoWallpaper(), "videpwallpaper");
        viewPager.setAdapter(viewPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(ICONS[0]);
        tabs.getTabAt(1).setIcon(ICONS[1]);
        tabs.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        tabs.setTabTextColors(getResources().getColor(R.color.gray), getResources().getColor(R.color.white));
        tabs.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));



        final BottomNavigationView navigation= binding.navigation;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        appBarLayout.setBackgroundColor(R.color.colorAccent);
        navigation.setItemTextColor(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_wallpaper));
        navigation.setItemIconTintList(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_wallpaper));
        tabs.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            int index=0;
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                index=tab.getPosition();
                if (index==0) {
                    appBarLayout.setBackgroundColor(R.color.colorAccent);
                    navigation.setItemTextColor(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_wallpaper));
                    navigation.setItemIconTintList(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_wallpaper));
                }else {

                    appBarLayout.setBackgroundColor(R.color.orange);
                    navigation.setItemTextColor(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_video_wallpaper));
                    navigation.setItemIconTintList(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_video_wallpaper));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });



//        if (tab.isSelected()){
//            appBarLayout.setBackgroundColor(R.color.colorAccent);
//            navigation.setItemTextColor(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_wallpaper));
//            navigation.setItemIconTintList(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_wallpaper));
//        }
//        if (tabs.getTabAt(1).isSelected()){
//            appBarLayout.setBackgroundColor(R.color.orange);
//            navigation.setItemTextColor(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_video_wallpaper));
//            navigation.setItemIconTintList(ColorStateList.valueOf(R.drawable.listen_bottom_nvg_video_wallpaper));
//        }

        viewPager.setOffscreenPageLimit(2);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.popular:

//                    viewPager.setCurrentItem(0);
//                    checkFrag();
//                    popular.initFrag();
                    return true;
                case R.id.discover:
                    return true;
                case R.id.favourite:
                    return true;
                case R.id.more:
                    Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.android.vending");
                    startActivity(launchIntent);
                    return true;
            }
            return false;
        }
    };
}
