package com.henderson.ant.holdthefrontpage.screens.camera.dagger;

import com.henderson.ant.holdthefrontpage.screens.camera.CameraScreenActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ant on 12/04/2017.
 */
@Module
public class CameraContextModule {

    CameraScreenActivity CameraContext;

    public CameraContextModule(CameraScreenActivity context) {
        this.CameraContext = context;
    }

    @CameraScope
    @Provides
    CameraScreenActivity provideCameraContext() {
        return CameraContext;
    }


}