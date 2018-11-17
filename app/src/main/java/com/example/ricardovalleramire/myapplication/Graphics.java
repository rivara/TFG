package com.example.ricardovalleramire.myapplication;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphics);

     /*   SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = curFormater.parse(dateStr);
        SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");

        String newDateStr = postFormater.format(dateObj);*/

        //SACA DATOS + GENERA GRAFICA

        Button firstButton = (Button) findViewById(R.id.json);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PieChart pieChart = (PieChart) findViewById(R.id.piechart);

                fetch process = new fetch();
                String datos=process.execute().toString();
                //obtener el hilo json entero y parsearlo a string

                // data= (TextView) findViewById(R.id.msgTxt);
                //String datos = data.getText().toString();


                //splitearlo
              /* String[] datas = datos.split(";");

                String part1 = datas[1]; // 004
                String part2 = datas[1]; // 034556*/


                //recogerlo en un array

                Log.d(TAG,"prueba");



                //pasar ese array de string a numero


/*
                LineChart chart = findViewById(R.id.linechart);

                ArrayList<Entry> entries = new ArrayList<>();
                entries.add(new Entry(myNum, 4));
                entries.add(new Entry(1, 1));
                entries.add(new Entry(2, 2));
                entries.add(new Entry(3, 4));

                LineDataSet dataSet = new LineDataSet(entries, "Customized values");
                //dataSet.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
                //dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));


                // Controlling X axis
                XAxis xAxis = chart.getXAxis();
                // Set the xAxis position to bottom. Default is top
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                //Customizing x axis value
                final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr"};

                IAxisValueFormatter formatter = new IAxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        return months[(int) value];
                    }
                };
                xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
                xAxis.setValueFormatter(formatter);


                // Controlling right side of y axis
                YAxis yAxisRight = chart.getAxisRight();
                yAxisRight.setEnabled(false);


                // Controlling left side of y axis
                YAxis yAxisLeft = chart.getAxisLeft();
                yAxisLeft.setGranularity(1f);

                // Setting Data
                LineData data = new LineData(dataSet);
                chart.setData(data);
                chart.animateX(2500);
                //refresh
                chart.invalidate();

*/

                //PIECHART OK
            /*    PieChart mChart = (PieChart) findViewById(R.id.piechart);

                List<PieEntry> pieChartEntries = new ArrayList<>();

                pieChartEntries.add(new PieEntry(18.5f, "Green"));
                pieChartEntries.add(new PieEntry(26.7f, "Yellow"));
                pieChartEntries.add(new PieEntry(24.0f, "Red"));
                pieChartEntries.add(new PieEntry(30.8f, "Blue"));

                PieDataSet set = new PieDataSet(pieChartEntries, "Emotion Results");
                PieData data = new PieData(set);
                mChart.setData(data);
                mChart.invalidate();

                set.setColors(ColorTemplate.COLORFUL_COLORS);
                set.setColors(new int[]{Color.parseColor("#FF32DA64"),
                        Color.parseColor("#FF32DAD4"),
                        Color.parseColor("#FFB853F2"),
                        Color.parseColor("#FFF2ED53")});
*/





                // Intent intent = new Intent(Graphics.this, MainActivity.class);
                // startActivity(intent);
                //llamada ala clase fetch que hace conexion con el json


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