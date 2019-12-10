package com.phuong.wallpaper.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phuong.wallpaper.databinding.ItemCommonImageBinding;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.VH> {
    private Activity activity;
    private IPopular inter;

    public PopularAdapter(Activity activity, IPopular inter) {
        this.activity = activity;
        this.inter = inter;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCommonImageBinding binding= ItemCommonImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return inter.getCount();
    }

    static class VH extends RecyclerView.ViewHolder{
        private ItemCommonImageBinding binding;

        public VH(ItemCommonImageBinding binding) {
            super(binding.getRoot());
        }
    }

    public interface IPopular{
        int getCount();
    }
}
