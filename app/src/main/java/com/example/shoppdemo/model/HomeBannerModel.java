package com.example.shoppdemo.model;

import com.example.mvplibrary.utils.INetCallBack;
import com.example.mvplibrary.utils.RetrofitUtils;
import com.example.shoppdemo.contart.HomeBannerContart;

public class HomeBannerModel implements HomeBannerContart.IHomeModel {
    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
