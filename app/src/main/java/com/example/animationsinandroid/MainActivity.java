package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.os.Handler;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout signinView;
    Button loginButton;
    ImageView unoloLogo;
    TextView signInTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinView = findViewById(R.id.signinView);
        loginButton = findViewById(R.id.loginButtonView);
        unoloLogo = findViewById(R.id.imageView3);
        signInTv = findViewById(R.id.textViewSignin);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final SpringAnimation animationSignInView = new SpringAnimation(signinView, DynamicAnimation.TRANSLATION_X, 0);
        final SpringAnimation animationloginBtn = new SpringAnimation(loginButton, DynamicAnimation.TRANSLATION_Y, 0);
        final SpringAnimation animationSignInTv = new SpringAnimation(signInTv, DynamicAnimation.X, 0);
        final SpringAnimation animationUnolo = new SpringAnimation(unoloLogo, DynamicAnimation.TRANSLATION_X, 0);

        SpringForce springForce = new SpringForce();

        Handler handler = new Handler();

        loginButton.setVisibility(View.GONE);
        unoloLogo.setVisibility(View.GONE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                unoloLogo.setVisibility(View.VISIBLE);
                springForce.setStiffness(SpringForce.STIFFNESS_LOW);
                springForce.setFinalPosition(-10);
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                animationUnolo.setSpring(springForce);
                animationUnolo.setStartVelocity(1000);
                animationUnolo.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loginButton.setVisibility(View.VISIBLE);
                        animationloginBtn.setSpring(springForce);
                        animationloginBtn.setStartVelocity(1000);
                        animationloginBtn.start();
                    }
                }, 500);
            }
        }, 500);

    }
}