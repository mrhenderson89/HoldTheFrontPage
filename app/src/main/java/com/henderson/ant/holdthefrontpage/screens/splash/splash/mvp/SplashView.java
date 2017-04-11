package com.henderson.ant.holdthefrontpage.screens.splash.splash.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.henderson.ant.holdthefrontpage.R;
import com.henderson.ant.holdthefrontpage.screens.splash.splash.SplashScreenActivity;

import butterknife.ButterKnife;

/**
 * Created by Ant on 11/04/2017.
 */

public class SplashView {

    private View view;

    public SplashView(SplashScreenActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash_screen, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }
}
