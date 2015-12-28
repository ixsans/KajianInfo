package com.yanmii.kajianinfo.mvp.detailaudio;

import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.mvp.base.BaseView;

public class DetailAudioContract {

    public interface DetailAudioView extends BaseView{

        void initViews();

        void setAudio(Audio audio);

    }

    public interface DetailAudioPresenter{

        void onCreateView();

        void loadContent(String audioId);

    }
}
