package com.example.rrafael_cg.prestapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class NuevoPres extends AppCompatActivity {

    Spinner cmb;
    DatePicker fecDev;
    EditText art,per;
    TextView hoy;
    ImageButton agregar,limpiar;
    GregorianCalendar fechaHoy;

    int ncat;
    String fh,fe;
    //Instancias de los objetos que utilizaremos en esta clase


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pres);

        //manejador = new DBManager(this);//Utilizamos este context
        cmb=(Spinner)findViewById(R.id.spinner);
        cmb.setBackgroundColor(Color.LTGRAY);
        fecDev=(DatePicker)findViewById(R.id.datePicker);
        fecDev.setBackgroundColor(Color.LTGRAY);
        art=(EditText)findViewById(R.id.editText);
        per=(EditText)findViewById(R.id.editText2);
        agregar=(ImageButton)findViewById(R.id.imageButton2);
        limpiar=(ImageButton)findViewById(R.id.imageButton);
        hoy=(TextView)findViewById(R.id.fec);
        fechaHoy= new GregorianCalendar();
        fh=getFechaHoy();
        hoy.setText(fh);
        fe=getFechaEntr();

    }


    private boolean valCamp(){
        if(art.getText().toString().isEmpty()|| per.getText().toString().isEmpty()||cmb.getSelectedItemPosition()==1||valFech()){
            return false;
        }
        return true;

    }

    private boolean valFech(){
        fe=getFechaEntr();
        fh=getFechaHoy();
        String h[],e[];
        h=fh.split("/");
        e=fe.split("/");
        if(Integer.parseInt(h[0])>=Integer.parseInt(e[0])//Valida año
                &&Integer.parseInt(h[1])>=Integer.parseInt(e[1])
                &&Integer.parseInt(h[2])>=Integer.parseInt(e[2])){
            return false;
        }
        return true;

    }

    private String getFechaHoy() {   //En este metodo acomodamos una cadena con la fecha que ira en el textView llamado hoy
        if (fechaHoy.get(Calendar.DAY_OF_MONTH) < 10 && fechaHoy.get(Calendar.MONTH) < 10) {
            return fechaHoy.get(Calendar.YEAR)+"-0"+(1+fechaHoy.get(Calendar.MONTH))+"-0"+fechaHoy.get(Calendar.DAY_OF_MONTH);
        } else if (fechaHoy.get(Calendar.DAY_OF_MONTH) < 10) {
            return fechaHoy.get(Calendar.YEAR)+"-"+(1+fechaHoy.get(Calendar.MONTH))+"-0"+ fechaHoy.get(Calendar.DAY_OF_MONTH);
        } else if (fechaHoy.get(Calendar.MONTH) < 10) {
            return fechaHoy.get(Calendar.YEAR)+"-0"+(1+fechaHoy.get(Calendar.MONTH))+"-"+fechaHoy.get(Calendar.DAY_OF_MONTH);
        } else {
            return fechaHoy.get(Calendar.YEAR)+"-"+(1+fechaHoy.get(Calendar.MONTH))+"-"+ fechaHoy.get(Calendar.DAY_OF_MONTH);
        }
    }

    private String getFechaEntr(){
        if (fecDev.getDayOfMonth()< 10 && fecDev.getMonth() < 10) {
            return fecDev.getYear()+"-0"+(1+fecDev.getMonth()+"-0"+fecDev.getDayOfMonth());
        } else if (fecDev.getDayOfMonth()< 10) {
            return fecDev.getYear()+"-"+(1+fecDev.getMonth()+"-0"+ fecDev.getDayOfMonth());
        } else if (fecDev.getMonth() < 10) {
            return fecDev.getYear()+"-0"+(1+fecDev.getMonth()+"-"+fecDev.getDayOfMonth());
        } else {
            return fecDev.getYear()+"-"+(1+fecDev.getMonth()+"/"+ fecDev.getDayOfMonth());
        }
    }

    public void Limpiar(View view){
        cmb.setSelection(0);
        art.setText("");
        per.setText("");
    }
}
