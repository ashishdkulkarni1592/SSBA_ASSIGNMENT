package com.ssba.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentManager;

import java.lang.ref.WeakReference;

public abstract class BaseActivityViewModel extends BaseObservable {
    private WeakReference<AppCompatActivity> activityWeakReference;
    private AlertDialog.Builder alertDialogBuilder;
    private static AlertDialog Loading;


    public BaseActivityViewModel(AppCompatActivity appCompatActivity) {
        this.activityWeakReference = new WeakReference<>(appCompatActivity);
    }

    protected AppCompatActivity getContext() {
        return activityWeakReference.get();
    }

    protected FragmentManager getSupportFragmentManager() {
        return getContext().getSupportFragmentManager();
    }

    protected void setTitle(String title) {
        activityWeakReference.get().setTitle(title);
    }

    public void handleActivityResult(int requestCode, int resultCode, Intent data) {
        this.handleActivityResult(requestCode, resultCode, data);
    }


    protected boolean isNetworkAvailable(final Activity activity)
    {

        if (isNetworkAvailable(activity))
        {
            return true;
        } else {
            if (alertDialogBuilder == null) {
                alertDialogBuilder = new AlertDialog.Builder(activity);
            }
            alertDialogBuilder.setMessage("Please turn on network connection").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    if (Build.VERSION.SDK_INT >= 19) {
                        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);//android.provider.Settings.ACTION_SETTINGS //Intent.ACTION_MAIN
                        intent.setClassName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity");
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        activity.startActivity(intent);
                    } else {
                        Intent intent = new Intent();
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setAction(Settings.ACTION_DATA_ROAMING_SETTINGS);
                        activity.startActivity(intent);
                    }
                }
            }).show();
            return false;

        }
    }



}
