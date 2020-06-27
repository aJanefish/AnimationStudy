package com.example.animationstudy.attributeanimation;


import android.animation.Animator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
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

public class TimeAnimatorActivity extends BaseActivity {

    private static final String TAG = "TimeAnimatorActivity";
    private ImageView imageView;
    private TextView start_des;
    private TextView end_des;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_time_animator;
    }


    @Override
    protected void initView() {

        imageView = findViewById(R.id.image_view);
        start_des = findViewById(R.id.start_des);
        end_des = findViewById(R.id.end_des);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(new AttributeAnimationAdapter(initData(), new AttributeAnimationAdapter.AnimationCallBack() {
            @SuppressLint("SetTextI18n")
            @Override
            public void callBack(Animator animator) {

                if (animator instanceof TimeAnimator) {
                    TimeAnimator timeAnimator = (TimeAnimator) animator;
                    timeAnimator.setTimeListener(new TimeAnimator.TimeListener() {
                        @Override
                        public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                            //animation:发出通知的动画
                            //totalTime:动画开始以来的总时间,以毫秒为单位
                            //deltaTime:从前一帧到现在的运行时间,以毫秒为单位
                            Log.d(TAG, "totalTime, " + totalTime + " deltaTime, " + deltaTime);
                        }
                    });
                }
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

    private Animator createAnimator(int type) {
        if (type == 1) {
            ValueAnimator animator = TimeAnimator.ofFloat(0, -90f, 0, 180f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setRotationX(ff);
                }
            });
            return animator;
        } else if (type == 2) {
            ValueAnimator animator = TimeAnimator.ofFloat(0, -90f, 0, 180f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setRotationY(ff);
                }
            });
            return animator;
        } else if (type == 3) {
            ValueAnimator animator = TimeAnimator.ofFloat(0, -90f, 0, 180f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setRotation(ff);
                }
            });
            return animator;
        }
        return null;
    }

    private List<AttributeAnimationAdapter.Bean> initData() {
        List<AttributeAnimationAdapter.Bean> list = new ArrayList<AttributeAnimationAdapter.Bean>();

        list.add(new AttributeAnimationAdapter.Bean("旋转X", createAnimator(1)));
        list.add(new AttributeAnimationAdapter.Bean("旋转Y", createAnimator(2)));
        list.add(new AttributeAnimationAdapter.Bean("旋转", createAnimator(3)));
        return list;
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