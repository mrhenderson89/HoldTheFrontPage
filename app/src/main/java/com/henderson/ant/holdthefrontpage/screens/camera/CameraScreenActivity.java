package com.henderson.ant.holdthefrontpage.screens.camera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.henderson.ant.holdthefrontpage.CameraActivity;
import com.henderson.ant.holdthefrontpage.application.AppController;
import com.henderson.ant.holdthefrontpage.screens.camera.dagger.CameraContextModule;
import com.henderson.ant.holdthefrontpage.screens.camera.dagger.DaggerCameraComponent;
import com.henderson.ant.holdthefrontpage.screens.camera.mvp.CameraPresenter;
import com.henderson.ant.holdthefrontpage.screens.camera.mvp.CameraView;

import javax.inject.Inject;

/**
 * Created by Ant on 12/04/2017.
 */

public class CameraScreenActivity  extends AppCompatActivity {

    @Inject
    CameraView view;
    @Inject
    CameraPresenter cameraPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCameraComponent.builder().
                appComponent(AppController.getNetComponent()).
                cameraContextModule(new CameraContextModule(this)).
                build().inject(this);

        setContentView(view.constructView());
        cameraPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraPresenter.onDestroy();
    }

    public void showHeroesListActivity() {
        Log.d("loaded", "ok showed");
        Intent i = new Intent(this, CameraActivity.class);
        startActivity(i);
    }
}
