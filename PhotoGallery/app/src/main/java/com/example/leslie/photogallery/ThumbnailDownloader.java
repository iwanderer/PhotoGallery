package com.example.leslie.photogallery;

import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by leslie on 2016/8/24.
 */
public class ThumbnailDownloader<T> extends HandlerThread {
    private static final String TAG = "ThumbnailDownlader";

    public ThumbnailDownloader() {
        super(TAG);
    }

    public void queueThumbnail(T target, String url) {
        Log.d(TAG, "get an url: " + url);
    }
}
