package com.example.fatmaali.madrasty2.Activities.Steps;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatmaali.madrasty2.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BasicInformationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner LearningSpinner, TypeSpinner;
    private Calendar calendar;
    private TextView dateViewStart, dateViewEnd;
    private Toolbar toolbar;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_information);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleTextView = (TextView) findViewById(R.id.toolbar_title);
        titleTextView.setText(R.string.financialCentre);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.f);
        }

        LearningSpinner = (Spinner) findViewById(R.id.idSpinnerLearning);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.typeArray, android.R.layout.simple_spinner_dropdown_item);
        LearningSpinner.setAdapter(adapter);
        LearningSpinner.setOnItemSelectedListener(this);
        TypeSpinner = (Spinner) findViewById(R.id.idSpinnerNum);

        dateViewStart = (TextView) findViewById(R.id.periodFromEdTxt);
        dateViewEnd = (TextView) findViewById(R.id.periodToEdTxt);
        calendar = Calendar.getInstance();
        dateViewStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(BasicInformationActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        dateViewEnd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(BasicInformationActivity.this, date2, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (LearningSpinner.getSelectedItem().equals("عام")) {
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.public_Array, android.R.layout.simple_spinner_dropdown_item);
            TypeSpinner.setAdapter(adapter2);
        } else {
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.technical_Array, android.R.layout.simple_spinner_dropdown_item);
            TypeSpinner.setAdapter(adapter2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateViewStart.setText(sdf.format(calendar.getTime()));
    }

    private void updateLabel2() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateViewEnd.setText(sdf.format(calendar.getTime()));
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };
    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel2();
        }

    };


    public void init() {
        String st = LearningSpinner.getSelectedItem().toString();
        if (st == null && st.isEmpty()) {
            Toast.makeText(BasicInformationActivity.this, "", Toast.LENGTH_LONG).show();

        }

    }

    public void BasicInformation(View view) {
        //  init();
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putInt("value_Predecessor", 1);
        editor.apply();
        finish();
    }


}
