package com.example.eva_1_6_eventos_18550720;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener { //SEGUNDO BOTON
    Button btnListener, btnClaseAnonima, btnPorClase;
@SuppressLint("aaa")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListener = findViewById(R.id.btnListener);
        btnClaseAnonima=findViewById(R.id.btnClaseAnonima);
        btnPorClase=findViewById(R.id.btnPorClase);
        btnListener.setOnClickListener(this);
        //btnClaseAnonima.setOnClickListener(this);
        btnClaseAnonima.setOnClickListener(new View.OnClickListener() {
            @Override
            //TERCER BOTON
            public void onClick(View view) { //clase anonima, no se puede reutilizar
                Toast.makeText(getApplicationContext(), "EVENTO POR CLASE ANONIMA", Toast.LENGTH_LONG).show();//implementacion;
            }
        });
        //CUARTO BOTON 2
    MiClaseOnClick objClick= new MiClaseOnClick();
    objClick.setContext(this);
    btnPorClase.setOnClickListener(objClick);
}
    //PRIMER BOTON
    public void miClick(View arg){ //interface: declaración e implemetación
        //MOSTRAR UN MENSAJE TOAST
        Toast.makeText(this, "EVENTO ONCLICK CON XML", Toast.LENGTH_LONG).show();

    }

    //SEGUNDO BOTON
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "EVENTO POR LISTENER", Toast.LENGTH_SHORT).show();
    }
   // interface  x { //no se pueden crear objetos de interfaces porque no pueden instanciarse (dar memoria)

    }
