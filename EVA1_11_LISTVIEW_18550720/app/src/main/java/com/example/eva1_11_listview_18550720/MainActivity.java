package com.example.eva1_11_listview_18550720;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    ListView LstVwDatos;
    String[] aDatos = {
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LstVwDatos=findViewById(R.id.LstVwDatos);
        LstVwDatos.setAdapter(new ArrayAdapter<String> //adaptador (ya creado)
                (getApplicationContext(), //contexto
                android.R.layout.simple_list_item_1,
                aDatos //datos
                ));
        //asignar elemento click a la lista
        LstVwDatos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,aDatos[i],Toast.LENGTH_SHORT).show();
        //getAplicationContext y this
        //this porque no estamos en una calse externa

    }
}