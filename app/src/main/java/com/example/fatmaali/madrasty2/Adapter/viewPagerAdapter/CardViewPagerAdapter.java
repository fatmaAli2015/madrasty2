package com.example.fatmaali.madrasty2.Adapter.viewPagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fatmaali.madrasty2.Activities.Categories.FinancialCentreActivity;
import com.example.fatmaali.madrasty2.Model.CardItems;
import com.example.fatmaali.madrasty2.R;

import java.util.ArrayList;
import java.util.List;


public class CardViewPagerAdapter extends PagerAdapter {

    private List<LinearLayout> mViews;
    private List<CardItems> mItems;

    Context mCon;

    public CardViewPagerAdapter(Context mCon) {
        this.mCon = mCon;
        mViews = new ArrayList<>();
        mItems = new ArrayList<>();
    }

    public void addCardView(CardItems items) {
        mViews.add(null);
        mItems.add(items);
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public LinearLayout getCardViewAt(int position) {
        return mViews.get(position);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.card_viewpager_layout, container, false);

        container.addView(view);
        bind(mItems.get(position), view);

        LinearLayout parentLL = (LinearLayout) view.findViewById(R.id.parentLL);
        android.support.constraint.ConstraintLayout linearLayout = (android.support.constraint.ConstraintLayout) view.findViewById(R.id.linearCardViewPager);
        LinearLayout linearLayoutCon = (LinearLayout) view.findViewById(R.id.cardView);

//        mViews.set(position, linearLayout);
        mViews.set(position,parentLL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (position == 0) {
                parentLL.setPadding(40, 10, 0, 10);
                linearLayout.setBackgroundResource(R.drawable.cardbg1);
            } else if (position == 1) {
                linearLayout.setBackgroundResource(R.drawable.cardbg);
                linearLayoutCon.setPadding(30, 0, 30, 0);
                linearLayoutCon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCon.startActivity(new Intent(mCon, FinancialCentreActivity.class));

                    }
                });
            } else {
                linearLayout.setBackgroundResource(R.drawable.cardbg2);
                parentLL.setPadding(0, 10, 40, 10);

            }

        }
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItems item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.TextCard);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgCard);
        titleTextView.setText(item.getmTitle());
        imageView.setImageResource(item.getImages());
    }


}


