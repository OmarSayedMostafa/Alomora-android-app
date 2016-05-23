package com.example.omar.yamosahel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Omar on 30-Jun-15.
 */
public class DB extends SQLiteOpenHelper
{

    String temp_name,temp_pass;
    public static final String USER_NAME="Name";
    public static final String USER_PASS ="Password";
     public static final String USER_EMAIL ="Email";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database_omar";
    public static final String TABLE_NAME = "sec_try_log";

    public String CREATE_QUERY="CREATE TABLE "+TABLE_NAME+"("+USER_NAME+" TEXT PRIMARY KEY,"+USER_PASS+" TEXT, "+USER_EMAIL+" TEXT)";

    ContentValues values;
    SQLiteDatabase SQ;

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("create Data base done",DATABASE_NAME);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("create table login","done");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void add_into_login(String name,String pass,String email)
    {
         SQ=this.getWritableDatabase();
         values=new ContentValues();
        values.put(USER_NAME,name);
        values.put(USER_PASS,pass);
        values.put(USER_EMAIL,email);
        SQ.insert(TABLE_NAME,null,values);
        this.close();
        Log.e("INSERT","1 ROW INSERTED");
    }

    public  boolean search(String name,String pass) {
        try
        {
             SQ = this.getReadableDatabase();
             Cursor cs=SQ.rawQuery("SELECT * FROM "+TABLE_NAME,null);
            for (cs.moveToFirst();!(cs.isAfterLast());cs.moveToNext())
            {
                if (name.equals(cs.getString(0))==true && pass.equals(cs.getString(1))==true)
                {
                    Log.e("search","found");
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            Log.e("error","search database");
        }

        return  false;
    }

    public  boolean search_primary(String name) {
        try
        {
            SQ = this.getReadableDatabase();
            Cursor cs=SQ.rawQuery("SELECT * FROM "+TABLE_NAME,null);
            for (cs.moveToFirst();!(cs.isAfterLast());cs.moveToNext())
            {
                if (name.equals(cs.getString(0))==true )
                {
                    Log.e("search","found");
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            Log.e("error","search database");
        }

        return  false;
    }

}
