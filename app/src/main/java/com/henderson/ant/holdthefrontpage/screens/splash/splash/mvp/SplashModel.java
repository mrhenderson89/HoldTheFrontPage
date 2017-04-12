package com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.SplashScreenActivity;
import com.henderson.ant.holdthefrontpage.utils.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by Ant on 11/04/2017.
 */

public class SplashModel {
    private HTFPapi api;
    private SplashScreenActivity splashContext;

    public SplashModel(HTFPapi api, SplashScreenActivity splashCtx) {
        this.api = api;
        this.splashContext = splashCtx;

    }

    Observable<String> provideListHeroes() {
        return api.getArticles();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }


//    public void gotoHeroesListActivity() {
//        //splashContext.showHeroesListActivity();
//
//    }
    public void gotoCameraScreenActivity() {
        splashContext.showCameraScreenActivity();

    }

}
