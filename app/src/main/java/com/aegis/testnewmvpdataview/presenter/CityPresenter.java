package com.aegis.testnewmvpdataview.presenter;

import com.aegis.testnewmvpdataview.Imodel.BaseModel;
import com.aegis.testnewmvpdataview.Imodel.CityModelImpl;
import com.aegis.testnewmvpdataview.Iview.CityViewImpl;
import com.aegis.testnewmvpdataview.base.BasePresenter;
import com.aegis.testnewmvpdataview.modelBean.CityBean;

public class CityPresenter extends BasePresenter<CityViewImpl<CityBean>, CityModelImpl> {

    public void getCity() {

        modelImp.getCity("beij", new BaseModel.LoadDataListener<CityBean>() {
            @Override
            public void onComplete(CityBean data) {
                mViewRef.get().showCity(data);
            }

            @Override
            public void onErrorMsg(String msg) {

            }
        });
    }
}
