package com.aegis.testnewmvpdataview.adapter;

import androidx.annotation.NonNull;

import com.aegis.testnewmvpdataview.R;
import com.aegis.testnewmvpdataview.modelBean.CityBean;
import com.aegis.testnewmvpdataview.modelBean.WeatherBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

public class CityAdapter extends BaseQuickAdapter<CityBean.LocationBean, BaseViewHolder> {
    public CityAdapter() {
        super(R.layout.item_layout);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, CityBean.LocationBean dataBean) {

        baseViewHolder.setText(R.id.tv_name,"城市: "+dataBean.name);
        baseViewHolder.setText(R.id.tv_code,"编号: "+dataBean.id);

    }
}
