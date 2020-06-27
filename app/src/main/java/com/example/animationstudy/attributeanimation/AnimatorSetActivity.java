package com.example.animationstudy.attributeanimation;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;


import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;

/**
 * 组合动画
 */
public class AnimatorSetActivity extends BaseActivity {


    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private TextView start_des;
    private TextView end_des;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator_set;
    }


    @Override
    protected void initView() {

        imageView1 = findViewById(R.id.image_view_1);
        imageView2 = findViewById(R.id.image_view_2);
        imageView3 = findViewById(R.id.image_view_3);
        imageView4 = findViewById(R.id.image_view_4);
        imageView5 = findViewById(R.id.image_view_5);
        imageView6 = findViewById(R.id.image_view_6);
        start_des = findViewById(R.id.start_des);
        end_des = findViewById(R.id.end_des);

    }

    public void open1(View view) {


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.playTogether(initOpenAnimator(200));
        animatorSet.start();
    }


    public void open2(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playSequentially(initOpenAnimator(200));
        animatorSet.start();
    }

    public void open3(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playSequentially(initOpenAnimator3(200));
        animatorSet.start();
    }

    private List<Animator> initOpenAnimator(float r) {
        List<Animator> animators = new ArrayList<>();
        //animators.add(ObjectAnimator.ofFloat(imageView1, "translationX", 0, 0));
        animators.add(ObjectAnimator.ofFloat(imageView1, "translationY", 0, -r));

        animators.add(ObjectAnimator.ofFloat(imageView2, "translationX", 0, (float) (r * Math.cos(PI / 3))));
        animators.add(ObjectAnimator.ofFloat(imageView2, "translationY", 0, (float) -(r * Math.sin(PI / 3))));

        animators.add(ObjectAnimator.ofFloat(imageView3, "translationX", 0, (float) (r * Math.cos(PI / 4))));
        animators.add(ObjectAnimator.ofFloat(imageView3, "translationY", 0, (float) -(r * Math.sin(PI / 4))));

        animators.add(ObjectAnimator.ofFloat(imageView4, "translationX", 0, (float) (r * Math.cos(PI / 6))));
        animators.add(ObjectAnimator.ofFloat(imageView4, "translationY", 0, (float) -(r * Math.sin(PI / 6))));

        animators.add(ObjectAnimator.ofFloat(imageView5, "translationX", 0, r));
        //animators.add(ObjectAnimator.ofFloat(imageView5, "translationY", 0, 0));
        return animators;
    }

    private List<Animator> initOpenAnimator3(float r) {
        List<Animator> animators = new ArrayList<>();
        animators.add(ObjectAnimator.ofFloat(imageView1, "translationY", 0, -r));
        //animators.add(ObjectAnimator.ofFloat(imageView1, "translationX", 0, 0));

        animators.add(ObjectAnimator.ofFloat(imageView2, "translationY", 0, (float) -(r * Math.sin(PI / 3))));
        animators.add(ObjectAnimator.ofFloat(imageView2, "translationX", 0, (float) (r * Math.cos(PI / 3))));

        animators.add(ObjectAnimator.ofFloat(imageView3, "translationY", 0, (float) -(r * Math.sin(PI / 4))));
        animators.add(ObjectAnimator.ofFloat(imageView3, "translationX", 0, (float) (r * Math.cos(PI / 4))));

        animators.add(ObjectAnimator.ofFloat(imageView4, "translationY", 0, (float) -(r * Math.sin(PI / 6))));
        animators.add(ObjectAnimator.ofFloat(imageView4, "translationX", 0, (float) (r * Math.cos(PI / 6))));

        //animators.add(ObjectAnimator.ofFloat(imageView5, "translationY", 0, 0));
        animators.add(ObjectAnimator.ofFloat(imageView5, "translationX", 0, r));
        return animators;
    }

    private List<Animator> initCloseAnimator(float r) {
        List<Animator> animators = new ArrayList<>();
        //animators.add(ObjectAnimator.ofFloat(imageView1, "translationX", 0, 0));
        animators.add(ObjectAnimator.ofFloat(imageView1, "translationY", -r, 0));

        animators.add(ObjectAnimator.ofFloat(imageView2, "translationX", (float) (r * Math.cos(PI / 3)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView2, "translationY", (float) -(r * Math.sin(PI / 3)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView3, "translationX", (float) (r * Math.cos(PI / 4)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView3, "translationY", (float) -(r * Math.sin(PI / 4)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView4, "translationX", (float) (r * Math.cos(PI / 6)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView4, "translationY", (float) -(r * Math.sin(PI / 6)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView5, "translationX", r, 0));
        //animators.add(ObjectAnimator.ofFloat(imageView5, "translationY", 0, 0));
        return animators;
    }

    public void close1(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playTogether(initCloseAnimator(200));
        animatorSet.start();
    }

    public void close2(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playSequentially(initCloseAnimator(200));
        animatorSet.start();
    }

    public void close3(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playSequentially(initCloseAnimator3(200));
        animatorSet.start();
    }

    private List<Animator> initCloseAnimator3(int r) {

        List<Animator> animators = new ArrayList<>();
        animators.add(ObjectAnimator.ofFloat(imageView1, "translationY", -r, 0));
        //animators.add(ObjectAnimator.ofFloat(imageView1, "translationX", 0, 0));

        animators.add(ObjectAnimator.ofFloat(imageView2, "translationY", (float) -(r * Math.sin(PI / 3)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView2, "translationX", (float) (r * Math.cos(PI / 3)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView3, "translationY", (float) -(r * Math.sin(PI / 4)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView3, "translationX", (float) (r * Math.cos(PI / 4)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView4, "translationY", (float) -(r * Math.sin(PI / 6)), 0));
        animators.add(ObjectAnimator.ofFloat(imageView4, "translationX", (float) (r * Math.cos(PI / 6)), 0));
        //animators.add(ObjectAnimator.ofFloat(imageView5, "translationY", 0, 0));
        animators.add(ObjectAnimator.ofFloat(imageView5, "translationX", r, 0));
        return animators;
    }

}