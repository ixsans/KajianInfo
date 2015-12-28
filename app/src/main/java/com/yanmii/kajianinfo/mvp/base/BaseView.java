package com.yanmii.kajianinfo.mvp.base;

public interface BaseView {
    void initViews();

    void showLoading(boolean showLoading);

    void showError(String message);
}
