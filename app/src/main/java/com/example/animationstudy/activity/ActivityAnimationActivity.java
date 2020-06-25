package com.example.animationstudy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.animationstudy.R;

public class ActivityAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
    }

    public void button(View view) {
        startActivity(new Intent(this, ActivityAnimationActivity.class));
        overridePendingTransition(R.anim.activity_enter_one, R.anim.activity_exit);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }
}