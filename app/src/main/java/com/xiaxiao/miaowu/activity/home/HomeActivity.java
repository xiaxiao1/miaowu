package com.xiaxiao.miaowu.activity.home;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import com.xiaxiao.miaowu.R;
import com.xiaxiao.miaowu.activity.home.dummy.ArticleContent;
import com.xiaxiao.miaowu.activity.home.dummy.BaseFragment;
import com.xiaxiao.miaowu.customview.BaseActivity;
import com.xiaxiao.miaowu.customview.BottomTab;
import com.xiaxiao.miaowu.customview.MiaoWuBottomTab;
import com.xiaxiao.miaowu.util.XiaoUtil;

public class HomeActivity extends BaseActivity implements BottomTab.TabItemClickListener,BaseFragment.OnFragmentInteractionListener,ItemFragment.OnListFragmentInteractionListener{
    MiaoWuBottomTab bottomTab;
    FragmentTransaction fragmentTransaction;
    int currentpage=0;
    Fragment currentFragment;
    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;
    Fragment fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomTab = (MiaoWuBottomTab) findViewById(R.id.bottom_tab);
        bottomTab.inits();
        bottomTab.setTabItemClickListener(this);

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragment1=ItemFragment.newInstance(1);
        fragmentTransaction.add(R.id.frame,fragment1 );
        currentFragment = fragment1;
        fragmentTransaction.commit();
    }





    @Override
    public void onRefreshing() {

    }

    @Override
    public void onItemClick(int index) {
        XiaoUtil.toast(index+"");
        if (currentpage==index) {
            return;
        }
        currentpage = index;
        switchFragment(index);
    }

    public void switchFragment(int index) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        if (index==0) {
            if (fragment1 == null) {
                fragment1 =ItemFragment.newInstance(1);
            }
            if(!fragment1.isAdded()){
                fragmentTransaction.hide(currentFragment).add(R.id.frame, fragment1).commit();
            } else {
                fragmentTransaction.hide(currentFragment).show(fragment1).commit();
            }
            currentFragment = fragment1;
        }
        if (index==1) {
            if (fragment2 == null) {
                fragment2 = Fragment2.newInstance("11", "22");
            }
            if(!fragment2.isAdded()){
                fragmentTransaction.hide(currentFragment).add(R.id.frame, fragment2).commit();
            } else {
                fragmentTransaction.hide(currentFragment).show(fragment2).commit();
            }
            currentFragment = fragment2;
        }
        if (index==2) {
            if (fragment3 == null) {
                fragment3 = Fragment3.newInstance("11", "22");;
            }
            if(!fragment3.isAdded()){
                fragmentTransaction.hide(currentFragment).add(R.id.frame, fragment3).commit();
            } else {
                fragmentTransaction.hide(currentFragment).show(fragment3).commit();
            }
            currentFragment = fragment3;
        }
        if (index==3) {
            if (fragment4 == null) {
                fragment4 = Fragment4.newInstance("11", "22");;
            }
            if(!fragment4.isAdded()){
                fragmentTransaction.hide(currentFragment).add(R.id.frame, fragment4).commit();
            } else {
                fragmentTransaction.hide(currentFragment).show(fragment4).commit();
            }
            currentFragment = fragment4;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(ArticleContent item) {

    }
}
