package com.bigapps.brooklyn.myapplication.mvp.view;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showError(String message);

}
