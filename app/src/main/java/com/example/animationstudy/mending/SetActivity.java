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

public class SetActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
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

                Animation animation = AnimationUtils.loadAnimation(SetActivity.this, type);
                animation.setDuration(1000);
                imageView.startAnimation(animation);

            }
        }));
    }

    private List<AnimationTestAdapter.Bean> initData() {
        List<AnimationTestAdapter.Bean> list = new ArrayList<AnimationTestAdapter.Bean>();

        list.add(new AnimationTestAdapter.Bean("组合动画1", R.anim.set_common));
        list.add(new AnimationTestAdapter.Bean("组合动画2", R.anim.set_common2));


        return list;
    }
}