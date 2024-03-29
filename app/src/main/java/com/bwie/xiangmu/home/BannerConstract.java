package com.bwie.xiangmu.home;

import com.bwie.xiangmu.home.Bean.BannerBean;


public interface BannerConstract {
    interface IBannerView{
        void ShowBanner(BannerBean bb);
        void ShowError(String e);
    }
    interface IBannerModel{
        void RequestData(String url, OnBannerRequest onBannerRequest);
    }
    interface OnBannerRequest{
        void OnSuccess(BannerBean bb);
        void OnError(String e);
    }
    interface IBannerPresenter{
        void LoadBan(String url);
    }
}
