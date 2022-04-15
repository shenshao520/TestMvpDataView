package com.aegis.testnewmvpdataview.proxy;





import com.aegis.testnewmvpdataview.base.BasePresenter;
import com.aegis.testnewmvpdataview.Iview.BaseView;
import com.aegis.testnewmvpdataview.annotation.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *  增加 代理  自动处理 Presenter 的 创建
 * @param <T>
 */
public class MvpProxyImpl < T extends BaseView> implements IBaseMvpProxy{

    private T view;
    private List<BasePresenter> mPresenters;

    public MvpProxyImpl(T view) {
        this.view = view;
        mPresenters=new ArrayList<>();
    }

    @Override
    public void bindAndCreateMvpPresenter() {


        Field[] fields = view.getClass().getDeclaredFields();

        for (  Field field:fields) {
            InjectPresenter[] annotationsByType = new InjectPresenter[0];
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                annotationsByType = field.getAnnotationsByType(InjectPresenter.class);
            }

            Class<? extends BasePresenter> mPresenter=null;
            if (annotationsByType!=null){

                try {
                    mPresenter = (Class<? extends BasePresenter>) field.getType();

                    BasePresenter basePresenter = mPresenter.newInstance();
                    basePresenter.onAttach(view);
                    field.setAccessible(true);
                    field.set(view,basePresenter);
                    mPresenters.add(basePresenter);
                    basePresenter.onAttach(view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public void unbindMvpPresenter() {
        if (mPresenters==null){
            return;
        }
        for ( BasePresenter mp: mPresenters) {
            mp.onDetach();
        }
    }
}
