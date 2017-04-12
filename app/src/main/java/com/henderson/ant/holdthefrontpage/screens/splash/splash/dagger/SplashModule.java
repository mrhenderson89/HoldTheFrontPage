package com.henderson.ant.holdthefrontpage.screens.splash.splash.dagger;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.SplashScreenActivity;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp.SplashModel;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp.SplashPresenter;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp.SplashView;
import com.henderson.ant.holdthefrontpage.utils.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ant on 11/04/2017.
 */
@Module
public class SplashModule {

    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new SplashPresenter(model, schedulers, compositeSubscription);
    }


    @SplashScope
    @Provides
    SplashView provideSplashView(SplashScreenActivity context) {
        return new SplashView(context);
    }


    @SplashScope
    @Provides
    SplashModel provideSplashModel(HTFPapi api, SplashScreenActivity ctx) {
        return new SplashModel(api, ctx);
    }
}
