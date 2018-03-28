package com.xdroid.architecture.data.remote.api;

import com.xdroid.architecture.data.remote.model.GirlData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiGirl {

    @GET("api/data/福利/10/{index}")
    Call<GirlData> getGirlsData(@Path("index") int index);
}
