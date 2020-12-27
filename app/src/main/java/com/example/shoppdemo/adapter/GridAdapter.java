package com.example.shoppdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoppdemo.R;
import com.example.shoppdemo.bean.HomeBannerBean;

import java.util.ArrayList;

public class GridAdapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBannerBean.DataDTO.BrandListDTO> brandlist;

    public GridAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBannerBean.DataDTO.BrandListDTO> brandlist) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.brandlist = brandlist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grid, null, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataDTO.BrandListDTO brandListDTO = brandlist.get(position);
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        gridViewHolder.name.setText(brandListDTO.getFloor_price()+"元起");
        gridViewHolder.title.setText(brandListDTO.getName());
        Glide.with(gridViewHolder.image).load(brandListDTO.getNew_pic_url()).into(gridViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return brandlist.size();
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView title;
        private final ImageView image;

        public GridViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.grid_name);
            title = view.findViewById(R.id.grid_title);
            image = view.findViewById(R.id.grid_image);
        }
    }
}
