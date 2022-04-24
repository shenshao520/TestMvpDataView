package com.aegis.testnewmvpdataview.app;

import android.Manifest;
import android.app.Application;

import com.aegis.testnewmvpdataview.startup.PermissionStartup;
import com.rousetime.android_startup.StartupManager;


public class InitApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();


        initSo();

    }

    private void initSo() {

        new StartupManager.Builder().addStartup(new PermissionStartup())
//                .addStartup(new SampleSecondStartup())
//                .addStartup(new SampleThreeStartup())
//                .addStartup(new SampleFourStartup())
                .build(this)
                .start()
                .await();

    }



}
