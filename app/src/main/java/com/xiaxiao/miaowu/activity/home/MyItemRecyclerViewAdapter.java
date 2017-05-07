package com.xiaxiao.miaowu.activity.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaxiao.miaowu.R;
import com.xiaxiao.miaowu.activity.home.ItemFragment.OnListFragmentInteractionListener;
import com.xiaxiao.miaowu.activity.home.dummy.ArticleContent;
import com.xiaxiao.miaowu.activity.home.dummy.DummyContent.DummyItem;
import com.xiaxiao.miaowu.bean.Article;
import com.xiaxiao.miaowu.thirdframework.glide.GlideHelper;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter
        .ViewHolder> {

    private final List<ArticleContent> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context mContext;

    public MyItemRecyclerViewAdapter(Context context,List<ArticleContent> items, OnListFragmentInteractionListener
            listener) {
        mContext = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_listview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.title.setText(mValues.get(position).article.getName());
        if (holder.mItem.firstImg.equals("")) {
            holder.firstImg.setVisibility(View.GONE);
        } else {
            holder.firstImg.setVisibility(View.VISIBLE);
            GlideHelper.loadImage(mContext,mValues.get(position).firstImg,holder.firstImg);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final ImageView firstImg;
//        public final TextView mContentView;
        public ArticleContent mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.content_tv);
            firstImg = (ImageView) view.findViewById(R.id.title_img);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + title.getText() + "'";
        }
    }
}
