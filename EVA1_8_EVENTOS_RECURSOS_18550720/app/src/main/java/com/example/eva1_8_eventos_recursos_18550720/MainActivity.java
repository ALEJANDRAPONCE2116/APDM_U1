package com.example.eva1_8_eventos_recursos_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener {
    TextView txtVwNom, txtVwApe;
    EditText edtTxtNom, edtTxtApe;
    RadioGroup rdGrpIdioma;
    RadioButton rdBtnEs, rdBtnIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vincular componentes
        txtVwApe=findViewById(R.id.txtVwApe);
        txtVwNom=findViewById(R.id.txtVwNom);
        edtTxtApe=findViewById(R.id.edtTxtApe);
        edtTxtNom=findViewById(R.id.edtTxtNom);
        rdGrpIdioma=findViewById(R.id.rdGrpIdioma);
        rdBtnEs=findViewById(R.id.rdBtnEs);
        rdBtnIn=findViewById(R.id.rdBtnIn);
        //asignamos listener: al radiogroup (listener son todos los objetos que implementan el metodo OnCheckChange y los derivados del MainActivity
        rdGrpIdioma.setOnCheckedChangeListener(this);

        //asignar evento a radiogroup por listener main activity

    }

    /*todo objeto que sea instanciado de main activity ya funciona como un listener para este evento en particular*/
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.rdBtnEs){
            txtVwNom.setText(R.string.txt_vw_nom);
            edtTxtNom.setText(R.string.edt_txt_nom);
            txtVwApe.setText(R.string.txt_vw_ape);
            edtTxtApe.setText(R.string.edt_txt_ape); //setHint
            rdBtnEs.setText(R.string.rd_btn_es);
            rdBtnIn.setText(R.string.rd_btn_in);

        }else{
            txtVwNom.setText(R.string.txt_vw_nom_en);
            edtTxtNom.setText(R.string.edt_txt_nom_en);
            txtVwApe.setText(R.string.txt_vw_ape_en);
            edtTxtApe.setText(R.string.edt_txt_ape_en);
            rdBtnEs.setText(R.string.rd_btn_es_en);
            rdBtnIn.setText(R.string.rd_btn_in_en);
        }
    }
}