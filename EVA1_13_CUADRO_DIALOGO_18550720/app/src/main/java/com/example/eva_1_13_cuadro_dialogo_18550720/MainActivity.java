package com.example.eva_1_13_cuadro_dialogo_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickDSistema(View v){
        new AlertDialog.Builder(this) //crea el obj
                .setTitle("Cuadro de dialogo Android")
                .setMessage("hola mundo")
                .setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"boton OK", Toast.LENGTH_SHORT).show();
                            }
                        })
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"boton NO", Toast.LENGTH_SHORT).show();
                            }
                        })
                .setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"boton CANCEL", Toast.LENGTH_SHORT).show();
                            }
                        })
                .show();
    }

    public void onClickDCustom(View v){
        Dialog dIMiCuadroDialogo=new Dialog(this);
        dIMiCuadroDialogo.setContentView(R.layout.cuadro_dialogo); //asignar layout
        //vincular componentes
        TextView txtVwTitulo;
        EditText edTxtDatos;
        Button btnAccion;

        txtVwTitulo=dIMiCuadroDialogo.findViewById(R.id.txtVwTitulo);
        edTxtDatos=dIMiCuadroDialogo.findViewById(R.id.ediTxtDatos);
        btnAccion=dIMiCuadroDialogo.findViewById(R.id.BtnAccion);

        txtVwTitulo.setText("Este es un cuadro de dialogo");
        new  View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),edTxtDatos.getText().toString(),
                        Toast.LENGTH_SHORT)
            }
        }
    }
}