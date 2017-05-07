package com.xiaxiao.miaowu;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaxiao.miaowu.activity.home.ItemFragment;
import com.xiaxiao.miaowu.activity.home.dummy.ArticleContent;
import com.xiaxiao.miaowu.activity.home.dummy.DummyContent;
import com.xiaxiao.miaowu.bean.Article;
import com.xiaxiao.miaowu.util.XiaoUtil;

public class TestActivity2 extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_listview_item);
         FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame, ItemFragment.newInstance(1));
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(ArticleContent item) {
        XiaoUtil.l(item.toString());
    }
}
