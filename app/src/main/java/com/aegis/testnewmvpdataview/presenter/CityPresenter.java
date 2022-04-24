package com.aegis.testnewmvpdataview.presenter;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.aegis.testnewmvpdataview.Imodel.BaseModel;
import com.aegis.testnewmvpdataview.Imodel.CityModelImpl;
import com.aegis.testnewmvpdataview.Iview.CityViewImpl;
import com.aegis.testnewmvpdataview.base.BasePresenter;
import com.aegis.testnewmvpdataview.modelBean.CityBean;

public class CityPresenter extends BasePresenter<CityViewImpl<CityBean>, CityModelImpl> implements LifecycleObserver {
    Lifecycle.State state;

    public void getCity() {

        modelImp.getCity("beij", new BaseModel.LoadDataListener<CityBean>() {
            @Override
            public void onComplete(CityBean data) {
                if (state== Lifecycle.State.DESTROYED){
                    return;
                }
                mViewRef.get().showCity(data);
            }

            @Override
            public void onErrorMsg(String msg) {

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
