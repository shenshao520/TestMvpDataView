package com.aegis.testnewmvpdataview.Imodel;

import com.aegis.testnewmvpdataview.http.HttpHelper;
import com.aegis.testnewmvpdataview.http.MainRequestInterface;
import com.aegis.testnewmvpdataview.modelBean.WeatherBean;
import com.blankj.utilcode.util.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelImpl implements BaseModel{


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HttpHelper.BASE_WEATHER_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    MainRequestInterface mainRequestInterface = retrofit.create(MainRequestInterface.class);

    public void getWeather(String local, LoadDataListener<WeatherBean> loadDataListener){


        Call<WeatherBean> call = mainRequestInterface.getWeather(local, "24762dcc32814db49054f231a4f205a1");
        call.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {

                LogUtils.e("shen","====成功==");

                loadDataListener.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                LogUtils.e("shen","====失败了==");

                loadDataListener.onErrorMsg(t.getMessage());

            }
        });
    }

}
