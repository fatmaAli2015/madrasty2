package com.example.fatmaali.madrasty2.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.fatmaali.madrasty2.Model.ModelBasicInf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BasicInfHelper extends SQLiteOpenHelper {


    // private DatabaseHelper DBHelper;
    public static final String TABLE_NAME = "basicInf";
    public static final String COLUMN_SpinnerLearning = "basicInf_SpinnerLearning";
    public static final String COLUMN_SpinnerNum = "basicInf_SpinnerNum";
    public static final String COLUMN_NameOfAdministration = "basicInf_NameOfAdministration";
    public static final String COLUMN_SchoolName = "basicInf_SchoolName";
    public static final String COLUMN_periodFrom = "basicInf_periodFrom";
    public static final String COLUMN_periodTo = "basicInf_periodTo";
    public static final String COLUMN_ID = "_id";

    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "BasicInfManager.db";

    public BasicInfHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SpinnerLearning + "TEXT NOT NULL," +
                COLUMN_SpinnerNum + "TEXT NOT NULL," +
                COLUMN_NameOfAdministration + "TEXT NOT NULL," +
                COLUMN_SchoolName + "TEXT NOT NULL," +
                COLUMN_periodFrom + "NUMBER NOT NULL," +
                COLUMN_periodTo + "NUMBER NOT NULL);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {
        db1.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db1);
    }


    //Method to create records
    public void saveNewBasicInf(ModelBasicInf modelBasicInf) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SpinnerLearning, modelBasicInf.getSpinnerLearning());
        values.put(COLUMN_SpinnerNum, modelBasicInf.getSpinnerNum());
        values.put(COLUMN_NameOfAdministration, modelBasicInf.getNameOfAdministration());
        values.put(COLUMN_SchoolName, modelBasicInf.getSchoolName());
        values.put(COLUMN_periodFrom, modelBasicInf.getPeriodFrom());
        values.put(COLUMN_periodTo, modelBasicInf.getPeriodTo());

        // insert
        database.insert(TABLE_NAME, null, values);
        database.close();

    }

    /**
     * Query records, give options to filter results
     **/
    public List<ModelBasicInf> basicInfsList(String filter) {
        String query;
        if (filter.equals("")) {
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        } else {
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + filter;
        }

        List<ModelBasicInf> modelBasicInfList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelBasicInf modelBasicInf;

        if (cursor.moveToFirst()) {
            do {
                modelBasicInf = new ModelBasicInf();
                modelBasicInf.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                modelBasicInf.setSpinnerLearning(cursor.getString(cursor.getColumnIndex(COLUMN_SpinnerLearning)));
                modelBasicInf.setSpinnerNum(cursor.getString(cursor.getColumnIndex(COLUMN_SpinnerNum)));
                modelBasicInf.setSchoolName(cursor.getString(cursor.getColumnIndex(COLUMN_SchoolName)));
                modelBasicInf.setNameOfAdministration(cursor.getString(cursor.getColumnIndex(COLUMN_NameOfAdministration)));
                modelBasicInf.setPeriodFrom(cursor.getString(cursor.getColumnIndex(COLUMN_periodFrom)));
                modelBasicInf.setPeriodTo(cursor.getString(cursor.getColumnIndex(COLUMN_periodTo)));
                modelBasicInfList.add(modelBasicInf);
            } while (cursor.moveToNext());
        }
        return modelBasicInfList;
    }

    /**
     * Query only 1 record
     **/
    public ModelBasicInf getModelBasicInf(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id=" + id;
        Cursor cursor = db.rawQuery(query, null);

        ModelBasicInf receivedBasicInf = new ModelBasicInf();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedBasicInf.setSpinnerLearning(cursor.getString(cursor.getColumnIndex(COLUMN_SpinnerLearning)));
            receivedBasicInf.setSpinnerNum(cursor.getString(cursor.getColumnIndex(COLUMN_SpinnerNum)));
            receivedBasicInf.setSchoolName(cursor.getString(cursor.getColumnIndex(COLUMN_SchoolName)));
            receivedBasicInf.setNameOfAdministration(cursor.getString(cursor.getColumnIndex(COLUMN_NameOfAdministration)));
            receivedBasicInf.setPeriodFrom(cursor.getString(cursor.getColumnIndex(COLUMN_periodFrom)));
            receivedBasicInf.setPeriodTo(cursor.getString(cursor.getColumnIndex(COLUMN_periodTo)));
        }
        return receivedBasicInf;
    }


    /**
     * delete record
     **/
    public void deleteBasicInfRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE _id='" + id + "'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    /**
     * update record
     **/
    public void updateRecord(long personId, Context context, ModelBasicInf updatedperson) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names
        db.execSQL("UPDATE  " + TABLE_NAME + " SET NameOfAdministration ='" + updatedperson.getNameOfAdministration()
                + "', SchoolName ='" + updatedperson.getSchoolName() + "'," +
                " PeriodFrom ='" + updatedperson.getPeriodFrom() + "'," +
                " PeriodTo ='" + updatedperson.getPeriodTo() + "'  WHERE _id='" + personId + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();


    }


    /**
     * Check if the database exist and can be read.
     *
     * @return true if it exists and can be read, false if it doesn't
     */
//    public boolean checkDataBase() {
//        SQLiteDatabase checkDB = null;
//        try {
//            checkDB = SQLiteDatabase.openDatabase(COLUMN_ID, null,
//                    SQLiteDatabase.OPEN_READONLY);
//            checkDB.close();
//        } catch (SQLiteException e) {
//            // database doesn't exist yet.
//        }
//        return checkDB != null;
//    }
}
