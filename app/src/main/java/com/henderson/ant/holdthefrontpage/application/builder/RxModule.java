package com.henderson.ant.holdthefrontpage.application.builder;

import com.henderson.ant.holdthefrontpage.utils.utils.rx.AppRxSchedulers;
import com.henderson.ant.holdthefrontpage.utils.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ant on 12/04/2017.
 */
@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}