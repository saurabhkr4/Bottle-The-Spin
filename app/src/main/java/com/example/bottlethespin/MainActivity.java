package com.example.bottlethespin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private ImageView bottleImage;
    private Button spinButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottleImage = findViewById(R.id.bottleImage);
        spinButton = findViewById(R.id.spinButton);

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int degree;

                SecureRandom rand = new SecureRandom();
                degree = rand.nextInt(5000);

                RotateAnimation rotateAnimation = new RotateAnimation(0, degree, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(2000);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new AccelerateInterpolator());

                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.gamemusic);


                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mp.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mp.stop();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bottleImage.startAnimation(rotateAnimation);

            }
        });

    }
}