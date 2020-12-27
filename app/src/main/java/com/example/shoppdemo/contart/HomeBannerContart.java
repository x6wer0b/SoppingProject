package com.example.shoppdemo.contart;

import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.utils.INetCallBack;

public class HomeBannerContart {
    public interface IHomeView extends BaseView {
        <T> void getHomeV(T t);
    }

    public interface IHomeModel extends BaseModel{
        <T> void getHomeData(String url, INetCallBack<T> callBack);
    }

    public interface IHomePresenter{
        void getHome();
    }
}
