package com.henderson.ant.holdthefrontpage.screens.camera.dagger;

import com.henderson.ant.holdthefrontpage.application.builder.AppComponent;
import com.henderson.ant.holdthefrontpage.screens.camera.CameraScreenActivity;

import dagger.Component;

/**
 * Created by Ant on 12/04/2017.
 */

@CameraScope
@Component(modules = {CameraContextModule.class, CameraModule.class}, dependencies = {AppComponent.class})
public interface CameraComponent {
    void inject(CameraScreenActivity activity);
}