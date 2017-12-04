package com.williamjin.drawerlayout.gallery;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.williamjin.drawerlayout.R;

/**
 * Created by william on 12/3/17.
 */

public class GalleryFragment extends Fragment{
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.gallery_layout, container, false);
        return myView;
    }
}
