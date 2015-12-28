package com.yanmii.kajianinfo.mvp.terbaru;

import android.support.annotation.NonNull;

import com.yanmii.kajianinfo.data.Audio;

import java.util.List;

public class TerbaruContract {

    public interface TerbaruView {

        void initViews();

        void showLoading(boolean showLoading);

        void showError(String message);

        void setItems(List<Audio> items);

        void onListItemClicked(@NonNull Audio audio);

    }

    public interface TerbaruPresenter{

        void onCreateView();

        void loadContent();

        void openDetail(@NonNull Audio audio);
    }
}
