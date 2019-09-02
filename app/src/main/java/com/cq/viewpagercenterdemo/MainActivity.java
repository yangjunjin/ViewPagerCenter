package com.cq.viewpagercenterdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ViewPager viewPager;
    public ViewPagerAdapter adapter = null;
    public List<ViewPagerBean> list = new ArrayList<>();
    private int mPosition = 0;
    private boolean first = true;
    private boolean show = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++) {
            list.add(new ViewPagerBean("我们"+i,true));
        }

        viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setPageMargin(30);//设置间距
        viewPager.setOffscreenPageLimit(list.size());

        adapter = new ViewPagerAdapter(MainActivity.this, list);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0 && first) {
                    first = false;
                    Log.e("position1===", position + "");
                    View view = adapter.getView(0);
                    animation(view, true);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("position2===", position + "");

                View view = adapter.getView(position);
                View view1 = adapter.getView(mPosition);

                mPosition = position;

                animation(view, true);
                animation(view1, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        adapter.setOnClickListener(new ViewPagerAdapter.OnClickListener() {
            @Override
            public void onClick(boolean show) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewPager.getLayoutParams();
                if (show) {
                    params.width = params.width;
                    params.height = dip2px(300);
                } else {
                    params.width = params.width;
                    params.height = dip2px(200);
                }
                viewPager.setLayoutParams(params);
                viewPager.invalidate();
            }
        });
    }

    public void animation(final View view, boolean show) {
        float start = 0f;
        float end = 0f;
        if (show) {
            start = 0f;
            end = -dip2px(60);
        } else {
            start = 0f;
            end = dip2px(0);
        }
        ObjectAnimator translationY1 = ObjectAnimator.ofFloat(view, "translationY", start, end);
        translationY1.setDuration(100);
        translationY1.start();
    }

    public int dip2px(int dip) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }
}

