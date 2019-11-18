package com.example.ricardovalleramire.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class Stadistics extends AppCompatActivity {
    private String[][] valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stadistics);
        //meto dato

        TextView dataTemp= (TextView) findViewById(R.id.text1);
        TextView dataHumedad= (TextView) findViewById(R.id.text2);
        TextView datapresion= (TextView) findViewById(R.id.text3);
        ProgressBar temperaturaBar = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar humedadBar = (ProgressBar) findViewById(R.id.progressBar2);
        ProgressBar presionBar = (ProgressBar) findViewById(R.id.progressBar3);
        Fetch process = new Fetch();
        process.execute();
        try {
            valores=process.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer temperatura= Integer.parseInt(valores[Fetch.TEMPERATURE][0]);
        Integer humedad= Integer.parseInt(valores[Fetch.HUMIDITY][0]);
        double presion= Double.parseDouble(valores[Fetch.PRESSURE][0]);
        double presionFin= Math.round(presion/10000);
        //alimento los textos + nombr mas valor
        dataTemp.setText("Temperatura: "+String.valueOf(temperatura)+"º");
        dataHumedad.setText("Humedad: "+String.valueOf(humedad)+"%");
        datapresion.setText("Presion: "+String.valueOf(presionFin)+"atms");
        //alimento los bars
        temperaturaBar.setProgress(temperatura);
        humedadBar.setProgress(humedad);
        presionBar.setProgress((int) presionFin);




        Button firstButton = (Button) findViewById(R.id.btnBack);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Stadistics.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}
