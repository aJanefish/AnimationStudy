package com.example.animationstudy.mending;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.AnimationTestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * View动画之 缩放动画
 */
public class ScaleActivity extends BaseActivity {
    private ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scale;
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

                Animation animation = AnimationUtils.loadAnimation(ScaleActivity.this, type);
                animation.setDuration(1000);
                imageView.startAnimation(animation);

            }
        }));
    }

    private List<AnimationTestAdapter.Bean> initData() {
        List<AnimationTestAdapter.Bean> list = new ArrayList<AnimationTestAdapter.Bean>();
        //vertical
        //horizontal
        list.add(new AnimationTestAdapter.Bean("原点横向放大", R.anim.scale_orgin_horizontal_enlarge));
        list.add(new AnimationTestAdapter.Bean("非原点横向放大", R.anim.scale_non_orgin_horizontal_enlarge));


        list.add(new AnimationTestAdapter.Bean("原点竖向放大", R.anim.scale_orgin_vertical_enlarge));
        list.add(new AnimationTestAdapter.Bean("非原点竖向放大", R.anim.scale_non_orgin_vertical_enlarge));

        list.add(new AnimationTestAdapter.Bean("原点放大", R.anim.scale_orgin_enlarge));
        list.add(new AnimationTestAdapter.Bean("非原点放大", R.anim.scale_non_orgin_enlarge));


        list.add(new AnimationTestAdapter.Bean("原点横向缩小", R.anim.scale_orgin_horizontal_narrow));
        list.add(new AnimationTestAdapter.Bean("非原点横向缩小", R.anim.scale_non_orgin_horizontal_narrow));

        list.add(new AnimationTestAdapter.Bean("原点竖向缩小", R.anim.scale_orgin_vertical_narrow));
        list.add(new AnimationTestAdapter.Bean("非原点竖向缩小", R.anim.scale_non_orgin_vertical_narrow));

        list.add(new AnimationTestAdapter.Bean("原点缩小", R.anim.scale_orgin_narrow));
        list.add(new AnimationTestAdapter.Bean("非原点缩小", R.anim.scale_non_orgin_narrow));

        return list;
    }

}