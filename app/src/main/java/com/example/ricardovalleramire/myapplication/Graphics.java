package com.example.ricardovalleramire.myapplication;



import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;


class Graphics extends AppCompatActivity {

    public static TextView data;
    private String[][] valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphics);


        //SACA DATOS + GENERA GRAFICA

        Button firstButton = (Button) findViewById(R.id.json);
        data = (TextView) findViewById(R.id.textView);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                //PieChart pieChart = (PieChart) findViewById(R.id.piechart);
                Fetch process = new Fetch();
                process.execute();
                try {
                    valores=process.get();
                    Graphics.data.setText(valores[Fetch.PRESSURE][0]);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    Graphics.data.setText(e.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Graphics.data.setText(e.toString());
                }
            }
        });

        // VUELVE A LA PÁGINA PRINCIPAL
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Graphics.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }




}