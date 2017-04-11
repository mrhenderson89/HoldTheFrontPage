package com.henderson.ant.holdthefrontpage.utils.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

import timber.log.Timber;

/**
 * Created by Ant on 11/04/2017.
 */

public class UiUtils {

    public static void handleThrowable(Throwable throwable) {
        Timber.e(throwable, throwable.toString());
    }

    public static void showSnackbar(View view, String message, int length) {
        Snackbar.make(view, message, length).setAction("Action", null).show();
    }

}
