package com.example.eva_1_6_eventos_18550720;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Toast;

public class MiClaseOnClick implements View.OnClickListener {
    Context context;

//CUARTO BOTON 1
    @Override
    public void onClick(View v) {
        Toast.makeText(context, "EVENTO POR CLASE", Toast.LENGTH_LONG).show();
    }

    public void setContext(Context context) {

        this.context = context;
    }
}
