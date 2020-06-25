package com.example.animationstudy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.R;

import java.util.ArrayList;
import java.util.List;


public class ListViewAnimationAdapter extends RecyclerView.Adapter<ListViewAnimationAdapter.MainHolder> {

    private List<Bean> mList = new ArrayList();

    public ListViewAnimationAdapter() {
    }

    public void setList(List<Bean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mList = list;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_animation_item, parent, false);
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

    public static class MainHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private Bean mBean;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.activity_main_item_message);
        }

        public void onBind(Bean bean) {
            if (bean == null) {
                return;
            }
            mBean = bean;
            mTitle.setText(mBean.mValue);
        }
    }

    public static class Bean {

        private String mValue;

        public Bean(String value) {
            this.mValue = value;
        }
    }

}
