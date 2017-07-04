package com.home.example.sqllogin;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.home.example.sqllogin.dao.DataBaseHelpe;

public class Ingreso extends AppCompatActivity {

    EditText ingresos,detalless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        ingresos = (EditText) findViewById(R.id.montoingreso);
        detalless = (EditText) findViewById(R.id.detalleingreso);
    }
    public void GuardarDatosIngreso(View view){
        String detalles = ingresos.getText().toString();
        String plat = detalless.getText().toString();;

        DataBaseHelpe dataBaseHelpe = new DataBaseHelpe(this,"DEMOB",null,1);
        SQLiteDatabase db = dataBaseHelpe.getWritableDatabase();
        if (db!=null){

            ContentValues registroingreso = new ContentValues();
            registroingreso.put("detalle",detalles);
            registroingreso.put("ingreso",plat);

            long i = db.insert("Ingreso",null,registroingreso);
            if(i>0){
                Toast.makeText(this,"ingresado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
