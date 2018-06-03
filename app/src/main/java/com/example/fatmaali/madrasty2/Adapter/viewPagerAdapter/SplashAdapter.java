package com.example.fatmaali.madrasty2.Adapter.viewPagerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fatmaali.madrasty2.R;

public class SplashAdapter extends PagerAdapter {
    LayoutInflater layoutInflater;
    Context mContext;
    ImageView imageView;
    TextView textView;

    public SplashAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //arrays
    public int[] slide_images = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    public int[] slide_decs = {R.string.splash_text1, R.string.splash_text2, R.string.splash_text3};

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.splash_item_layout, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageSplash);
        imageView.setBackgroundResource(slide_images[position]);
        textView = (TextView) view.findViewById(R.id.txtSplash);
        textView.setText(slide_decs[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
