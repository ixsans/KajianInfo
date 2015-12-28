package com.yanmii.kajianinfo.mvp.populer;

import android.support.annotation.NonNull;

import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.mvp.base.BasePresenter;
import com.yanmii.kajianinfo.mvp.base.BaseView;

import java.util.List;

public class PopulerContract {
    public interface PopulerView extends BaseView {

        void setItems(List<Audio> items);

        void onListItemClicked(@NonNull Audio audio);

    }

    public interface PopulerPresenter extends BasePresenter{

        void loadContent();

        void openDetail(@NonNull Audio audio);
    }
}
