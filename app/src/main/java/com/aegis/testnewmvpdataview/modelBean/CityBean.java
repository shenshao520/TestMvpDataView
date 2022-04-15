package com.aegis.testnewmvpdataview.modelBean;

import java.util.List;


public class CityBean {


   public String code;
   public List<LocationBean> location;
   public ReferBean refer;


    public static class ReferBean {
        public List<String> sources;
        public List<String> license;
    }


    public static class LocationBean {
       public String name;
       public String id;
       public String lat;
       public String lon;
       public String adm2;
       public String adm1;
       public String country;
       public String tz;
       public String utcOffset;
       public String isDst;
       public String type;
       public String rank;
       public String fxLink;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "code='" + code + '\'' +
                ", location=" + location +
                ", refer=" + refer +
                '}';
    }
}
