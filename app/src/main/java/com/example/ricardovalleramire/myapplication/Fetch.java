package com.example.ricardovalleramire.myapplication;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import org.json.JSONException;
import org.json.JSONObject;



public class Fetch  extends AsyncTask<Void,Void,String[][]> {
    public static int KEY = 0;
    public static int ID = 1;
    public static int PRESSURE = 2;
    public static int TIME = 3;
    public static int LATITUD = 4;
    public static int LONGITUD=5;
    public static int TEMPERATURE = 6;
    public static int HUMIDITY =7;
    public static int CO2 =8;
    public static int O3 =9;
    public static int NO2 =10;
    public static int  PM2 =11;
    public static int PM10=12;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected String[][] doInBackground(Void... voids) {
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        // String url = "http://wezalia.com/tfg/user.json";
        String url = "http://wezalia.com/tfg/datos.php";
        String jsonStr = sh.makeServiceCall(url);
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(jsonStr);

            int nTiempos=jsonObj.length();
            String[] IdKeyArray = new String[nTiempos];
            String[] IdArray = new String[nTiempos];
            String[] PressureArray = new String[nTiempos];
            String[] TimeArray = new String[nTiempos];
            String[] LatitudeArray = new String[nTiempos];
            String[] LongitudeArray = new String[nTiempos];
            String[] TemperatureArray = new String[nTiempos];
            String[] HumidityArray = new String[nTiempos];
            String[] CO2Array = new String[nTiempos];
            String[] O3Array = new String[nTiempos];
            String[] NO2Array = new String[nTiempos];
            String[] PM2_5Array = new String[nTiempos];
            String[] PM10Array = new String[nTiempos];

            for (int i = 0; i < jsonObj.length(); i++) {
                JSONObject c = jsonObj.getJSONObject(String.valueOf(i));
                IdKeyArray[i] = c.getString("Key");
                IdArray[i] = c.getString("ID");
                PressureArray[i] =( c.getString("Pressure"));
                TimeArray[i] = ( c.getString("Time"));
                LatitudeArray[i] =(c.getString("Latitude"));
                LongitudeArray[i] =(c.getString("Longitude"));
                TemperatureArray[i] =(c.getString("Temperature"));
                HumidityArray[i] =( c.getString("Humidity"));
                CO2Array[i] =(c.getString("CO2"));
                O3Array[i] =( c.getString("O3"));
                NO2Array[i] =( c.getString("NO2"));
                PM2_5Array[i] =(c.getString("PM2_5"));
                PM10Array[i] =(c.getString("PM10"));

            }
            String[][] valores={IdKeyArray,IdArray,PressureArray,TimeArray,
                    LatitudeArray,LongitudeArray,TemperatureArray,
                    HumidityArray,CO2Array,O3Array,
                    NO2Array,PM2_5Array,PM10Array};
            return valores;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}




