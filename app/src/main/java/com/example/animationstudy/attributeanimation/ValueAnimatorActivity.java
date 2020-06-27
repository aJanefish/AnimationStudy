package com.example.animationstudy.attributeanimation;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
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

public class ValueAnimatorActivity extends BaseActivity {

    private ImageView imageView;
    private TextView start_des;
    private TextView end_des;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_value_animator;
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
            ValueAnimator animator = ValueAnimator.ofFloat(0, -100f, 0, 100f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setTranslationX(ff);
                }
            });
            return animator;
        } else if (type == 2) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -100f, 0, 100f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setTranslationY(ff);
                }
            });
            return animator;
        } else if (type == 3) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -100f, 0, 100f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setTranslationZ(ff);
                }
            });
            return animator;
        } else if (type == 4) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -100f, 0, 100f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setTranslationX(ff);
                    imageView.setTranslationY(ff);
                    imageView.setTranslationZ(ff);
                }
            });
            return animator;
        } else if (type == 5) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -90f, 0, 180f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setRotationX(ff);
                }
            });
            return animator;
        } else if (type == 6) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -90f, 0, 180f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setRotationY(ff);
                }
            });
            return animator;
        } else if (type == 7) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -90f, 0, 180f);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setRotation(ff);
                }
            });
            return animator;
        } else if (type == 8) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -3, 0, 3);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setScaleX(ff);
                }
            });
            return animator;
        } else if (type == 9) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -3, 0, 3);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setScaleY(ff);
                }
            });
            return animator;
        } else if (type == 10) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, -3, 0, 3);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setScaleX(ff);
                    imageView.setScaleY(ff);
                }
            });
            return animator;
        } else if (type == 11) {
            ValueAnimator animator = ValueAnimator.ofFloat(1, 0, 1);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float ff = (float) animation.getAnimatedValue();
                    imageView.setAlpha(ff);
                }
            });
            return animator;
        } else if (type == 12) {
            ValueAnimator animator = ValueAnimator.ofArgb(Color.RED, Color.GREEN);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int color = (int) animation.getAnimatedValue();
                    start_des.setTextColor(color);
                }
            });
            return animator;
        } else if (type == 13) {
            ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator() {
                @Override
                public Object evaluate(float fraction, Object startValue, Object endValue) {
                    return null;
                }
            }, Color.RED, Color.GREEN);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int color = (int) animation.getAnimatedValue();
                    start_des.setTextColor(color);
                }
            });
            return animator;
        }
        return null;
    }

    private List<AttributeAnimationAdapter.Bean> initData() {
        List<AttributeAnimationAdapter.Bean> list = new ArrayList<AttributeAnimationAdapter.Bean>();

        list.add(new AttributeAnimationAdapter.Bean("平移动画X", createAnimator(1)));
        list.add(new AttributeAnimationAdapter.Bean("平移动画Y", createAnimator(2)));
        list.add(new AttributeAnimationAdapter.Bean("平移动画Z", createAnimator(3)));
        list.add(new AttributeAnimationAdapter.Bean("平移动画", createAnimator(4)));
        list.add(new AttributeAnimationAdapter.Bean("旋转动画X", createAnimator(5)));
        list.add(new AttributeAnimationAdapter.Bean("旋转动画Y", createAnimator(6)));
        list.add(new AttributeAnimationAdapter.Bean("旋转动画", createAnimator(7)));
        list.add(new AttributeAnimationAdapter.Bean("缩放X", createAnimator(8)));
        list.add(new AttributeAnimationAdapter.Bean("缩放Y", createAnimator(9)));
        list.add(new AttributeAnimationAdapter.Bean("缩放", createAnimator(10)));
        list.add(new AttributeAnimationAdapter.Bean("Alpha", createAnimator(11)));
        list.add(new AttributeAnimationAdapter.Bean("颜色", createAnimator(12)));
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