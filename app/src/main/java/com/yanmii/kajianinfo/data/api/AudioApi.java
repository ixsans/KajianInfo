package com.yanmii.kajianinfo.data.api;



import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.data.AudioListResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface AudioApi {

//    @GET("/audio/index")
//    void getTerbaru(Callback<String> callback);

    @GET("/audio/index")
    Observable<AudioListResponse> getTerbaru();

    @GET("/audio/top")
    Observable<AudioListResponse> getPopuler();

    @GET("/audio/show/{id}")
    Observable<Audio> getDetailAudio(@Path("id") String id);
}
