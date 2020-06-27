package com.example.animationstudy.attributeanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;

import com.example.animationstudy.BaseActivity;
import com.example.animationstudy.R;

public class ObjectAnimatorTestActivity extends BaseActivity {

    private TextView des;
    private Point point;

    @Override
    protected void initView() {
        des = findViewById(R.id.activity_value_animator_test_des);
        point = new Point(0, 0, des);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_value_animator_test;
    }

    public void onTest(View view) {
        des.setText(point.toString());
        AnimatorSet animatorSet = new AnimatorSet();


        animatorSet.playSequentially(ObjectAnimator.ofInt(point, "X", 0, 1000),
                ObjectAnimator.ofInt(point, "Y", 0, 1000));

        animatorSet.setDuration(2000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                des.setText(point.toString());
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }


    private static class Point {
        int x;
        int y;
        TextView des;

        public Point(int x, int y, TextView des) {
            this.x = x;
            this.y = y;
            this.des = des;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            des.setText(this.toString());
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            des.setText(this.toString());
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}