package com.example.animationstudy.activity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.MainAdapter;
import com.example.animationstudy.attributeanimation.AnimatorSetActivity;
import com.example.animationstudy.attributeanimation.ObjectAnimatorActivity;
import com.example.animationstudy.attributeanimation.TimeAnimatorActivity;
import com.example.animationstudy.attributeanimation.ValueAnimatorActivity;
import com.example.animationstudy.attributeanimation.ObjectAnimatorTestActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性动画
 */
public class AttributeAnimationActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_attribute_animation;
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
        list.add(new MainAdapter.Bean("ObjectAnimator", ObjectAnimatorActivity.class));
        list.add(new MainAdapter.Bean("ValueAnimator", ValueAnimatorActivity.class));
        list.add(new MainAdapter.Bean("TimeAnimator", TimeAnimatorActivity.class));
        list.add(new MainAdapter.Bean("AnimatorSet", AnimatorSetActivity.class));
        list.add(new MainAdapter.Bean("ValueAnimator改变任何对象的属性", ObjectAnimatorTestActivity.class));
        list.add(new MainAdapter.Bean("更多内容，敬请期待", null));

        return list;
    }
}