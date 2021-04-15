package com.example.eva1_4_findview_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //numero, tipo, nombre.
        //falta conectar varieble con el widget
        txtVwMensaje= findViewById(R.id.TtxVwMensaje); //R hace referencia al numero del ID (como no se el numero pongo R).
        txtVwMensaje.setText("hola mundo cluel");
    }
}