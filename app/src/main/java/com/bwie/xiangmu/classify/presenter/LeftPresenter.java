package com.bwie.xiangmu.classify.presenter;


import com.bwie.xiangmu.classify.ClassifyConstract;
import com.bwie.xiangmu.classify.bean.OneBean;
import com.bwie.xiangmu.classify.bean.TwoBean;
import com.bwie.xiangmu.classify.model.LeftModel;

import java.util.List;



public class LeftPresenter implements ClassifyConstract.IClassifyPresenter {
    ClassifyConstract.IClassifyView iClassifyView;
    ClassifyConstract.IClassifyModel iClassifyModel;

    public LeftPresenter(ClassifyConstract.IClassifyView iClassifyView) {
        this.iClassifyView = iClassifyView;
        iClassifyModel = new LeftModel();
    }

    @Override
    public void LoadList(String url) {
        iClassifyModel.OnRequestsListener(url, new ClassifyConstract.OnRequestListener() {
            @Override
            public void OnSuccess(List<OneBean.DataBean> list) {
                iClassifyView.ShowList(list);
            }

            @Override
            public void OnError(String e) {
                iClassifyView.ShowError(e);
            }
        });
    }

    @Override
    public void LoadRight(String url, int cid) {
        iClassifyModel.OnRightData(url, cid, new ClassifyConstract.OnRightListener() {
            @Override
            public void OnSuccess(List<TwoBean.DataBean> list) {
                iClassifyView.ShowRight(list);
            }

            @Override
            public void OnError(String e) {
                iClassifyView.ShowError(e);
            }
        });
    }
}
