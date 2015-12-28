package com.yanmii.kajianinfo.mvp.terbaru;

import android.support.annotation.NonNull;

import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.data.AudioListResponse;
import com.yanmii.kajianinfo.data.api.AudioApi;
import com.yanmii.kajianinfo.data.api.KajianInfoApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TerbaruPresenter implements TerbaruContract.TerbaruPresenter{

    TerbaruContract.TerbaruView mView;

    public TerbaruPresenter(TerbaruContract.TerbaruView view){
        this.mView = view;
    }

    @Override
    public void onCreateView() {
        mView.initViews();
    }

    @Override
    public void loadContent() {
        mView.showLoading(true);

        AudioApi audioApi = KajianInfoApi.createService(AudioApi.class);
        audioApi.getTerbaru()
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

}
