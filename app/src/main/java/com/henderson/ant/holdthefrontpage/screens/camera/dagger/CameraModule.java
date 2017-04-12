package com.henderson.ant.holdthefrontpage.screens.camera.dagger;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;
import com.henderson.ant.holdthefrontpage.screens.camera.CameraScreenActivity;
import com.henderson.ant.holdthefrontpage.screens.camera.mvp.CameraModel;
import com.henderson.ant.holdthefrontpage.screens.camera.mvp.CameraPresenter;
import com.henderson.ant.holdthefrontpage.screens.camera.mvp.CameraView;
import com.henderson.ant.holdthefrontpage.utils.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ant on 12/04/2017.
 */
@Module
public class CameraModule {

    @CameraScope
    @Provides
    CameraPresenter providePresenter(RxSchedulers schedulers, CameraModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new CameraPresenter(model, schedulers, compositeSubscription);
    }


    @CameraScope
    @Provides
    CameraView provideCameraView(CameraScreenActivity context) {
        return new CameraView(context);
    }


    @CameraScope
    @Provides
    CameraModel provideCameraModel(HTFPapi api, CameraScreenActivity ctx) {
        return new CameraModel(api, ctx);
    }
}