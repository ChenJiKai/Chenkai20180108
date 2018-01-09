package com.example.lianxi.net;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by wsq on 2017/12/12.
 */

public class MyApp extends Application {
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        edit = sp.edit();
    }
}
