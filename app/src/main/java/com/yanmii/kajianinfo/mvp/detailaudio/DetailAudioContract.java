package com.yanmii.kajianinfo.mvp.detailaudio;

import com.yanmii.kajianinfo.data.Audio;

public class DetailAudioContract {

    public interface DetailAudioView {

        void initViews();

        void showLoading(boolean showLoading);

        void showError(String message);

        void setAudio(Audio audio);

    }

    public interface DetailAudioPresenter{

        void onCreateView();

        void loadContent(String audioId);

    }
}
