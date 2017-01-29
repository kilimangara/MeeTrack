package com.nikitazlain.meetrack;

import android.app.Application;

import com.nikitazlain.meetrack.restAPI.ApiFactory;


public class MetrackApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiFactory.getInstance().init();
        PreferenceHelper.getInstance().init(this);
    }
}
