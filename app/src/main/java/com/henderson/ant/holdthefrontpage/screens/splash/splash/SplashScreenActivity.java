package com.henderson.ant.holdthefrontpage.screens.splash.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.henderson.ant.holdthefrontpage.application.AppController;
import com.henderson.ant.holdthefrontpage.screens.camera.CameraScreenActivity;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.dagger.DaggerSplashComponent;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.dagger.SplashContextModule;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp.SplashPresenter;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp.SplashView;

import javax.inject.Inject;

public class SplashScreenActivity extends AppCompatActivity {

    @Inject
    SplashView view;
    @Inject
    SplashPresenter splashPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSplashComponent.builder().
                appComponent(AppController.getNetComponent()).
                splashContextModule(new SplashContextModule(this)).
                build().inject(this);

        setContentView(view.constructView());
        splashPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }

    public void showCameraScreenActivity() {
        Log.d("loaded", "ok showed");
        Intent i = new Intent(this, CameraScreenActivity.class);
        startActivity(i);
    }
    }
