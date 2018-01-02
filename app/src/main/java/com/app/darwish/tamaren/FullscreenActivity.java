package com.app.darwish.tamaren;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.zip.Inflater;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity implements Runnable {

    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        logo=(ImageView)findViewById(R.id.logo_home);
        Animation animation= AnimationUtils.loadAnimation(getApplication(), R.animator.logo_animate);
        logo.startAnimation(animation);



    }

    @Override
    protected void onResume() {
        super.onResume();
        Thread c=new Thread(this);
        c.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
            startActivity(new Intent(this ,Athountcation.class));

        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(),e.getMessage());
        }
    }
}
