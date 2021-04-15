//adaptador: intermediario entre interfaz y ---- interpreta datos y los muestra
package com.example.eva1_12_clima_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Clima[] aClimaCd={
            new Clima (R.drawable.sunny, "Chihuahua", 20.3, "despejado con viento"),
            new Clima (R.drawable.atmospher, "Delicias", 21.3, "viento"),
            new Clima (R.drawable.light_rain, "Parral", 22.3, "truenos"),
            new Clima (R.drawable.rainy, "Casas Grandes", 23.3, "nublado con viento"),
            new Clima (R.drawable.thunderstorm, "La Sierra", 24.3, "lluvia"),
            new Clima (R.drawable.tornado, "Jimenez", 25.3, "nieve"),
            new Clima (R.drawable.cloudy, "Guerrero", 26.3, "soleado"),
            new Clima (R.drawable.snow, "Cuahutemoc", 27.3, "tormenta")

    };

    ListView lstVwClima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima.findViewById(R.id.lstVwClima);
        lstVwClima.setAdapter(new ClimaAdaptador(this,R.layout.mi_lista_clima,aClimaCd));
    }
}