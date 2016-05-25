package com.example.rrafael_cg.prestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PrincipalActivity extends AppCompatActivity {

    ImageButton NuevoPres,VerRegis,Confi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        NuevoPres=(ImageButton)findViewById(R.id.NuevoPres);
        VerRegis=(ImageButton)findViewById(R.id.Verpresta);
        Confi=(ImageButton)findViewById(R.id.Config);

    }

    public void AbrirNuevo(View v) {
        Intent next = new Intent(this, NuevoPres.class);
        this.startActivity(next);
    }


    public void AbrirReg(View v){
        Intent next = new Intent(this, VerReg.class);
        this.startActivity(next);
    }

    public void AbrirConf(View v){
        Intent next = new Intent(this, Conf.class);
        this.startActivity(next);
    }
}
