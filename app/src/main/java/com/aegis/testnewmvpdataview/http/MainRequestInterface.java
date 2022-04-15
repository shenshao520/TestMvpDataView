package com.aegis.testnewmvpdataview.http;

import com.aegis.testnewmvpdataview.modelBean.CityBean;
import com.aegis.testnewmvpdataview.modelBean.WeatherBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainRequestInterface {


    /**
     * 获取天气
     *
     * @return
     */
    @GET(HttpHelper.getWeather)
    Call<WeatherBean> getWeather(@Query("location") String location, @Query("key") String key);

   /**
     * 获取城市
     *
     * @return
     */
    @GET(HttpHelper.getCity)
    Call<CityBean> getCity(@Query("location") String location, @Query("key") String key);


}
