package com.aegis.testnewmvpdataview;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.aegis.testnewmvpdataview.Iview.MainViewImpl;
import com.aegis.testnewmvpdataview.Iview.CityViewImpl;
import com.aegis.testnewmvpdataview.adapter.CityAdapter;
import com.aegis.testnewmvpdataview.annotation.InjectPresenter;
import com.aegis.testnewmvpdataview.base.BaseActivity;
import com.aegis.testnewmvpdataview.databinding.ActivityMainBinding;
import com.aegis.testnewmvpdataview.modelBean.CityBean;
import com.aegis.testnewmvpdataview.modelBean.WeatherBean;
import com.aegis.testnewmvpdataview.presenter.MainPresenter;
import com.aegis.testnewmvpdataview.presenter.CityPresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainViewImpl<WeatherBean>, CityViewImpl<CityBean> {

    @InjectPresenter
    MainPresenter mMainPresenter;

    @InjectPresenter
    CityPresenter mCityPresenter;

    private CityAdapter adapter;

    @Override
    public void initView() {

        getBinding().btnCity.setOnClickListener(view -> mCityPresenter.getCity());
        getBinding().btnMain.setOnClickListener(view -> mMainPresenter.getWeather());
        getBinding().rvResult.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CityAdapter();
        getBinding().rvResult.setAdapter(adapter);

        getLifecycle().addObserver(mMainPresenter);
        getLifecycle().addObserver(mCityPresenter);

    }


    @Override
    public void showSuccess(WeatherBean dataBean) {
        String msg="";

        if (dataBean!=null){
            msg=  "温度 : "+ dataBean.now.temp+"\u3000\u3000风向: "+dataBean.now.windDir +"\u3000\u3000详情 : "+dataBean.now.text;
        }
        getBinding().tvMainResult.setText(msg);

    }


    @Override
    public void showError(String s) {
        getBinding().tvMainResult.setText(s);

    }

    @Override
    public void showCity(CityBean bean) {

        if (bean!=null&&bean.location.size()>0){
            adapter.setNewInstance(bean.location);
        }
    }
}
