package com.aegis.testnewmvpdataview.http;

public class HttpHelper {


    public static final String BASE_WEATHER_URl ="https://devapi.qweather.com";
    public static final String BASE_CITY_URl ="https://geoapi.qweather.com";

    public static final String getWeather= BASE_WEATHER_URl +"/v7/weather/now";
    public static final String getCity= BASE_CITY_URl +"/v2/city/lookup";

}
