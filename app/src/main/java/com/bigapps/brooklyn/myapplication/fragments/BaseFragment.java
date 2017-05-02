package com.bigapps.brooklyn.myapplication.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import com.bigapps.brooklyn.myapplication.mvp.callback.ShowDetailsFragmentCallback;
import com.bigapps.brooklyn.myapplication.mvp.view.BaseView;

/**
 * Created by Brooklyn on 01-May-17.
 */

public class BaseFragment extends Fragment implements BaseView {

    BaseView mActivity;

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseView) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseView) activity;
    }

    @Override
    public void showProgress() {
        mActivity.showProgress();
    }

    @Override
    public void hideProgress() {
        mActivity.hideProgress();
    }

    @Override
    public void showError(String message) {
        mActivity.showError(message);
    }
}
