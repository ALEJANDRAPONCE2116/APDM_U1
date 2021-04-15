package com.example.eva1_5_findview_2_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ImgVwlohengrin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //crea objetos y variables
        ImgVwlohengrin = findViewById(R.id.ImgVwlohengrin); //conecto el componente
        //ya podemos usar el componente
        ImgVwlohengrin.setImageResource(R.drawable.lohengrin); //recurso de tipo drawable, inicio el componente
        //listeners objeto de los eventos que escuha instrucciones
    }
}