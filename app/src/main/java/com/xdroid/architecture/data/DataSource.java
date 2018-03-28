package com.xdroid.architecture.data;

import android.arch.lifecycle.LiveData;

import com.xdroid.architecture.data.local.db.entity.Girl;
import com.xdroid.architecture.data.local.db.entity.ZhihuStory;
import com.xdroid.architecture.data.remote.model.ZhihuStoryDetail;

import java.util.List;

public interface DataSource {

    /**
     * Girl 相关方法
     */
    LiveData<List<Girl>> getGirlList(int index);

    LiveData<Boolean> isLoadingGirlList();


    /**
     * Zhihu 相关方法
     */
    LiveData<List<ZhihuStory>> getLastZhihuList();

    LiveData<List<ZhihuStory>> getMoreZhihuList(String date);

    LiveData<ZhihuStoryDetail> getZhihuDetail(String id);

    LiveData<Boolean> isLoadingZhihuList();
}
