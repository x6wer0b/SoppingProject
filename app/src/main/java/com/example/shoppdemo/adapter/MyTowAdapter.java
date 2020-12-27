package com.example.shoppdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.shoppdemo.R;

public class MyTowAdapter extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;
    private String title;

    public MyTowAdapter(SingleLayoutHelper singleLayoutHelper, String title) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.title = title;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_text, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextViewHolder textViewHolder = (TextViewHolder) holder;
        textViewHolder.name.setText(title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        public TextViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.text_name);
        }
    }
}
