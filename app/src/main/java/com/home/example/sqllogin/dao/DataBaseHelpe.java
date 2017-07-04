package com.home.example.sqllogin.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc on 04/07/2017.
 */

public class DataBaseHelpe extends SQLiteOpenHelper {

    String tablaIngreso = "CREATE TABLE Ingreso(id_ingreso INTEGER PRIMARY KEY AUTOINCREMENT, ingreso Text, detalle TEXT)";
    public DataBaseHelpe(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaIngreso);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
