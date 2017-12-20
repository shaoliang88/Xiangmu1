package com.bwie.xiangmu.shopcar.presenter;


import com.bwie.xiangmu.shopcar.ShopCarConstract;
import com.bwie.xiangmu.shopcar.bean.DeleteBean;
import com.bwie.xiangmu.shopcar.bean.ShopCarBean;
import com.bwie.xiangmu.shopcar.model.ShopCarModel;

import java.util.List;



public class ShopCarPresenter implements ShopCarConstract.ICarPresenter {

    ShopCarConstract.ICarView iCarView ;
    ShopCarConstract.ICarModel iCarModel;

    public ShopCarPresenter(ShopCarConstract.ICarView iCarView) {
        this.iCarView = iCarView;
        iCarModel = new ShopCarModel();
    }

    @Override
    public void LoadList(String url, int uid) {
        iCarModel.OnRequsetData(url, uid, new ShopCarConstract.OnCarListener() {
            @Override
            public void OnSuccess(List<ShopCarBean.DataBean> list) {
                iCarView.ShowList(list);
            }

            @Override
            public void OnDataEnd() {
                iCarView.ShowEnd();
            }

            @Override
            public void OnError(String e) {
                iCarView.ShowError(e);
            }
        });
    }

    @Override
    public void LoadDelete(String url, String pid, int uid) {
        iCarModel.OnDeleteData(url, pid, uid, new ShopCarConstract.OnDeleteListener() {
            @Override
            public void OnSuccess(DeleteBean db) {
                iCarView.ShowDelete(db);
            }

            @Override
            public void OnError(String e) {
                iCarView.ShowDeleteError(e);
            }
        });
    }
}
