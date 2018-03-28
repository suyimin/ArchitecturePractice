package com.xdroid.architecture.data;

import android.app.Application;

import com.xdroid.architecture.data.local.LocalDataSource;
import com.xdroid.architecture.data.remote.RemoteDataSource;

public class Injection {

    public static DataRepository getDataRepository(Application application) {
        return DataRepository.getInstance(RemoteDataSource.getInstance(),
                LocalDataSource.getInstance(), application);
    }
}
