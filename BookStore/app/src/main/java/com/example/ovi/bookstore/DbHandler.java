package com.example.ovi.bookstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ovi on 1/21/2017.
 */

public class DbHandler extends SQLiteOpenHelper {

    public static final String DataBase_Name="bookShop.db";
    public static final String TABLE_NAME = "bookStore";
    public static final String COL_1 = "BookID";
    public static final String COL_2 = "BookNAME";
    public static final String COL_3 = "Quantity";
    public static final String COL_4 = "Price";
    public static final int DbVersion=1;

    ContentValues cValues;
    SQLiteDatabase database=null;
    Cursor cursor;

    DbHandler (Context context){
        super(context,DataBase_Name,null,DbVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table"+TABLE_NAME+"(BookID TEXT PRIMARY KEY,BookNAME TEXT,Quantity INTEGER,Price INTEGER )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exits......"+TABLE_NAME);
        onCreate(db);
    }

    public void InsertRecord(String BookID, String BookName,Integer Quantity, Integer Price){
        database=getWritableDatabase();
        cValues=new ContentValues();
        cValues.put(COL_1,BookID);
        cValues.put(COL_2,BookName);
        cValues.put(COL_3,Quantity);
        cValues.put(COL_4,Price);

        database.insert(TABLE_NAME,null,cValues);
        database.close();
    }
    public void UpdateRecord(String BookID, String BookName,Integer Quantity, Integer Price){
        database=getWritableDatabase();
        cValues=new ContentValues();
        cValues.put(COL_1,BookID);
        cValues.put(COL_2,BookName);
        cValues.put(COL_3,Quantity);
        cValues.put(COL_4,Price);

        database.update(TABLE_NAME,cValues,null,null);
        database.close();
    }

    public void DeleteRecord(String BookID){
        database=getWritableDatabase();
        cValues.put(COL_1,BookID);
        database.delete(TABLE_NAME,null,null);
    }
    public Cursor ViewRecords() {
        database = getReadableDatabase();
        cursor = database.rawQuery("Select * from" + TABLE_NAME, null);
        return cursor;
    }
}
