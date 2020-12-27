package com.example.day_project_1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.day_project_1.R;
import com.example.day_project_1.data.ItemBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class LanGeAdapter extends DelegateAdapter.Adapter {

    private ColumnLayoutHelper columnLayoutHelper;
    private ArrayList<ItemBean.DataDTO.BannerDTO> banner;

    public LanGeAdapter(ColumnLayoutHelper columnLayoutHelper, ArrayList<ItemBean.DataDTO.BannerDTO> banner) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.banner = banner;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_banner, null, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
        for (int i = 0; i < banner.size(); i++) {
            Log.e("TAG", "onBindViewHolder: "+banner.get(i).getImage_url());
        }
        bannerViewHolder.bannerid.setImages(banner)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        ItemBean.DataDTO.BannerDTO bannerDTO = (ItemBean.DataDTO.BannerDTO) path;
                        Glide.with(context).load(bannerDTO.getImage_url())
                                .into(imageView);
                    }
                }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Banner bannerid;

        public BannerViewHolder(View view) {
            super(view);
            bannerid = view.findViewById(R.id.banner_id);
        }
    }
}
