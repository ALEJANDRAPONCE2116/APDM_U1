package com.example.eva_1_6_eventos_18550720;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener { //SEGUNDO BOTON
    Button btnListener, btnClaseAnonima, btnPorClase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListener = findViewById(R.id.btnListener);
        btnListener.setOnClickListener(this);
        btnClaseAnonima=findViewById(R.id.btnClaseAnonima);
        btnPorClase=findViewById(R.id.btnPorClase);

        btnClaseAnonima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //clase anonima, no se puede reutilizar
                Toast.makeText(getApplicationContext(), "EVENT POR CLASE ANONIMA", Toast.LENGTH_SHORT).show(); //implementacion
//get sirve para recuperar el contexto (recurso de la actividad, principalmente graficos)
            }
        });
        btnPorClase.setOnClickListener(new MiClaseOnClick() {
            @Override
            public void onClick(View view) {

            }
        });

        MiClaseOnClick objClick = new MiClaseOnClick();
        objClick.
        //view> objetos graficos, layout, widgets
        //todos los widgets tienen una propiedad llamada onclick
        //public void nombredelmetodo (View arg)
        //interface es solo declarar, estructura que declara metodos y propiedades pero no las implementa. pues dentro de las llaves se implementa.
        }
        //PRIMER BOTON
    public void miClick (View arg) { //declaracion
        Toast.makeText(this, "EVENT POR ONCLICK XML", Toast.LENGTH_SHORT).show(); //implementacion
    }

    @Override //SEGUNDO BOTON
    public void onClick(View view) {
        Toast.makeText(this, "EVENTO POR LISTENER", Toast.LENGTH_SHORT).show();
    }

    interface X{
    }
    //TERCER BOTON


}