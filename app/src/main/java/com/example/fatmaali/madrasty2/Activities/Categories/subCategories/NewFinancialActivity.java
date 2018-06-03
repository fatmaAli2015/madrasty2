package com.example.fatmaali.madrasty2.Activities.Categories.subCategories;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatmaali.madrasty2.Activities.Steps.BasicInformationActivity;
import com.example.fatmaali.madrasty2.Activities.Steps.NumberOfPayersActivity;
import com.example.fatmaali.madrasty2.Activities.Steps.OtherDepositsActivity;
import com.example.fatmaali.madrasty2.Activities.Steps.PredecessorActivity;
import com.example.fatmaali.madrasty2.Activities.Steps.PreviousBalanceActivity;
import com.example.fatmaali.madrasty2.Activities.Steps.PrintingActivity;
import com.example.fatmaali.madrasty2.Model.ModelNewFinancialCentre;
import com.example.fatmaali.madrasty2.R;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;

public class NewFinancialActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<ModelNewFinancialCentre> mProducts;
    private Toolbar toolbar;
    private TextView titleTextView;
    private LinearLayout BasicInfLayout, predecessorLayout,
            NumberOfPayersLayout, previousBalanceLayout, OtherDepositsLayout, printingLayout;
    FrameLayout contacts_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_financial);
        initViews();
        initClickListener();

    }

    // initialize Views
    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleTextView = (TextView) findViewById(R.id.toolbar_title);
        titleTextView.setText(R.string.financialCentre);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.f);
        }

        mProducts = new ArrayList<>();
        BasicInfLayout = (LinearLayout) findViewById(R.id.basicInfLayout);
        predecessorLayout = (LinearLayout) findViewById(R.id.predecessorLayout);
        NumberOfPayersLayout = (LinearLayout) findViewById(R.id.NumberOfPayersLayout);
        previousBalanceLayout = (LinearLayout) findViewById(R.id.previousBalanceLayout);
        OtherDepositsLayout = (LinearLayout) findViewById(R.id.OtherDepositsLayout);
        printingLayout = (LinearLayout) findViewById(R.id.printingLayout);
        //   contacts_type = (FrameLayout) findViewById(R.id.contacts_type);
    }

    // initialize clickItems
    private void initClickListener() {
        BasicInfLayout.setOnClickListener(this);
        predecessorLayout.setOnClickListener(this);
        NumberOfPayersLayout.setOnClickListener(this);
        previousBalanceLayout.setOnClickListener(this);
        OtherDepositsLayout.setOnClickListener(this);
        printingLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        SharedPreferences pref = getSharedPreferences("data", Context.MODE_PRIVATE);
        switch (v.getId()) {
            case R.id.basicInfLayout:
                startActivity(new Intent(NewFinancialActivity.this, BasicInformationActivity.class));
                break;
            case R.id.predecessorLayout:
                Log.e("errorFatma1", "error");
                if (pref.getInt("value_Predecessor", 1) >= 1)
                    startActivity(new Intent(NewFinancialActivity.this, PredecessorActivity.class));
                //   else {
        //        Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
//                    DialogPlus dialog = DialogPlus.newDialog(this)
//                            .setGravity(Gravity.TOP)
//                            .setContentHolder(new ViewHolder(R.layout.top_item_layout))
//                            .setOnItemClickListener(new OnItemClickListener() {
//                                @Override
//                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
//                                }
//                            })
//                            .setExpanded(true,150)  // This will enable the expand feature, (similar to android L share dialog)
//                            .create();
//                    dialog.show();
                // }
                break;
            case R.id.NumberOfPayersLayout:
                Log.e("errorFatma2", "error");
                if (pref.getInt("value_Predecessor", 2) >= 2)
                    startActivity(new Intent(NewFinancialActivity.this, NumberOfPayersActivity.class));
                break;
            case R.id.previousBalanceLayout:
                Log.e("errorFatma3", "error");
                if (pref.getInt("value_Predecessor", 3) >= 3)
                    startActivity(new Intent(NewFinancialActivity.this, PreviousBalanceActivity.class));
                break;
            case R.id.OtherDepositsLayout:
                Log.e("errorFatma4", "error");
                if (pref.getInt("value_Predecessor", 4) >= 4)
                    startActivity(new Intent(NewFinancialActivity.this, OtherDepositsActivity.class));
                break;
            case R.id.printingLayout:
                Log.e("errorFatma5", "error");
                if (pref.getInt("value_Predecessor", 5) >= 5)
                    startActivity(new Intent(NewFinancialActivity.this, PrintingActivity.class));
                break;
        }
    }
}

