package com.henderson.ant.holdthefrontpage.application.builder;

import android.content.Context;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;
import com.henderson.ant.holdthefrontpage.utils.utils.rx.RxSchedulers;

import dagger.Component;

/**
 * Created by Ant on 11/04/2017.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, HTFPapiServiceModule.class})
public interface AppComponent {


    Context getAppContext();

    RxSchedulers rxSchedulers();


    HTFPapi apiService();


    // void inject(MainActivity activity);
    //Retrofit provideNetworkApi();

}