package com.aegis.testnewmvpdataview.modelBean;

import java.util.List;


public class WeatherBean {


    public String code;
    public String updateTime;
    public String fxLink;
    public NowBean now;
    public ReferBean refer;


    public static class NowBean {
        public String obsTime;
        public String temp;
        public String feelsLike;
        public String icon;
        public String text;
        public String wind360;
        public String windDir;
        public String windScale;
        public String windSpeed;
        public String humidity;
        public String precip;
        public String pressure;
        public String vis;
        public String cloud;
        public String dew;
    }

    public static class ReferBean {
        public List<String> sources;
        public List<String> license;
    }
}
