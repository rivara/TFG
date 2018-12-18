package com.example.ricardovalleramire.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;

import java.net.StandardSocketOptions;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private String[][] valores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//grafics
        Button firstButton = (Button) findViewById(R.id.btn1);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Graphics.class);
                startActivity(intent);
            }
        });
//statistics
        Button firstButton2 = (Button) findViewById(R.id.btn2);
        firstButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Statistics.class);
                startActivity(intent);
            }
        });

//maps
        Button firstButton3 = (Button) findViewById(R.id.btn3);
        firstButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fetch process = new Fetch();
                process.execute();
                try {
                    valores=process.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Double longitud = Double.parseDouble(valores[Fetch.LONGITUD][0]);
                Double latitud=  Double.parseDouble(valores[Fetch.LATITUD][0]);
                Double longitudFin=-1*(longitud/100);
                Double latitudFin=(latitud/100);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(
                        "http://maps.google.com/maps?q=loc:"+String.valueOf(latitudFin)+","+String.valueOf(longitudFin)));
                startActivity(intent);
            }
        });

//comunicacion
        Button firstButton4 = (Button) findViewById(R.id.btn4);
        firstButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Comunication.class);
                startActivity(intent);
            }
        });


    }
}
