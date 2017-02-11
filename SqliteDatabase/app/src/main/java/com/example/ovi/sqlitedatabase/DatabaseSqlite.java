package com.example.ovi.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ovi on 1/2/2017.
 */

public class DatabaseSqlite extends SQLiteOpenHelper {
    public static final String DataBase_Name="Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PhnNumber";
    public static final int DbVersion=1;

    DatabaseSqlite(Context context){
        super(context,DataBase_Name,null,DbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY ,NAME TEXT,PhnNumber TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exits "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id,String name,String PhnNumber){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,PhnNumber);
        long results=db.insert(TABLE_NAME,null,contentValues);
        return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
