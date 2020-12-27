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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoppdemo.R;
import com.example.shoppdemo.bean.HomeBannerBean;

import java.util.ArrayList;

public class LayLinAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBannerBean.DataDTO.HotGoodsListDTO> hotGoodsList;

    public LayLinAdapter(LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBannerBean.DataDTO.HotGoodsListDTO> hotGoodsList) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.hotGoodsList = hotGoodsList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_laylin, null, false);
        return new LayLinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LayLinViewHolder layLinViewHolder = (LayLinViewHolder) holder;
        HomeBannerBean.DataDTO.HotGoodsListDTO hotGoodsListDTO = hotGoodsList.get(position);

        layLinViewHolder.title.setText(hotGoodsListDTO.getName());
        layLinViewHolder.name.setText(hotGoodsListDTO.getGoods_brief());
        layLinViewHolder.jin.setText("¥"+hotGoodsListDTO.getRetail_price());

        Glide.with(layLinViewHolder.image).load(hotGoodsListDTO.getList_pic_url()).into(layLinViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return hotGoodsList.size();
    }

    private class LayLinViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView title;
        private final TextView name;
        private final TextView jin;
        public LayLinViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.lay_image);
            title = view.findViewById(R.id.lay_title);
            name = view.findViewById(R.id.lay_name);
            jin = view.findViewById(R.id.lay_jin);
        }
    }
}
