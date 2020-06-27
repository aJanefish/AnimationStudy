package com.example.animationstudy.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.animationstudy.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<Bean> mList = new ArrayList();

    public MainAdapter(List<Bean> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        holder.onBind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MainHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mTitle;
        private Bean mBean;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.activity_main_item_title);
            itemView.setOnClickListener(this);
        }

        public void onBind(Bean bean) {
            if (bean == null) {
                return;
            }
            mBean = bean;
            mTitle.setText(mBean.mTitle);
        }

        @Override
        public void onClick(View v) {
            if (mBean.aClass == null) {
                return;
            }
            itemView.getContext().startActivity(new Intent(itemView.getContext(), mBean.aClass));
        }
    }

    public static class Bean {

        private String mTitle;
        private Class aClass;

        public Bean(String mTitle, Class aClass) {
            this.mTitle = mTitle;
            this.aClass = aClass;
        }
    }

}
