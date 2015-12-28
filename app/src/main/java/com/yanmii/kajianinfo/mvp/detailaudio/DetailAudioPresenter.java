package com.yanmii.kajianinfo.mvp.detailaudio;

import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.data.api.AudioApi;
import com.yanmii.kajianinfo.data.api.KajianInfoApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailAudioPresenter implements DetailAudioContract.DetailAudioPresenter{

    DetailAudioContract.DetailAudioView mView;

    public DetailAudioPresenter(DetailAudioContract.DetailAudioView mView){
        this.mView = mView;
    }


    @Override
    public void onCreateView() {
        mView.initViews();
    }

    @Override
    public void loadContent(String audioId) {
        mView.showLoading(true);
        AudioApi audioApi = KajianInfoApi.createService(AudioApi.class);
        audioApi.getDetailAudio(audioId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Audio>() {
                    @Override
                    public void onCompleted() {
                        mView.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showLoading(false);
                    }

                    @Override
                    public void onNext(Audio audio) {
                        mView.showLoading(false);
                        mView.setAudio(audio);
                    }
                });
    }
}
