package com.aegis.testnewmvpdataview.app;

import android.app.Application;

import com.aegis.testnewmvpdataview.utils.SpUtil;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

public class InitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



//        initPermission();

    }

    private void initPermission() {


        AndPermission.with(this)
                .runtime()
                .permission(Permission.READ_PHONE_STATE,
                        Permission.WRITE_EXTERNAL_STORAGE)
                .onDenied(data -> {
                    ToastUtils.showShort("请授予权限后再试！");
                })
                .onGranted(data -> {
                    SpUtil.putString("device_id","123");

                }).start();

    }
}
