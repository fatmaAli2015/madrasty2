package com.example.fatmaali.madrasty2.Activities;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatmaali.madrasty2.Adapter.viewPagerAdapter.CardViewPagerAdapter;
import com.example.fatmaali.madrasty2.Model.CardItems;
import com.example.fatmaali.madrasty2.R;

public class CustomNavActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CardViewPagerAdapter mCardViewPagerAdapter;
    private Toolbar toolbar;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_nav);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);

        titleTextView = (TextView) findViewById(R.id.toolbar_title);
        titleTextView.setText("مدرستي");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.f);
        }

        mViewPager = (ViewPager) findViewById(R.id.viewPagerCard);
        mCardViewPagerAdapter = new CardViewPagerAdapter(this);
        mCardViewPagerAdapter.addCardView(new CardItems(R.drawable.img1, R.string.elmrtabat));
        mCardViewPagerAdapter.addCardView(new CardItems(R.drawable.cardfinancial, R.string.financialCentre));
        mCardViewPagerAdapter.addCardView(new CardItems(R.drawable.img2, R.string.book));


        mViewPager.setAdapter(mCardViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.app_bar_menu) {
            Toast.makeText(this, "hello", Toast.LENGTH_LONG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
