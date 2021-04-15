package com.example.eva1_7_radiogroup_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//a traves de clase anonima
public class MainActivity extends AppCompatActivity {
RadioGroup rdGrpComida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdGrpComida = findViewById(R.id.rdGrpComida);
        //
        rdGrpComida.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //se activa cuando hay un cambio de seleccion
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) { //i ayuda a identificar cual evento (RadioGroup) vamos a recibir, se recibe el id (i)
               /* switch (i){
                    case R.id.btnMontados:
                        Toast.makeText(getApplicationContext(),"Burritos",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnAlitas:
                        Toast.makeText(getApplicationContext(),"Alitas",Toast.LENGTH_SHORT).show();
                        break;
                        case R.id.btnGarnachas:
                            Toast.makeText(getApplicationContext(),"Garnachas",Toast.LENGTH_SHORT).show();
                            break;
                    case R.id.btnPizza:
                        Toast.makeText(getApplicationContext(),"Montados",Toast.LENGTH_SHORT).show();
                        break;
                    case  R.id.btnTacos:
                        Toast.makeText(getApplicationContext(),"Tacos",Toast.LENGTH_SHORT).show();

                }*/
                //forma corta
                RadioButton rdBtnsel;
                rdBtnsel = findViewById(i);
                Toast.makeText(getApplicationContext(),rdBtnsel.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}