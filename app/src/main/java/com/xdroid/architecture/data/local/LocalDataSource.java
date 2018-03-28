package com.xdroid.architecture.data.local;

import android.arch.lifecycle.LiveData;

import com.xdroid.architecture.data.DataSource;
import com.xdroid.architecture.data.local.db.AppDatabaseManager;
import com.xdroid.architecture.data.local.db.entity.Girl;
import com.xdroid.architecture.data.local.db.entity.ZhihuStory;
import com.xdroid.architecture.data.remote.model.ZhihuStoryDetail;

import java.util.List;

public class LocalDataSource implements DataSource {

    private static LocalDataSource INSTANCE = null;

    private LocalDataSource() {
    }

    public static LocalDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSource();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Girl>> getGirlList(int index) {
        return AppDatabaseManager.getInstance().loadGirlList();
    }

    @Override
    public LiveData<Boolean> isLoadingGirlList() {
        return AppDatabaseManager.getInstance().isLoadingGirlList();
    }

    @Override
    public LiveData<List<ZhihuStory>> getLastZhihuList() {
        return AppDatabaseManager.getInstance().loadZhihuList();
    }

    @Override
    public LiveData<List<ZhihuStory>> getMoreZhihuList(String date) {
        return null;
    }

    @Override
    public LiveData<ZhihuStoryDetail> getZhihuDetail(String id) {
        return null;
    }

    @Override
    public LiveData<Boolean> isLoadingZhihuList() {
        return AppDatabaseManager.getInstance().isLoadingZhihuList();
    }
}
