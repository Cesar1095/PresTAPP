package com.example.rrafael_cg.prestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Conf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf);
    }

    public void OpenNT(View view){
        Intent next = new Intent(this, NuevoTipo.class);
        this.startActivity(next);
    }
}
