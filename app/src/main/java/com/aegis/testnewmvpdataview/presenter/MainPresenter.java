package com.aegis.testnewmvpdataview.presenter;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.aegis.testnewmvpdataview.Imodel.BaseModel;
import com.aegis.testnewmvpdataview.Imodel.MainModelImpl;
import com.aegis.testnewmvpdataview.Iview.MainViewImpl;
import com.aegis.testnewmvpdataview.base.BasePresenter;
import com.aegis.testnewmvpdataview.modelBean.WeatherBean;

public class MainPresenter  extends BasePresenter<MainViewImpl<WeatherBean>, MainModelImpl> implements LifecycleObserver {

    Lifecycle.State state;

    public void getWeather(){

        modelImp.getWeather("101010100",  new BaseModel.LoadDataListener<WeatherBean>() {
            @Override
            public void onComplete(WeatherBean data) {
                if (state== Lifecycle.State.DESTROYED){
                    return;
                }
                mViewRef.get().showSuccess(data);
            }

            @Override
            public void onErrorMsg(String msg) {
                mViewRef.get().showError(msg);

            }
        });


    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {

        state = Lifecycle.State.CREATED;
        Log.e("shen", "onCreate: " + state);


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

        state = Lifecycle.State.DESTROYED;
        Log.e("shen", "onDestroy: " + state);
    }


}
