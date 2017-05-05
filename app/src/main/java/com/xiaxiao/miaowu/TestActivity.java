package com.xiaxiao.miaowu;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaxiao.miaowu.customview.bannerview.BannerView;
import com.xiaxiao.miaowu.customview.BaseActivity;
import com.xiaxiao.miaowu.customview.BottomTab;
import com.xiaxiao.miaowu.customview.CommentView;
import com.xiaxiao.miaowu.customview.MiaoWuBottomTab;
import com.xiaxiao.miaowu.customview.bannerview.MyBannerAdapter;
import com.xiaxiao.miaowu.thirdframework.glide.GlideHelper;
import com.xiaxiao.miaowu.util.XiaoUtil;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {
CommentView commentView;
    MiaoWuBottomTab bottomTab;
    MiaoWuBottomTab bottomTab2;
    BannerView viewPager;
    List<View> views;
    List<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test);
        bottomTab = (MiaoWuBottomTab) findViewById(R.id.bottom_tab);
        bottomTab2 = (MiaoWuBottomTab) findViewById(R.id.bottom_tab2);
        viewPager = (BannerView) findViewById(R.id.viewpager_kl);
        bottomTab2.inits();
        bottomTab.setTabItemClickListener(new BottomTab.TabItemClickListener() {
            @Override
            public void onItemClick(int index) {
                XiaoUtil.toast("tab :"+index);
            }
        });

        views = new ArrayList<>();
        datas = new ArrayList<>();
       /* for (int i=0;i<4;i++) {
            datas.add(i + " hahaha");
        }*/
        datas.add("http://img2.imgtn.bdimg.com/it/u=780939278,953464086&fm=11&gp=0.jpg");
        datas.add("http://img0.imgtn.bdimg.com/it/u=194570714,2632603990&fm=11&gp=0.jpg");
        datas.add("http://img5.imgtn.bdimg.com/it/u=2299609415,2213226454&fm=11&gp=0.jpg");
        datas.add("http://img0.imgtn.bdimg.com/it/u=2060780763,2734283137&fm=11&gp=0.jpg");
        datas.add("http://img4.imgtn.bdimg.com/it/u=1709511131,6638xxxxxxx75867&fm=23&gp=0.jpg");
        MyBannerAdapter<String> myPagerAdapter = new MyBannerAdapter<String>(this,R.layout.bottom_tab_item,datas) {


            @Override
            public void onItemInstantiated(View item, final String obj, int position) {
                TextView tvv = (TextView) item.findViewById(R.id.bottom_tab_item_tv);
                ImageView imgg = (ImageView) item.findViewById(R.id.bottom_tab_item_img);
                tvv.setText(obj+"   position: "+position);
                GlideHelper.loadImage(TestActivity.this,obj,imgg);
                item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        XiaoUtil.toast(obj);
                    }
                });

            }
        };
        viewPager.setAdapter(myPagerAdapter);
        viewPager.fixSlideDisturbWith(this);
       /* LayoutInflater inflater = getLayoutInflater();
        for (int i=0;i<4;i++) {
            datas.add(i + "hahaha");
        }
       *//* for (Object o:list) {
            String s=(String)o;
            View v1 = inflater.inflate(R.layout.viewpager_item, null);

        }*//*
        View v1 = inflater.inflate(R.layout.viewpager_item, null);
        View v11 = inflater.inflate(R.layout.viewpager_item, null);
        View v2 = inflater.inflate(R.layout.viewpager_item2, null);
        View v3 = inflater.inflate(R.layout.viewpager_item3, null);
        View v4 = inflater.inflate(R.layout.viewpager_item4, null);
        View v44 = inflater.inflate(R.layout.viewpager_item4, null);
        views.add(v1);
        views.add(v2);
        views.add(v3);
        views.add(v4);

        views.add(v11);
        views.add(0,v44);

        MyBannerAdapter myPagerAdapter = new MyBannerAdapter(this, views,datas);
        viewPager.setAdapter(myPagerAdapter);
        viewPager.setCurrentItem(1);
        setBarTitle("zadile,,,,,,,,,,,,,,,");
        setLeftImage(R.drawable.tab2);
        setTitleLeftAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ci=viewPager.getCurrentItem();
//                if (ci + 1 == datas.size()) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
//                    viewPager.setCurrentItem(0, false);

                *//*} else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }*//*
                XiaoUtil.toast("tttttttttttt");
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                XiaoUtil.l("onPageScrolled "+position);
            }

            @Override
            public void onPageSelected(int position) {
                XiaoUtil.l("onPageSelected "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                XiaoUtil.l("onPageScrollStateChanged  "+viewPager.getCurrentItem());
                if (state==ViewPager.SCROLL_STATE_IDLE&&viewPager.getCurrentItem()+1==views.size()) {
                    viewPager.setCurrentItem(1, false);

                }
                if (state==ViewPager.SCROLL_STATE_IDLE&&viewPager.getCurrentItem()==0) {
                    viewPager.setCurrentItem(views.size()-2, false);

                }
            }
        });

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!theMession) {
                    float x=0;
                    float y=0;
                    if (event.getAction()==MotionEvent.ACTION_DOWN) {
                        x=event.getX();
                        y=event.getY();
                    }
                    if (event.getAction()==MotionEvent.ACTION_MOVE) {
                        if (Math.abs(event.getX()-x) >= Math.abs(event.getY()-y)) {
                            theMession=true;
                            setRefreshEnable(false);
                        }
                    }


                }

                if (event.getAction()==MotionEvent.ACTION_UP) {
                    setRefreshEnable(true);
                    theMession=false;
                }
                return false;
            }
        });
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XiaoUtil.toast("dangqian index: "+viewPager.getCurrentItem());
            }
        });*/

//
    }

    boolean theMession=false;
    @Override
    public void onRefreshing() {

        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                    // TODO Auto-generated method stub
                                   XiaoUtil.toast("hahahahaha ok");
                                    stopRefresh();
                                }
                        }, 2000);

    }

    public void stopRefresh(View view) {
        stopRefresh();

    }


    /*class MyBannerAdapter extends PagerAdapter {
        Context mContext;
        List<View> mList;
        List<String> mDatas;
        public MyBannerAdapter(Context context, List<View> list,List<String> datas) {
            mContext = context;
            mList = list;
            mDatas = datas;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }
    }*/
}

