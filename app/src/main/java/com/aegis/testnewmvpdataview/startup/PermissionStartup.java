package com.aegis.testnewmvpdataview.startup;

import android.Manifest;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.rousetime.android_startup.AndroidStartup;

public class PermissionStartup extends AndroidStartup<String> {

    /**
     * 应用所需权限
     */
    private String[] permissions = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,

    };



    @Nullable
    @Override
    public String create(@NonNull Context context) {

        Log.e("shen","第一个任务");


            PermissionUtils
                    .permission(permissions)
                    .callback(new PermissionUtils.SimpleCallback() {
                        @Override
                        public void onGranted() {
                        }

                        @Override
                        public void onDenied() {
                            ToastUtils.showShort("应用缺少必要的权限！请点击\"权限\"，打开所需要的权限");
                            AppUtils.launchAppDetailsSettings();

                        }
                    }).request();


        return "第一个权限任务";
    }

    @Override
    public boolean callCreateOnMainThread() {
        return true;
    }

    @Override
    public boolean waitOnMainThread() {
        return false;
    }
}
