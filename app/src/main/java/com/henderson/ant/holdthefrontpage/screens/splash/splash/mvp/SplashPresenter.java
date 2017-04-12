package com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp;

import android.util.Log;

import com.henderson.ant.holdthefrontpage.utils.utils.UiUtils;
import com.henderson.ant.holdthefrontpage.utils.utils.rx.RxSchedulers;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ant on 11/04/2017.
 */

public class SplashPresenter {


    private SplashModel model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscriptions;


    public SplashPresenter(SplashModel model, RxSchedulers schedulers, CompositeSubscription subscriptions) {
        this.model = model;
        this.rxSchedulers = schedulers;
        this.subscriptions = subscriptions;
    }


    public void onCreate() {
        //subscriptions.add(getHeroesList());
        model.gotoCameraScreenActivity();
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
                observeOn(rxSchedulers.androidThread()).subscribe(aBoolean -> model.gotoCameraScreenActivity(), throwable -> UiUtils.handleThrowable(throwable));
    }
}
