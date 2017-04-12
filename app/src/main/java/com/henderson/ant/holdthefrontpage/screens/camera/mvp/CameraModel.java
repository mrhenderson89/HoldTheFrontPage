package com.henderson.ant.holdthefrontpage.screens.camera.mvp;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;
import com.henderson.ant.holdthefrontpage.screens.camera.CameraScreenActivity;
import com.henderson.ant.holdthefrontpage.utils.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by Ant on 12/04/2017.
 */
public class CameraModel {
    private HTFPapi api;
    private CameraScreenActivity CameraContext;

    public CameraModel(HTFPapi api, CameraScreenActivity CameraCtx) {
        this.api = api;
        this.CameraContext = CameraCtx;

    }

    Observable<String> provideListHeroes() {
        return api.getArticles();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(CameraContext);
    }


    public void gotoHeroesListActivity() {
        CameraContext.showHeroesListActivity();

    }

}
