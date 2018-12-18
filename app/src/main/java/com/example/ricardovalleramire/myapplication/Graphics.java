package com.example.ricardovalleramire.myapplication;



import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;



class Graphics extends AppCompatActivity {

    public static TextView time;
    public static TextView pm;
    public static TextView o3;
    public static TextView co2;
    public static TextView no2;
    private String[][] valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Carga de elementos
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphics);
        time = (TextView) findViewById(R.id.txtTime);
        //Fecha del sistema
        Date currentTime = Calendar.getInstance().getTime();
        Graphics.time.setText(String.valueOf(currentTime));
        Button btnTemperatura = (Button) findViewById(R.id.btn1);
        Button btnParticulas = (Button) findViewById(R.id.btn2);
        LineChart chart = findViewById(R.id.lineChart);
        pm = findViewById(R.id.PM);
        o3 = findViewById(R.id.O3);
        co2 = findViewById(R.id.CO2);
        no2 = findViewById(R.id.NO2);
        //Datos
        Fetch process = new Fetch();
        process.execute();
        try {
            valores=process.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pm.setText(String.valueOf(valores[Fetch.PM2][0])+"ug/m3");
        o3.setText(String.valueOf(valores[Fetch.O3][0])+"ppb");
        co2.setText(String.valueOf(valores[Fetch.CO2][0])+"ppb ");
        no2.setText(String.valueOf(valores[Fetch.NO2][0])+"ppm");

        //PRIMERA ESTADISTICA
        btnTemperatura.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                // PieChart pieChart = (PieChart) findViewById(R.id.linechart);
                Fetch process = new Fetch();
                process.execute();
                try {
                    valores=process.get();
                LineChart chart = findViewById(R.id.lineChart);
                ArrayList<Entry> entries = new ArrayList<>();
                entries.add(new Entry(0, Integer.parseInt(valores[Fetch.TEMPERATURE][0])));
                entries.add(new Entry(1, Integer.parseInt(valores[Fetch.TEMPERATURE][1])));
                entries.add(new Entry(2, Integer.parseInt(valores[Fetch.TEMPERATURE][2])));
                entries.add(new Entry(3, Integer.parseInt(valores[Fetch.TEMPERATURE][3])));

                LineDataSet dataSet = new LineDataSet(entries, "Customized values");
                //dataSet.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
                //dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
                    dataSet.setDrawFilled(true);
                    dataSet.setFillColor(Color.RED);
                // Controlling X axis
                XAxis xAxis = chart.getXAxis();
                // Set the xAxis position to bottom. Default is top
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                //Customizing x axis value
                final String[] months = new String[]{valores[Fetch.TIME][0], valores[Fetch.TIME][1], valores[Fetch.TIME][0], valores[Fetch.TIME][0]};

                IAxisValueFormatter formatter = new IAxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        return months[(int) value];
                    }
                };
                xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
                xAxis.setValueFormatter(formatter);

                //***
                // Controlling right side of y axis
                YAxis yAxisRight = chart.getAxisRight();
                yAxisRight.setEnabled(false);

                //***
                // Controlling left side of y axis
                YAxis yAxisLeft = chart.getAxisLeft();
                yAxisLeft.setGranularity(1f);
                // Setting Data
                LineData data = new LineData(dataSet);
                chart.setData(data);

                chart.animateX(2500);
                //refresh
                chart.invalidate();


                } catch (ExecutionException e) {
                    e.printStackTrace();
                   // Graphics.data.setText(e.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                   // Graphics.data.setText(e.toString());
                }
            }
        });


        //SEGUNDA  ESTADISTICA
        btnParticulas.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                // PieChart pieChart = (PieChart) findViewById(R.id.linechart);
                Fetch process = new Fetch();
                process.execute();
                try {
                    valores=process.get();
                    LineChart chart = findViewById(R.id.lineChart);
                    ArrayList<Entry> entries = new ArrayList<>();

                    entries.add(new Entry(0, Integer.parseInt(valores[Fetch.PM2][0])));
                    entries.add(new Entry(1, Integer.parseInt(valores[Fetch.PM2][1])));
                    entries.add(new Entry(2, Integer.parseInt(valores[Fetch.PM2][2])));
                    entries.add(new Entry(3, Integer.parseInt(valores[Fetch.PM2][3])));

                    LineDataSet dataSet = new LineDataSet(entries, "Customized values");
                    //dataSet.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    //dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
                    dataSet.setDrawFilled(true);
                    dataSet.setFillColor(Color.RED);
                    //****
                    // Controlling X axis
                    XAxis xAxis = chart.getXAxis();
                    // Set the xAxis position to bottom. Default is top
                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                    //Customizing x axis value
                    final String[] months = new String[]{valores[Fetch.TIME][0], valores[Fetch.TIME][1], valores[Fetch.TIME][0], valores[Fetch.TIME][0]};

                    IAxisValueFormatter formatter = new IAxisValueFormatter() {
                        @Override
                        public String getFormattedValue(float value, AxisBase axis) {
                            return months[(int) value];
                        }
                    };
                    xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
                    xAxis.setValueFormatter(formatter);

                    //***
                    // Controlling right side of y axis
                    YAxis yAxisRight = chart.getAxisRight();
                    yAxisRight.setEnabled(false);

                    //***
                    // Controlling left side of y axis
                    YAxis yAxisLeft = chart.getAxisLeft();
                    yAxisLeft.setGranularity(1f);
                    // Setting Data
                    LineData data = new LineData(dataSet);
                    chart.setData(data);

                    chart.animateX(2500);
                    //refresh
                    chart.invalidate();


                } catch (ExecutionException e) {
                    e.printStackTrace();
                    // Graphics.data.setText(e.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // Graphics.data.setText(e.toString());
                }
            }
        });
//#


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