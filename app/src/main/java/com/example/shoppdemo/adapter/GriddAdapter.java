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

public class GriddAdapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBannerBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;

    public GriddAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBannerBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.newGoodsListDTOS = newGoodsListDTOS;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grid_d, null, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataDTO.NewGoodsListDTO newGoodsListDTO = newGoodsListDTOS.get(position);
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        gridViewHolder.name.setText("¥"+newGoodsListDTO.getRetail_price());
        gridViewHolder.title.setText(newGoodsListDTO.getName());
        Glide.with(gridViewHolder.image).load(newGoodsListDTO.getList_pic_url()).into(gridViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return newGoodsListDTOS.size();
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView title;
        private final ImageView image;
        public GridViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.grid_d_name);
            title = view.findViewById(R.id.grid_d_title);
            image = view.findViewById(R.id.grid_d_image);
        }
    }
}
