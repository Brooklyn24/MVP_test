package com.bigapps.brooklyn.myapplication.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bigapps.brooklyn.myapplication.R;
import com.bigapps.brooklyn.myapplication.mvp.view.BaseView;

/**
 * Created by Brooklyn on 27-Apr-17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    protected Dialog progressDialog;

    protected void showProgressDialog() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            Log.d("logz", "showProgressDialog: ");
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
            if (!isFinishing()) {
                progressDialog.show();
            }
        }
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            if (!isFinishing()) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(findViewById(R.id.mainLayout), message, Snackbar.LENGTH_LONG).show();
    }

}
