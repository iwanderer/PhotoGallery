package com.example.leslie.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by leslie on 2016/8/15.
 */
public class PhotoGalleryFragment extends Fragment {
    private static final String TAG = "PhotoGalleryFragment";
    private GridView mGridView;
    private ArrayList<GalleryItem> mItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        new FetchItemsTask().execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery_photo, container, false);
        mGridView = (GridView) v.findViewById(R.id.gridView);
        setupAdapter();
        return v;
    }

    private void setupAdapter() {
        if (getActivity() == null || mGridView == null) return;

        if (mItems != null) {
            mGridView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_gallery_item, mItems));
        } else {
            mGridView.setAdapter(null);
        }
    }


    private class FetchItemsTask extends AsyncTask<Void, Void, ArrayList<GalleryItem>> {

        @Override
        protected ArrayList<GalleryItem> doInBackground(Void... voids) {
            return new FlickrFetchr().fetchItems();
        }

        @Override
        protected void onPostExecute(ArrayList<GalleryItem> galleryItems) {
            mItems = galleryItems;
            setupAdapter();
        }
    }
}
