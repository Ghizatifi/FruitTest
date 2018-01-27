package com.example.izza.quiz;

import android.graphics.Color;
import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config=new EasySplashScreen(SplashMain.this)
        .withFullScreen()
        .withTargetActivity(Categ.class)
        .withSplashTimeOut(1000)
        .withBackgroundResource(R.drawable.background)
        //.withBackgroundColor(Color.parseColor("#f6acad"))
        .withLogo(R.drawable.quiz1)
        .withHeaderText("Welcom Guest !");

        config.getHeaderTextView().setTextColor(Color.parseColor("#732b2a"));

        View view=config.create();
        setContentView(view);
    }
}
