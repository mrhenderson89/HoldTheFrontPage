package com.henderson.ant.holdthefrontpage.screens.splash.splash.dagger;

import com.henderson.ant.holdthefrontpage.screens.splash.splash.SplashScreenActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ant on 11/04/2017.
 */
@Module
public class SplashContextModule {

    SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity context) {
        this.splashContext = context;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext() {
        return splashContext;
    }


}