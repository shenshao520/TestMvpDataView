package com.aegis.testnewmvpdataview.Imodel;

/**
 * 网络请求
 */
public interface BaseModel {


    interface  LoadDataListener<T>{
        void onComplete(T  data);
        void onErrorMsg(String msg);
    }
}
