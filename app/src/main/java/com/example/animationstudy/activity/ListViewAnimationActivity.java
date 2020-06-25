package com.example.animationstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.ListViewAnimationAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListViewAnimationActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_view_animation;
    }

    private RecyclerView recyclerView;
    private Button button;
    private ListViewAnimationAdapter mainAdapter;

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.activity_main_rv);
        button = findViewById(R.id.activity_main_button);
        button.setOnClickListener(this);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 8));

        mainAdapter = new ListViewAnimationAdapter();
        recyclerView.setAdapter(mainAdapter);
        createDate();
    }

    private void createDate() {
        List<ListViewAnimationAdapter.Bean> list = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            list.add(new ListViewAnimationAdapter.Bean("" + random.nextInt(10)));
        }
        mainAdapter.setList(list);
        mainAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        //刷新数据
        createDate();
    }
}