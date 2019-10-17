package com.phuong.wallpaper.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.phuong.wallpaper.R;
import com.phuong.wallpaper.adapter.ViewPagerAdapter;

public class FragmentHome extends Fragment {
    private ViewPager viewPager;
    private View view;
    private ViewPagerAdapter viewPagerAdapter;
    private Activity activity;
    final int[] ICONS = new int[]{
            R.drawable.icon_wallpaper,
            R.drawable.icon_video_wallpaper,
    };

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewPager= view.findViewById(R.id.view_pager);
        TabLayout tabs = view.findViewById(R.id.tapbar);
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

        viewPager.setOffscreenPageLimit(2);
    }
}
