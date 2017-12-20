package com.bwie.xiangmu.Goods.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwie.xiangmu.Goods.GoodConstract;
import com.bwie.xiangmu.Goods.adapter.GoodAdapter;
import com.bwie.xiangmu.Goods.bean.GoodBean;
import com.bwie.xiangmu.Goods.presenter.GoodPresenter;
import com.bwie.xiangmu.R;
import com.bwie.xiangmu.classify.bean.MessageEvent;
import com.bwie.xiangmu.utils.Api;
import com.bwie.xiangmu.utils.Toasts;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodActivity extends AppCompatActivity implements GoodConstract.IGoodView {

    @BindView(R.id.good_rcv)
    RecyclerView goodRcv;
    private GoodPresenter goodPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        goodPresenter = new GoodPresenter(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED , sticky = true)
    public void noEvent(MessageEvent messageEvent) {
        int cid = messageEvent.getCid();
        goodPresenter.LoadList(Api.BANNERURL,cid,1,0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void ShowList(List<GoodBean.DataBean> list) {

        GoodAdapter goodAdapter = new GoodAdapter(list, GoodActivity.this);
        if(list!=null){
            goodRcv.setAdapter(goodAdapter);
            goodRcv.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    @Override
    public void ShowError(String e) {
        Toasts.showLong(this, e);
        Log.e("哈哈哈哈哈哈哈哈哈哈哈哈", e);
    }
}
