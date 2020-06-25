package com.example.animationstudy.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.AnimationTestAdapter;
import com.example.animationstudy.mending.AlphaActivity;

import java.util.ArrayList;
import java.util.List;

public class FrameAnimationActivity extends BaseActivity {
    private ImageView imageView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_frame_animation;
    }



    @Override
    protected void initView() {

        imageView = findViewById(R.id.image_view);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(new AnimationTestAdapter(initData(), new AnimationTestAdapter.AnimationCallBack() {
            @SuppressLint("SetTextI18n")
            @Override
            public void callBack(int type) {

                imageView.setBackgroundResource(type);
                Drawable drawable = imageView.getBackground();
                if (drawable instanceof AnimationDrawable){
                    ((AnimationDrawable) drawable).start();
                }
            }
        }));
    }

    private List<AnimationTestAdapter.Bean> initData() {
        List<AnimationTestAdapter.Bean> list = new ArrayList<AnimationTestAdapter.Bean>();

        list.add(new AnimationTestAdapter.Bean("播放帧动画(无限循环)", R.drawable.animation_list_commin));
        list.add(new AnimationTestAdapter.Bean("播放帧动画(播放一次)", R.drawable.animation_list_commin_1));



        return list;
    }
}