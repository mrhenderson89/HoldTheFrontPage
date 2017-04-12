package com.henderson.ant.holdthefrontpage.screens.splash.splash.dagger;

import com.henderson.ant.holdthefrontpage.application.builder.AppComponent;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.SplashScreenActivity;

import dagger.Component;

/**
 * Created by Ant on 11/04/2017.
 */

@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}