package com.henderson.ant.holdthefrontpage.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ant on 11/04/2017.
 */

@Module
public class AppContextModule {


    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}