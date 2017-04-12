package com.henderson.ant.holdthefrontpage.screens.camera.mvp;

import android.util.Log;

import com.henderson.ant.holdthefrontpage.utils.utils.UiUtils;
import com.henderson.ant.holdthefrontpage.utils.utils.rx.RxSchedulers;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ant on 12/04/2017.
 */

public class CameraPresenter {


    private CameraModel model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscriptions;


    public CameraPresenter(CameraModel model, RxSchedulers schedulers, CompositeSubscription subscriptions) {
        this.model = model;
        this.rxSchedulers = schedulers;
        this.subscriptions = subscriptions;
    }


    public void onCreate() {
        //subscriptions.add(getHeroesList());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription getHeroesList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.isNetworkAvailable()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(aBoolean -> model.gotoHeroesListActivity(), throwable -> UiUtils.handleThrowable(throwable));
    }
}