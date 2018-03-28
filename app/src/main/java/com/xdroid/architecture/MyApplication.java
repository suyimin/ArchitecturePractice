package com.xdroid.architecture;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.xdroid.architecture.data.local.db.AppDatabaseManager;
import com.xdroid.architecture.utils.Consts;


public class MyApplication extends Application {

    private static MyApplication INSTANCE = null;

    public static MyApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        AppDatabaseManager.getInstance().createDB(this);
        if (Consts.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
