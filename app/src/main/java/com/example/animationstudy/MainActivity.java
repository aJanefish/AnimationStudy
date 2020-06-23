package com.example.animationstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.animationstudy.activity.AttributeAnimationActivity;
import com.example.animationstudy.activity.FrameAnimationActivity;
import com.example.animationstudy.activity.MendingAnimationActivity;
import com.example.animationstudy.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
        List<MainAdapter.Bean> list = new ArrayList();
        list.add(new MainAdapter.Bean("补间动画", MendingAnimationActivity.class));
        list.add(new MainAdapter.Bean("帧动画", FrameAnimationActivity.class));
        list.add(new MainAdapter.Bean("属性动画", AttributeAnimationActivity.class));
        return list;
    }
}