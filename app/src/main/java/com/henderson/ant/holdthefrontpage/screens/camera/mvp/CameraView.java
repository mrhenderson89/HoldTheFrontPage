package com.henderson.ant.holdthefrontpage.screens.camera.mvp;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.henderson.ant.holdthefrontpage.R;
import com.henderson.ant.holdthefrontpage.screens.camera.CameraScreenActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ant on 12/04/2017.
 */
public class CameraView {

    private View view;
    @BindView (R.id.cameraTexture) TextureView cameraPrev;

    public CameraView(CameraScreenActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_camera, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }
}
