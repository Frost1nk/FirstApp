package com.production.firstapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;

public class App extends Application {
    private static final int MAX_SIZE = 10_000_000;
    public static final String TAG = "APP";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        GlideBuilder builder = new GlideBuilder();

        builder.setDiskCache( new InternalCacheDiskCacheFactory(this, MAX_SIZE));
        builder.setMemoryCache(new LruResourceCache(MAX_SIZE));
        builder.setBitmapPool(new LruBitmapPool(MAX_SIZE));

        GlideApp.init(this,builder);
    }

    protected void attachBaseContext(Context context){
        super.attachBaseContext(context);
    }
}
