//adaptador: intermediario entre interfaz y ---- interpreta datos y los muestra
package com.example.eva1_12_clima_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*Clima[] aClimaCd={
            new Clima (R.drawable.sunny, "Chihuahua", 20.3, "despejado con viento"),
            new Clima (R.drawable.atmospher, "Delicias", 21.3, "viento"),
            new Clima (R.drawable.light_rain, "Parral", 22.3, "truenos"),
            new Clima (R.drawable.rainy, "Casas Grandes", 23.3, "nublado con viento"),
            new Clima (R.drawable.thunderstorm, "La Sierra", 24.3, "lluvia"),
            new Clima (R.drawable.tornado, "Jimenez", 25.3, "nieve"),
            new Clima (R.drawable.cloudy, "Guerrero", 26.3, "soleado"),
            new Clima (R.drawable.snow, "Cuahutemoc", 27.3, "tormenta")
    };*/
    List<Clima> lstCiudades = new ArrayList<>();
    ListView lstVwClima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima=findViewById(R.id.lstVwClima);
       // lstVwClima.setAdapter(new ClimaAdaptador(this,R.layout.mi_lista_clima,aClimaCd));
        conexionClima cc = new conexionClima();
        cc.execute("api.openweathermap.org/data/2.5/find?lat=28.6&lon=-106&cnt=30&units=metric&appid=0d280d274ee1384bf7e982d046f3db4e"); //String URL
    }
                                            //url, nada, json (string)
    class conexionClima extends AsyncTask <String , Void, String>{
        //hacer conexion (trabajo en segundo plano)
        @Override
        protected String doInBackground(String... strings) {
            String sUrl = strings[0];
            String sResu = null;
            //httpURLconnection
            try {
                URL url = new URL(sUrl);
                //CONEXION
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                //verificar si la conexion fue exitosa
                if (httpCon.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //AQUI ES como leer un archivo de texto (inputString)
                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    //convertir info en text con BufferedReader
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResu = brDatos.readLine(); //readLine: pone texto en una sola linea sin importar su tamano
                }
                //CONEXION FIN
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        //llenar la lista con datos
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
          //  Log.wtf("CONEXION", s);
            if(!(s.equals("")|| s == null)){ //verificar que tengamos una respuesta
                //exception porque puede que el formato de cadena que se reciba no sea correcto
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    //RECUPERAR EL ARREGLO DE CIUDADES
                    JSONArray jsonCiudades = jsonObject.getJSONArray("List");
                    for (int i = 0; i<jsonCiudades.length(); i++){
                        JSONObject jsonCiudad = jsonCiudades.getJSONObject(i); //recuperar una ciudad en particular

                        //LEER CIUDAD POR CIUDAD
                        Clima climaCiudad = new Clima();
                        climaCiudad.setCiudad(jsonCiudad.getString("name"));

                        JSONObject jsonMain = jsonCiudad.getJSONObject("main"); //Otro obj json para recuperar elemento ciudad
                        climaCiudad.setTemp(jsonCiudad.getDouble("temp")); //elemento temp

                        //otro obj json pero dentro del arreglo weather
                        //weather tengo que leerlo como si fuera un arreglo
                        JSONArray jsaWeather = jsonCiudad.getJSONArray("weather");

                        //TOMAMOS PRIMER ELEMENTO
                        JSONObject jsonClimaActual = jsaWeather.getJSONObject(0); //temp
                        climaCiudad.setDesc(jsonClimaActual.getString("description")); //descripcion
                        int id = jsonClimaActual.getInt("id"); //recuperar clave
                        if (id<300){ //tormentas
                            climaCiudad.setImagen(R.drawable.thunderstorm);
                        }else if (id<400){ //lluvia ligera
                            climaCiudad.setImagen(R.drawable.light_rain);
                        }else if (id<600){//lluvia
                            climaCiudad.setImagen(R.drawable.rainy);
                        }else if (id<700){//nieve
                            climaCiudad.setImagen(R.drawable.snow);
                        }else if (id<801){
                            climaCiudad.setImagen(R.drawable.sunny);
                        }else if (id<900){
                            climaCiudad.setImagen(R.drawable.cloudy);
                        }else{ //fin del mundo
                            climaCiudad.setImagen(R.drawable.tornado);
                        }
                        lstCiudades.add(climaCiudad);
                    }
                    lstVwClima.setAdapter(new ClimaAdaptador(MainActivity.this));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}