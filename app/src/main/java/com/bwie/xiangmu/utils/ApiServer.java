package com.bwie.xiangmu.utils;

import com.bwie.xiangmu.Goods.bean.AddBean;
import com.bwie.xiangmu.Goods.bean.DetailsBean;
import com.bwie.xiangmu.Goods.bean.GoodBean;
import com.bwie.xiangmu.classify.bean.OneBean;
import com.bwie.xiangmu.classify.bean.TwoBean;
import com.bwie.xiangmu.home.Bean.BannerBean;
import com.bwie.xiangmu.mine.bean.LoginBean;
import com.bwie.xiangmu.mine.bean.SignUpBean;
import com.bwie.xiangmu.shopcar.bean.DeleteBean;
import com.bwie.xiangmu.shopcar.bean.ShopCarBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;


public interface ApiServer {
    @POST
    Observable<SignUpBean> getsup(@Url String url, @QueryMap Map<String, String> map);
    @POST
    Observable<LoginBean> getlg(@Url String url, @QueryMap Map<String, String> map);

    @GET("product/getCatagory")
    Observable<OneBean> getonedata();

    @GET("ad/getAd")
    Observable<BannerBean> getbanner();

    @POST
    Observable<TwoBean> getRight(@Url String url, @QueryMap Map<String, Integer> map);

    @POST
    Observable<GoodBean> getgood(@Url String url, @QueryMap Map<String, Integer> map);

    @POST
    Observable<DetailsBean> getdetail(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<AddBean> getAdd(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<ShopCarBean> getcatlist(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<DeleteBean> getdeta(@Url String url, @QueryMap Map<String, String> map);
}
