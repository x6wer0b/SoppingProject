package com.example.shoppdemo.presenter;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.INetCallBack;
import com.example.mvplibrary.utils.URLConstant;
import com.example.shoppdemo.bean.HomeBannerBean;
import com.example.shoppdemo.contart.HomeBannerContart;
import com.example.shoppdemo.model.HomeBannerModel;

public class HomeBannerPreseneter extends BasePresenter<HomeBannerContart.IHomeView, HomeBannerContart.IHomeModel> implements HomeBannerContart.IHomePresenter {
    @Override
    public HomeBannerContart.IHomeModel getiModel() {
        return new HomeBannerModel();
    }

    @Override
    public void getHome() {
        iModel = new HomeBannerModel();
        iModel.getHomeData(URLConstant.NEWLIST, new INetCallBack<HomeBannerBean>() {
            @Override
            public void onSuccess(HomeBannerBean homeBannerBean) {
                iView.getHomeV(homeBannerBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}
