package com.home.example.sqllogin;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.home.example.sqllogin.dao.DataBaseHel;

public class Salida extends AppCompatActivity {
    EditText detalle,plata,egres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salida);

        detalle = (EditText) findViewById(R.id.ingdetalle);
        plata = (EditText) findViewById(R.id.ingplata);

    }
    public void GuardarDatos(View view){
        String detalles = detalle.getText().toString();
        String plat = plata.getText().toString();;

        DataBaseHel dataBaseHel = new DataBaseHel(this,"DEMOB",null,1);
        SQLiteDatabase db = dataBaseHel.getWritableDatabase();
        if (db!=null){

            ContentValues registroingreso = new ContentValues();
            registroingreso.put("detalle",detalles);
            registroingreso.put("egreso",plat);

            long i = db.insert("Egreso",null,registroingreso);
            if(i>0){
                Toast.makeText(this,"ingresado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
