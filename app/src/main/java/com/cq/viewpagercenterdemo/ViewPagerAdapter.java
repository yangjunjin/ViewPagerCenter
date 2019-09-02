package com.cq.viewpagercenterdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${YangJunJin}
 * on 2019/9/2
 */
public class ViewPagerAdapter extends PagerAdapter {
    public Context mContext;
    public List<String> mlist = new ArrayList<>();
    public List<View> viewList = new ArrayList<>();

    public ViewPagerAdapter(Context context, List<String> list) {
        mlist.addAll(list);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.item_viewpager, null);
        container.addView(view);
        TextView textView = view.findViewById(R.id.tvName);

        textView.setText(mlist.get(position));
        viewList.add(view);
        return view;
    }

    public View getView(int position) {
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}