package com.xdroid.architecture.data.remote.api;

import com.xdroid.architecture.data.remote.model.ZhihuData;
import com.xdroid.architecture.data.remote.model.ZhihuStoryDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiZhihu {

    @GET("api/4/news/latest")
    Call<ZhihuData> getLatestNews();

    @GET("/api/4/news/before/{date}")
    Call<ZhihuData> getTheDaily(@Path("date") String date);

    @GET("api/4/news/{id}")
    Call<ZhihuStoryDetail> getZhiHuStoryDetail(@Path("id") String id);
}
