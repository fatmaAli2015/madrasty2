package com.example.fatmaali.madrasty2.Activities.Steps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatmaali.madrasty2.Adapter.RecyclerView.dynamic.PredecessorAdapter;
import com.example.fatmaali.madrasty2.Model.ModelPredecessor;
import com.example.fatmaali.madrasty2.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.fatmaali.madrasty2.Utilities.ArrayStringNames.names;

public class PredecessorActivity extends AppCompatActivity {
    private ArrayList<ModelPredecessor> mProducts;
    private PredecessorAdapter adapter;

    RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView titleTextView, textViewPredecessor1, textViewPredecessor2,
            textViewPredecessor3, textViewPredecessor4, textViewPredecessor5, textViewPredecessor6, textViewTotal;
    private int mTotalScrolled = 0;
    AsyncTask asyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predecessor);
        //      mProducts = new ArrayList<>();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleTextView = (TextView) findViewById(R.id.toolbar_title);

        titleTextView.setText(R.string.predecessor);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.f);
        }

        mProducts = new ArrayList<>();
        textViewPredecessor1 = (TextView) findViewById(R.id.predecessor1);
        textViewPredecessor2 = (TextView) findViewById(R.id.predecessor2);
        textViewPredecessor3 = (TextView) findViewById(R.id.predecessor3);
        textViewPredecessor4 = (TextView) findViewById(R.id.predecessor4);
        textViewPredecessor5 = (TextView) findViewById(R.id.predecessor5);
        textViewPredecessor6 = (TextView) findViewById(R.id.predecessor6);
        textViewTotal = (TextView) findViewById(R.id.total);

        initRecyclerView();
        getDate();

    }


    private void getDate() {
        for (int j = 0; j < names.length; j++) {

            mProducts.add(new ModelPredecessor("", "",
                    "", "", "", "", names[j], j));

        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = (RecyclerView) findViewById(R.id.recylerViewFinScrolling);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //       recyclerView.setItemViewCacheSize(20);
//        recyclerView.setDrawingCacheEnabled(true);
//        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                mTotalScrolled += dy;
//
//            }
//        });
        //  recyclerView.setNestedScrollingEnabled(false);
        adapter = new PredecessorAdapter(mProducts, this);
        recyclerView.setAdapter(adapter);

    }

    private int getScrollForRecycler() {
        return mTotalScrolled;
    }

    public void getClick() {
        List<ModelPredecessor> allData = adapter.getModelPredecessorList();
        int predecessor1 = 0;
        int predecessor2 = 0;
        int predecessor3 = 0;
        int predecessor4 = 0;
        int predecessor5 = 0;
        int predecessor6 = 0;
        int g = 0;
        for (int i = 0; i < allData.size(); i++) {
            if (allData.get(i).Predecessor1 != "")
                predecessor1 += Integer.parseInt(String.valueOf(allData.get(i).Predecessor1));
            else predecessor1 += 0;
            if (allData.get(i).Predecessor2 != "")
                predecessor2 += Integer.parseInt(String.valueOf(allData.get(i).Predecessor2));
            else predecessor2 += 0;
            if (allData.get(i).Predecessor3 != "")
                predecessor3 += Integer.parseInt(String.valueOf(allData.get(i).Predecessor3));
            else predecessor3 += 0;
            if (allData.get(i).Predecessor4 != "")
                predecessor4 += Integer.parseInt(String.valueOf(allData.get(i).Predecessor4));
            else predecessor4 += 0;
            if (allData.get(i).Predecessor5 != "")
                predecessor5 += Integer.parseInt(String.valueOf(allData.get(i).Predecessor5));
            else predecessor5 += 0;
            if (allData.get(i).Predecessor6 != "")
                predecessor6 += Integer.parseInt(String.valueOf(allData.get(i).Predecessor6));
            else predecessor6 += 0;
        }
        g += predecessor1 + predecessor2 + predecessor3 + predecessor4 + predecessor5 + predecessor6;

        textViewPredecessor1.setText(predecessor1 + "");
        textViewPredecessor2.setText(predecessor2 + "");
        textViewPredecessor3.setText(predecessor3 + "");
        textViewPredecessor4.setText(predecessor4 + "");
        textViewPredecessor5.setText(predecessor5 + "");
        textViewPredecessor6.setText(predecessor6 + "");

        textViewTotal.setText(g + "");
        Toast.makeText(PredecessorActivity.this, predecessor1 + "", Toast.LENGTH_LONG).show();
    }

    public void btn_Predecessor(View view) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putInt("value_Predecessor", 2);
        editor.apply();
        getClick();
        finish();
    }

    public void totalAppear(View view) {
        getClick();
    }
}
