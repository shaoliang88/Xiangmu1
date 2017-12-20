package com.bwie.xiangmu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bwie.xiangmu.classify.view.ClassIfyFragment;
import com.bwie.xiangmu.home.view.HomeFragment;
import com.bwie.xiangmu.mine.view.MeFragment;
import com.bwie.xiangmu.shopcar.view.ShopCarFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.mipmap.ic_nav_home, HomeFragment.class)
                .addTabItem("分类", R.mipmap.ic_nav_class, ClassIfyFragment.class)
                .addTabItem("购物车",R.mipmap.ic_nav_cart, ShopCarFragment.class)
                .addTabItem("个人", R.mipmap.ic_nav_user, MeFragment.class);
    }
}
