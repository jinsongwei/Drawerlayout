package com.williamjin.drawerlayout.camera;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.williamjin.drawerlayout.R;
import com.williamjin.drawerlayout.camera.CameraActivity;

/**
 * Created by william on 12/3/17.
 */

public class CameraFragment extends Fragment {
    View myView;
    Button btnCamera;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.camera_layout, container, false);
        return myView;
    }
}
