package com.aegis.testnewmvpdataview.presenter;

import com.aegis.testnewmvpdataview.Imodel.BaseModel;
import com.aegis.testnewmvpdataview.Imodel.MainModelImpl;
import com.aegis.testnewmvpdataview.Iview.MainViewImpl;
import com.aegis.testnewmvpdataview.base.BasePresenter;
import com.aegis.testnewmvpdataview.modelBean.WeatherBean;

public class MainPresenter  extends BasePresenter<MainViewImpl<WeatherBean>, MainModelImpl> {


    public void getWeather(){

        modelImp.getWeather("101010100",  new BaseModel.LoadDataListener<WeatherBean>() {
            @Override
            public void onComplete(WeatherBean data) {
                mViewRef.get().showSuccess(data);
            }

            @Override
            public void onErrorMsg(String msg) {
                mViewRef.get().showError(msg);

            }
        });


    }
}
