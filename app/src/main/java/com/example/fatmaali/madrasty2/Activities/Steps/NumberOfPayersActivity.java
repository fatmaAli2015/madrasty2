package com.example.fatmaali.madrasty2.Activities.Steps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatmaali.madrasty2.Adapter.RecyclerView.dynamic.NumberOfPayersAdapter;
import com.example.fatmaali.madrasty2.Model.ModelNumOfPayers;
import com.example.fatmaali.madrasty2.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.fatmaali.madrasty2.Utilities.ArrayStringNames.names;

public class NumberOfPayersActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleTextView, result_75, result_100, total;
    RecyclerView recyclerView;
    NumberOfPayersAdapter adapter;
    ArrayList<ModelNumOfPayers> mProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of_payers);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleTextView = (TextView) findViewById(R.id.toolbar_title);

        titleTextView.setText(R.string.NumberOfPayers);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.f);
        }
        mProducts = new ArrayList<>();
        result_75 = (TextView) findViewById(R.id.result_75);
        result_100 = (TextView) findViewById(R.id.result_100);
        total = (TextView) findViewById(R.id.total);
        initRecyclerView();
        getDate();
    }

    private void getDate() {
        for (int j = 0; j < names.length; j++) {

            mProducts.add(new ModelNumOfPayers("", "",
                    names[j], j));

        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = (RecyclerView) findViewById(R.id.recylerViewFinScrolling);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        adapter = new NumberOfPayersAdapter(mProducts, this);
        recyclerView.setAdapter(adapter);

    }

    public void NumberOfPayers() {
        List<ModelNumOfPayers> AllData = adapter.getModelNumOfPayersList();
        int NumberOfPayers75 = 0, NumberOfPayers100 = 0, g = 0;
        for (int i = 0; i < AllData.size(); i++) {
            if (AllData.get(i).numOfPayers75 != "") {
                NumberOfPayers75 += Integer.parseInt(String.valueOf(AllData.get(i).numOfPayers75));
            } else NumberOfPayers75 += 0;
            if (AllData.get(i).numOfPayers100 != "") {
                NumberOfPayers100 += Integer.parseInt(String.valueOf(AllData.get(i).numOfPayers100));
            } else NumberOfPayers100 += 0;
        }
        result_75.setText(NumberOfPayers75 + "");
        result_100.setText(NumberOfPayers100 + "");
        g += NumberOfPayers75 + NumberOfPayers100;
        total.setText(g + "");
        Toast.makeText(this, g + "", Toast.LENGTH_LONG).show();
    }

    public void totalAppear(View view) {
        NumberOfPayers();
    }

    public void btn_Payers(View view) {
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putInt("value_Predecessor", 3);
        editor.apply();
        finish();
        NumberOfPayers();
    }
}
