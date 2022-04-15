package com.aegis.testnewmvpdataview.base;

import com.aegis.testnewmvpdataview.Imodel.BaseModel;
import com.aegis.testnewmvpdataview.Iview.BaseView;

import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

public class BasePresenter<I extends BaseView, M extends BaseModel> {

    protected WeakReference<I> mViewRef;

    protected  M modelImp;


    protected BasePresenter() {

        Type[] types = ((ParameterizedType) Objects.requireNonNull(this.getClass().getGenericSuperclass())).getActualTypeArguments();
        try {
            modelImp = (M)((Class) types[1]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//绑定

    public  void  onAttach(I mView){
        this.mViewRef = new WeakReference(mView);

    }

    // 解绑
    public  void  onDetach(){
        if (mViewRef ==null){
            return;
        }
        mViewRef.clear();
        mViewRef=null;

    }


}
