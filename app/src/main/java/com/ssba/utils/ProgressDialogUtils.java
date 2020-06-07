package com.ssba.utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by psk on 11/19/2017.
 */

public class ProgressDialogUtils
{
    private ProgressDialog progressDialog;

    public ProgressDialogUtils(Activity activity, String message)
    {
        init(activity);
        progressDialog.setMessage(message);
    }

    public ProgressDialogUtils(Activity activity)
    {
        init(activity);
    }

    private void init(Activity activity)
    {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
    }

    public void show()
    {
        progressDialog.show();
    }

    public void dismiss() {
        progressDialog.dismiss();
    }

    public void setMessage(String message) {
        progressDialog.setMessage(message);
    }
}
