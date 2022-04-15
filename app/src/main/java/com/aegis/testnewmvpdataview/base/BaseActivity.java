package com.aegis.testnewmvpdataview.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.aegis.testnewmvpdataview.Iview.BaseView;
import com.aegis.testnewmvpdataview.utils.ViewBindingUtils;
import com.aegis.testnewmvpdataview.proxy.IBaseMvpProxy;
import com.aegis.testnewmvpdataview.proxy.MvpProxyImpl;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity implements BaseView {

    private VB binding;
    private IBaseMvpProxy mvpProxy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getBinding().getRoot());

        mvpProxy = new MvpProxyImpl(this);
        mvpProxy.bindAndCreateMvpPresenter();

        init();
    }

    public VB getBinding() {
        if (binding == null) {
            binding = (VB) ViewBindingUtils.inflateWithGeneric(this, getLayoutInflater());
        }
        return binding;
    }




    private void init() {
        initData();
        initView();

    }

    public void initView() {
    }

    public void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放Presenter
        mvpProxy.unbindMvpPresenter();
    }
}
