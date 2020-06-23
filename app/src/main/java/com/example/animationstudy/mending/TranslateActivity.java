package com.example.animationstudy.mending;

import android.annotation.SuppressLint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.AnimationTestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * View动画之 平移动画
 */
public class TranslateActivity extends BaseActivity {

    private Button mButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_translate;
    }

    @Override
    protected void initView() {

        mButton = findViewById(R.id.button);
        mButton.setText("平移动画");

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(new AnimationTestAdapter(initData(), new AnimationTestAdapter.AnimationCallBack() {
            @SuppressLint("SetTextI18n")
            @Override
            public void callBack(int type) {

                Animation animation = AnimationUtils.loadAnimation(TranslateActivity.this, type);
                animation.setDuration(1000);
                mButton.setText("" + animation.getClass().getSimpleName());
                mButton.startAnimation(animation);

            }
        }));
    }

    private List<AnimationTestAdapter.Bean> initData() {
        List<AnimationTestAdapter.Bean> list = new ArrayList<AnimationTestAdapter.Bean>();
        list.add(new AnimationTestAdapter.Bean("原点向上平移", R.anim.translate_up));
        list.add(new AnimationTestAdapter.Bean("原点向下平移", R.anim.translate_down));
        list.add(new AnimationTestAdapter.Bean("原点向左平移", R.anim.translate_left));
        list.add(new AnimationTestAdapter.Bean("原点向右平移", R.anim.translate_right));

        list.add(new AnimationTestAdapter.Bean("原点向左上平移", R.anim.translate_left_up));
        list.add(new AnimationTestAdapter.Bean("原点向左下平移", R.anim.translate_left_dowm));
        list.add(new AnimationTestAdapter.Bean("原点向右上平移", R.anim.translate_right_up));
        list.add(new AnimationTestAdapter.Bean("原点向右下平移", R.anim.translate_right_dowm));


        list.add(new AnimationTestAdapter.Bean("向上平移到原点", R.anim.translate_up_to_orign));
        list.add(new AnimationTestAdapter.Bean("向下平移到原点", R.anim.translate_down_to_orign));
        list.add(new AnimationTestAdapter.Bean("向左平移到原点", R.anim.translate_left_to_orign));
        list.add(new AnimationTestAdapter.Bean("向右平移到原点", R.anim.translate_right_to_orign));

        list.add(new AnimationTestAdapter.Bean("向左上平移到原点", R.anim.translate_left_up_to_orign));
        list.add(new AnimationTestAdapter.Bean("向左下平移到原点", R.anim.translate_left_dowm_to_orign));
        list.add(new AnimationTestAdapter.Bean("向右上平移到原点", R.anim.translate_right_up_to_orign));
        list.add(new AnimationTestAdapter.Bean("向右下平移到原点", R.anim.translate_right_dowm_to_orign));
        return list;
    }

}