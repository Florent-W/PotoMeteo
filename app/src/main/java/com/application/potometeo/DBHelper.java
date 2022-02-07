package com.application.potometeo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBcountries.db";
    public static final String CITY_TABLE_NAME = "City";
    public static final String CITY_COLUMN_CITY = "name";
    public static final String CITY_COLUMN_COUNTRY = "country";
    public static final String CITY_COLUMN_LAT = "lat";
    public static final String CITY_COLUMN_LON = "lon";
    public static final String POTO_TABLE_NAME = "Poto";
    public static final String POTO_COLUMN_IMG = "ImgName";
    public static final String POTO_COLUMN_LINK = "ImgLink";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder query = new StringBuilder();
        query.append(
                String.format(
                        "create table %s (id int, %s text, %s text, %s text, %s text); "
                        , CITY_TABLE_NAME, CITY_COLUMN_CITY, CITY_COLUMN_COUNTRY, CITY_COLUMN_LAT, CITY_COLUMN_LON
                )
        );
        Log.d("QUERY", query.toString());
        sqLiteDatabase.execSQL(query.toString());
        query = new StringBuilder();
        query.append(
                String.format(
                        "create table %s (id int, %s text, %s text); "
                        , POTO_TABLE_NAME, POTO_COLUMN_IMG, POTO_COLUMN_LINK
                )
        );
        Log.d("QUERY", query.toString());
        sqLiteDatabase.execSQL(query.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", CITY_TABLE_NAME));
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", POTO_TABLE_NAME));
        onCreate(sqLiteDatabase);
    }

    @SuppressLint("Range")
    public City getCity() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(
                String.format(
                        "select * from %s where id = 1", CITY_TABLE_NAME)
                , null
        );
        if (res.moveToFirst()) {
            return new City(
                    null,
                    res.getString(res.getColumnIndex(CITY_COLUMN_CITY)),
                    res.getString(res.getColumnIndex(CITY_COLUMN_COUNTRY)),
                    res.getString(res.getColumnIndex(CITY_COLUMN_LAT)),
                    res.getString(res.getColumnIndex(CITY_COLUMN_LON))
            );
        } else {
            return null;
        }
    }

    public boolean setCity(String name, String country, String lat, String lon) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (getCity() == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", 1);
            contentValues.put(CITY_COLUMN_CITY, "");
            contentValues.put(CITY_COLUMN_COUNTRY, "");
            contentValues.put(CITY_COLUMN_LAT, "");
            contentValues.put(CITY_COLUMN_LON, "");
            db.insert(CITY_TABLE_NAME, null, contentValues);
        }
        String query = String.format(
                "update %s set %s = ?, %s = ?, %s = ?, %s = ? where id = 1"
                , CITY_TABLE_NAME, CITY_COLUMN_CITY, CITY_COLUMN_COUNTRY, CITY_COLUMN_LAT, CITY_COLUMN_LON
        );
        SQLiteStatement stmt = db.compileStatement(query);
        stmt.bindString(1, name);
        stmt.bindString(2, country);
        stmt.bindString(3, lat);
        stmt.bindString(4, lon);
        return stmt.executeUpdateDelete() == 1;
    }

    @SuppressLint("Range")
    public String getPotoImg() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(
                String.format(
                        "select * from %s where id = 1"
                        , POTO_TABLE_NAME
                ), null);
        if (res.moveToFirst()) {
            return res.getString(res.getColumnIndex(POTO_COLUMN_IMG));
        } else {
            return null;
        }
    }

    @SuppressLint("Range")
    public String getPotoLink() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(
                String.format(
                        "select * from %s where id = 1"
                        , POTO_TABLE_NAME
                ), null);
        if (res.moveToFirst()) {
            return res.getString(res.getColumnIndex(POTO_COLUMN_LINK));
        } else {
            return null;
        }
    }

    public boolean setPoto(String imgName, String imgLink) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (getPotoImg() == null || getPotoLink() == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", 1);
            contentValues.put(POTO_COLUMN_IMG, "");
            contentValues.put(POTO_COLUMN_LINK, "");
            db.insert(POTO_TABLE_NAME, null, contentValues);
        }
        String query = String.format(
                "update %s set %s = ?, %s = ? where id = 1"
                , POTO_TABLE_NAME, POTO_COLUMN_IMG, POTO_COLUMN_LINK
        );
        SQLiteStatement stmt = db.compileStatement(query);
        stmt.bindString(1, imgName);
        stmt.bindString(2, imgLink);
        return stmt.executeUpdateDelete() == 1;
    }

}