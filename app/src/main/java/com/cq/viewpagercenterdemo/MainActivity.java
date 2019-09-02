package com.cq.viewpagercenterdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    int colors[] = new int[]{Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.RED};
    Adapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setPageMargin(30);//设置间距
        vp.setOffscreenPageLimit(3);
        adapter = new Adapter();
        vp.setAdapter(adapter);
    }

    class Adapter extends PagerAdapter {
        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final ImageView imageView = new ImageView(MainActivity.this);
            imageView.setBackgroundColor(colors[position]);
            container.addView(imageView);
            imageView.setTag(position);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"hah"+imageView.getTag(),Toast.LENGTH_SHORT).show();
                }
            });

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}

