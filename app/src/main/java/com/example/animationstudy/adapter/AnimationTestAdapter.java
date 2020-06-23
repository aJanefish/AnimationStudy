package com.example.animationstudy.adapter;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.R;

import java.util.ArrayList;
import java.util.List;

public class AnimationTestAdapter extends RecyclerView.Adapter<AnimationTestAdapter.Holder> {

    private List<Bean> mList = new ArrayList();
    private AnimationCallBack mAnimationCallBack;

    public AnimationTestAdapter(List<Bean> list, AnimationCallBack animationCallBack) {
        this.mAnimationCallBack = animationCallBack;
        mList.addAll(list);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animation_test_item, parent, false);
        return new Holder(view, this.mAnimationCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.onBind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Bean mBean;
        Button button;
        private AnimationCallBack mAnimationCallBack;

        public Holder(@NonNull View itemView, AnimationCallBack animationCallBack) {
            super(itemView);
            button = itemView.findViewById(R.id.animation_test_item_title);
            button.setOnClickListener(this);
            mAnimationCallBack = animationCallBack;
        }

        public void onBind(Bean bean) {
            mBean = bean;
            button.setText(bean.des);
        }

        @Override
        public void onClick(View v) {
            mAnimationCallBack.callBack(mBean.animationId);
        }
    }

    public static class Bean {
        private String des;
        int animationId = 0;

        public Bean(String des, int id) {
            this.des = des;
            this.animationId = id;
        }
    }

    public interface AnimationCallBack {
        void callBack(int type);
    }
}
