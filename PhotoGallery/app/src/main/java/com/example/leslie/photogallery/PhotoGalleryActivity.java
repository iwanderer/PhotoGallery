package com.example.leslie.photogallery;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhotoGalleryActivity extends SingleActivityFragment {


    @Override
    protected Fragment createFragment() {
        return new PhotoGalleryFragment();
    }
}
