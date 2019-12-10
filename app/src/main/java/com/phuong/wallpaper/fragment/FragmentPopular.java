package com.phuong.wallpaper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.phuong.wallpaper.adapter.PopularAdapter;
import com.phuong.wallpaper.databinding.FragmentPopularBinding;

public class FragmentPopular extends Fragment implements PopularAdapter.IPopular {
    private RecyclerView rc;
    private PopularAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPopularBinding binding=FragmentPopularBinding.inflate(inflater,container,false);
        rc=binding.rcvPopular;
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new PopularAdapter(getActivity(),this);
        rc.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return 10;
    }
}
