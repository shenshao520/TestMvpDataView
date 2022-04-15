package com.aegis.testnewmvpdataview.Imodel;

import com.aegis.testnewmvpdataview.http.HttpHelper;
import com.aegis.testnewmvpdataview.http.MainRequestInterface;
import com.aegis.testnewmvpdataview.modelBean.CityBean;
import com.blankj.utilcode.util.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityModelImpl implements BaseModel {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HttpHelper.BASE_CITY_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    MainRequestInterface mainRequestInterface = retrofit.create(MainRequestInterface.class);

    public void  getCity( String local,LoadDataListener<CityBean> loadDataListener){

        Call<CityBean> call = mainRequestInterface.getCity(local, "24762dcc32814db49054f231a4f205a1");
        call.enqueue(new Callback<CityBean>() {
            @Override
            public void onResponse(Call<CityBean> call, Response<CityBean> response) {
                loadDataListener.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<CityBean> call, Throwable t) {
                LogUtils.e("shen","失败=====");

                loadDataListener.onErrorMsg(t.getMessage());
            }
        });
    }

}
