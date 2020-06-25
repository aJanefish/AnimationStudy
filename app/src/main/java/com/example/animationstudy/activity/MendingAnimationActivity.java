package com.example.animationstudy.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.MainAdapter;
import com.example.animationstudy.mending.AlphaActivity;
import com.example.animationstudy.mending.RotateActivity;
import com.example.animationstudy.mending.ScaleActivity;
import com.example.animationstudy.mending.SetActivity;
import com.example.animationstudy.mending.TranslateActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 补间动画
 * 平移
 * 缩放
 * 旋转
 * alpha
 */
public class MendingAnimationActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mending_animation;
    }

    @Override
    protected void initView() {
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new MainAdapter(initData()));
    }

    private List<MainAdapter.Bean> initData() {
        List<MainAdapter.Bean> list = new ArrayList<MainAdapter.Bean>();
        list.add(new MainAdapter.Bean("平移动画", TranslateActivity.class));
        list.add(new MainAdapter.Bean("缩放动画", ScaleActivity.class));
        list.add(new MainAdapter.Bean("旋转动画", RotateActivity.class));
        list.add(new MainAdapter.Bean("alpha动画", AlphaActivity.class));
        list.add(new MainAdapter.Bean("Set动画", SetActivity.class));
        return list;
    }
}