package com.henderson.ant.holdthefrontpage.application;

import android.app.Application;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;
import com.henderson.ant.holdthefrontpage.application.builder.AppComponent;
import com.henderson.ant.holdthefrontpage.application.builder.AppContextModule;
import com.henderson.ant.holdthefrontpage.application.builder.DaggerAppComponent;

import dagger.Component;
import timber.log.BuildConfig;
import timber.log.Timber;

/**
 * Created by Ant on 11/04/2017.
 */

public class AppController extends Application {

    // il nous faut le context App context
    // retrofit
    // Okhttpclient                                  GsonFactory               RxApadter
    //  Logging Interceptor &&  Cache
    //                          File cache


    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

    }


    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }


    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }

}