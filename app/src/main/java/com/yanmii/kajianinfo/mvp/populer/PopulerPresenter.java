package com.yanmii.kajianinfo.mvp.populer;

import android.support.annotation.NonNull;

import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.data.AudioListResponse;
import com.yanmii.kajianinfo.data.api.AudioApi;
import com.yanmii.kajianinfo.data.api.KajianInfoApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PopulerPresenter implements PopulerContract.PopulerPresenter{

    PopulerContract.PopulerView mView;

    public PopulerPresenter(PopulerContract.PopulerView mView){
        this.mView = mView;
    }

    @Override
    public void loadContent() {
        mView.showLoading(true);

        AudioApi audioApi = KajianInfoApi.createService(AudioApi.class);
        audioApi.getPopuler()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AudioListResponse>() {
                    @Override
                    public void onCompleted() {
                        mView.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                        mView.showLoading(false);
                    }

                    @Override
                    public void onNext(AudioListResponse audioListResponse) {
                        mView.setItems(audioListResponse.getAudios());
                        mView.showLoading(false);
                    }
                });

    }

    @Override
    public void openDetail(@NonNull Audio audio) {
        mView.onListItemClicked(audio);
    }

    @Override
    public void onCreateView() {
        mView.initViews();
    }
}
