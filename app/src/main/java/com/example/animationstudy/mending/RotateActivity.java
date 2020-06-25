package com.example.animationstudy.mending;

import android.annotation.SuppressLint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.AnimationTestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * View动画之 旋转动画
 */
public class RotateActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rotate;
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

                Animation animation = AnimationUtils.loadAnimation(RotateActivity.this, type);
                animation.setDuration(1000);
                imageView.startAnimation(animation);

            }
        }));
    }

    private List<AnimationTestAdapter.Bean> initData() {
        List<AnimationTestAdapter.Bean> list = new ArrayList<AnimationTestAdapter.Bean>();
        //clockwise - 顺时针
        //anti-clockwise - 逆时针
        list.add(new AnimationTestAdapter.Bean("左上角顺时针旋转180", R.anim.rotate_clockwise_180));
        list.add(new AnimationTestAdapter.Bean("左上角逆时针旋转180", R.anim.rotate_anti_clockwise_180));
        list.add(new AnimationTestAdapter.Bean("中间顺时针旋转180", R.anim.rotate_clockwise_180_in_center));
        list.add(new AnimationTestAdapter.Bean("中间逆时针旋转180", R.anim.rotate_anti_clockwise_180_in_center));


        list.add(new AnimationTestAdapter.Bean("左上角顺时针旋转360", R.anim.rotate_clockwise_360));
        list.add(new AnimationTestAdapter.Bean("左上角逆时针旋转360", R.anim.rotate_anti_clockwise_360));
        list.add(new AnimationTestAdapter.Bean("中间顺时针旋转360", R.anim.rotate_clockwise_360_in_center));
        list.add(new AnimationTestAdapter.Bean("中间逆时针旋转360", R.anim.rotate_anti_clockwise_360_in_center));


        list.add(new AnimationTestAdapter.Bean("左上角顺时针旋转720", R.anim.rotate_clockwise_720));
        list.add(new AnimationTestAdapter.Bean("左上角逆时针旋转720", R.anim.rotate_anti_clockwise_720));
        list.add(new AnimationTestAdapter.Bean("中间顺时针旋转720", R.anim.rotate_clockwise_720_in_center));
        list.add(new AnimationTestAdapter.Bean("中间逆时针旋转720", R.anim.rotate_anti_clockwise_720_in_center));





        return list;
    }


}