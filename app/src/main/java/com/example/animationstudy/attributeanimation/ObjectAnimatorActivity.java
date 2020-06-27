package com.example.animationstudy.attributeanimation;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;
import com.example.animationstudy.adapter.AttributeAnimationAdapter;

import java.util.ArrayList;
import java.util.List;

public class ObjectAnimatorActivity extends BaseActivity {

    private ImageView imageView;
    private TextView start_des;
    private TextView end_des;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_object_animator;
    }


    @Override
    protected void initView() {

        imageView = findViewById(R.id.image_view);
        start_des = findViewById(R.id.activity_object_animator_start_des);
        end_des = findViewById(R.id.activity_object_animator_end_des);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(new AttributeAnimationAdapter(initData(), new AttributeAnimationAdapter.AnimationCallBack() {
            @SuppressLint("SetTextI18n")
            @Override
            public void callBack(Animator animator) {

                animator.addListener(new Animator.AnimatorListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationStart(Animator animation) {
                        //动画开始时结束，打印相关信息
                        showDes(start_des, "动画开始信息");
                    }

                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        //动画结束，打印相关信息
                        showDes(end_des, "动画结束信息");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.setDuration(1000);
                animator.start();
            }
        }));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showDes(TextView des, String tag) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tag).append("\n");
        stringBuilder.append("width,height [").append(imageView.getWidth()).append(",").append(imageView.getHeight()).append("]\n");
        stringBuilder.append("ScaleX,ScaleY [").append(imageView.getScaleX()).append(",").append(imageView.getScaleY()).append("]\n");
        stringBuilder.append("RotationX,Y [").append(imageView.getRotationX()).append(",").append(imageView.getRotationY()).append(",").append(imageView.getRotation()).append("]\n");
        stringBuilder.append("TranslationX,Y,Z [").append(imageView.getTranslationX()).append(",").append(imageView.getTranslationY()).append(",").append(imageView.getTranslationZ()).append("]\n");
        stringBuilder.append("alpha [").append(imageView.getAlpha()).append("]\n");

        des.setText(stringBuilder);
    }

    private List<AttributeAnimationAdapter.Bean> initData() {
        List<AttributeAnimationAdapter.Bean> list = new ArrayList<AttributeAnimationAdapter.Bean>();

        list.add(new AttributeAnimationAdapter.Bean("透明度动画(消失)", ObjectAnimator.ofFloat(imageView, "alpha", 1.0F, 0F, 1.0F, 0F)));
        list.add(new AttributeAnimationAdapter.Bean("透明度动画(出现)", ObjectAnimator.ofFloat(imageView, "alpha", 1.0F, 0F, 1.0F, 1.0F)));
        list.add(new AttributeAnimationAdapter.Bean("旋转X", ObjectAnimator.ofFloat(imageView, "rotationX", 0, 180)));
        list.add(new AttributeAnimationAdapter.Bean("旋转Y", ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180)));
        list.add(new AttributeAnimationAdapter.Bean("旋转", ObjectAnimator.ofFloat(imageView, "rotation", 0, -180)));
        list.add(new AttributeAnimationAdapter.Bean("平移X", ObjectAnimator.ofFloat(imageView, "translationX", 0, 90)));
        list.add(new AttributeAnimationAdapter.Bean("平移Y", ObjectAnimator.ofFloat(imageView, "translationY", 0, 90)));
        list.add(new AttributeAnimationAdapter.Bean("缩放X", ObjectAnimator.ofFloat(imageView, "scaleX", 1, 1.5f)));
        list.add(new AttributeAnimationAdapter.Bean("缩放Y", ObjectAnimator.ofFloat(imageView, "scaleY", 1, 1.5f)));


        return list;
    }

    private Animator createAnimator(String propertyName, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, propertyName, values);
        animator.setDuration(1000);
        return animator;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void resetView(View view) {
        imageView.setImageAlpha(255);
        imageView.setRotation(0);
        imageView.setRotationX(0);
        imageView.setRotationX(0);
        imageView.setTranslationX(0);
        imageView.setTranslationY(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setTranslationZ(0);
        }
        imageView.setScaleX(1);
        imageView.setScaleY(1);

        showDes(start_des, "重置信息");
    }
}