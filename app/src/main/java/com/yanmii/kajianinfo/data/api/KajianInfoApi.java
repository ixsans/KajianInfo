package com.yanmii.kajianinfo.data.api;

import com.yanmii.kajianinfo.configs.ApiConfig;

import retrofit.RestAdapter;

public class KajianInfoApi {
    public static <S> S createService(Class<S> serviceClass) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ApiConfig.BASE_URL)
                .build();


        return restAdapter.create(serviceClass);
    }
}
