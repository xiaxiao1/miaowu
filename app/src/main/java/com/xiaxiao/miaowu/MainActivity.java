package com.xiaxiao.miaowu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xiaxiao.miaowu.bean.Article;
import com.xiaxiao.miaowu.customview.BaseActivity;
import com.xiaxiao.miaowu.customview.bannerview.MyBannerAdapter;
import com.xiaxiao.miaowu.thirdframework.bmob.BmobIniter;
import com.xiaxiao.miaowu.thirdframework.bmob.BmobListener;
import com.xiaxiao.miaowu.thirdframework.bmob.BmobServer;
import com.xiaxiao.miaowu.util.XiaoUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.exception.BmobException;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BmobIniter.init(getApplicationContext());
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation().save();
        // 启动推送服务
        BmobPush.startWork(this);
//        getRuntimePermissionsManager().
    }

    @Override
    public void onRefreshing() {

    }

    public void toTestactivity(View view) {
        startActivity(new Intent(this, TestActivity2.class));
    }
    public void getArticles(View view) {
        BmobServer bmobServer = new BmobServer.Builder(this).enableDialog(false).build();
        bmobServer.getArticles(0, new BmobListener() {
            @Override
            public void onSuccess(Object object) {
                List<Article> articleList = (List<Article>) object;
                XiaoUtil.toast(articleList.get(10).getName());
            }

            @Override
            public void onError(BmobException e) {

            }
        });

        MyBannerAdapter<String> myPagerAdapter=new MyBannerAdapter<String>(this,R.layout.bottom_tab_item,new ArrayList<String>()) {
            @Override
            public void onItemInstantiated(View item, String obj, int position) {

            }
        };
    }
}
