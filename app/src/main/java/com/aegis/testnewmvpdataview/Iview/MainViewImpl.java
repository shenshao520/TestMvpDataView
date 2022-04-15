package com.aegis.testnewmvpdataview.Iview;

public interface MainViewImpl<T> extends BaseView {

    public void showSuccess(T s);

    public void showError(String s);

}
