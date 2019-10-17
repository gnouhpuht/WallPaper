package com.phuong.wallpaper.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.phuong.wallpaper.R;
import com.phuong.wallpaper.fragment.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList =new ArrayList<>();
    private final List<String> fragmentListTitles=new ArrayList<>();
    private final Context mContext;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.wallpaper,R.string.videowallpaper};


    public ViewPagerAdapter(@NonNull FragmentManager fm, FragmentHome mContext) {
        super(fm);
        this.mContext = mContext.getContext();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }
}
