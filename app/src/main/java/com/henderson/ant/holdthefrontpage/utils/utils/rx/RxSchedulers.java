package com.henderson.ant.holdthefrontpage.utils.utils.rx;

import rx.Scheduler;

/**
 * Created by Ant on 11/04/2017.
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
