package com.home.example.sqllogin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.home.example.sqllogin.dao.DataBaseHel;

public class Historial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        cargarlista();
        cargaringreso();
    }

    public void cargarlista() {
        DataBaseHel dataBaseHel = new DataBaseHel(this, "DEMOB", null, 1);
        SQLiteDatabase db = dataBaseHel.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from Egreso",null);
            int cantidad = c.getCount();
            int i=0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3);

                    arreglo[i] = linea;
                    i++;
                }while (c.moveToNext());
            }

            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista = (ListView)findViewById(R.id.listhistorial);
            lista.setAdapter(adapter);
        }
    }
    public void cargaringreso() {
        DataBaseHel dataBaseHel = new DataBaseHel(this, "DEMOB", null, 1);
        SQLiteDatabase db = dataBaseHel.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from Ingreso",null);
            int cantidad = c.getCount();
            int i=0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+" "+c.getString(1)+" "+c.getString(2);

                    arreglo[i] = linea;
                    i++;
                }while (c.moveToNext());
            }

            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista = (ListView)findViewById(R.id.listhistorial);
            lista.setAdapter(adapter);
        }
    }
}
