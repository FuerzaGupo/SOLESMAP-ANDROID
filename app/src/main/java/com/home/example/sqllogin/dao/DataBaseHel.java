package com.home.example.sqllogin.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc on 04/07/2017.
 */

public class DataBaseHel extends SQLiteOpenHelper {

    String tablaEgreso = "CREATE TABLE egreso(id_egreso INTEGER PRIMARY KEY AUTOINCREMENT, egreso Text, detalle TEXT)";

    public DataBaseHel(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(tablaEgreso);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
