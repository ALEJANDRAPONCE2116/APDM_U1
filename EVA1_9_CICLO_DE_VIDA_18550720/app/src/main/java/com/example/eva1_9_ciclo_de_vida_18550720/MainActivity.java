package com.example.eva1_9_ciclo_de_vida_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this ,"onResume", Toast.LENGTH_SHORT).show();
    }

    @Override 
    protected void onPause() {
        super.onPause();
        Toast.makeText(this ,"onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this ,"onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this ,"onDestroy", Toast.LENGTH_SHORT).show();
    }
}

/*onCreate de appcompact activity que queda oculto
    onCreate de appMainActivity que se muestra
    lo sobreescribo (hago overrride de los metodos)
    super sirve para llamar todo el codigo va despues del super*/