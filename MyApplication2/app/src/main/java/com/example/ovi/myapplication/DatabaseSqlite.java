package com.example.ovi.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseSqlite extends SQLiteOpenHelper {
    public static final String DataBase_Name="Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "Address";
    public static final int DbVersion=1;

    DatabaseSqlite(Context context){
        super(context,DataBase_Name,null,DbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY ,NAME TEXT,Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id,String name,String Address){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,Address);
        long results=db.insert(TABLE_NAME,null,contentValues);
        return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public List<DataModel> getdata(){
        // DataModel dataModel = new DataModel();
        List<DataModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new DataModel();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("ID"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
            String address = cursor.getString(cursor.getColumnIndexOrThrow("Address"));
            dataModel.setName("Name :"+name);
            dataModel.setId("Id :"+id);
            dataModel.setAddress("Address :"+address);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo:data ) {
        }

        //

        return data;
    }
}
