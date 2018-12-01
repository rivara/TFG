package com.example.ricardovalleramire.myapplication;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import org.json.JSONException;
import org.json.JSONObject;



public class Fetch  extends AsyncTask<Void,Void,String[][]> {
    public static int ID = 0;
    public static int TIME = 1;
    public static int PRESSURE = 2;
    /*LatitudeArray,LongitudeArray,TimeArray,
    HumidityArray,CO2Array,O3Array,
    NO2Array,PM2_5Array,PM10Array*/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected String[][] doInBackground(Void... voids) {
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        // String url = "http://wezalia.com/tfg/user.json";
        String url = "http://wezalia.com/tfg/prueba.php";
        String jsonStr = sh.makeServiceCall(url);

        //Log.e(TAG, "Response from url: " + jsonStr);


        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(jsonStr);

            int nTiempos=jsonObj.length();

            String[] IdArray = new String[nTiempos];
            String[] TimeArray = new String[nTiempos];
            String[] PressureArray = new String[nTiempos];
            String[] LatitudeArray = new String[nTiempos];
            String[] LongitudeArray = new String[nTiempos];
            String[] HumidityArray = new String[nTiempos];
            String[] CO2Array = new String[nTiempos];
            String[] O3Array = new String[nTiempos];
            String[] NO2Array = new String[nTiempos];
            String[] PM2_5Array = new String[nTiempos];
            String[] PM10Array = new String[nTiempos];

            for (int i = 0; i < jsonObj.length(); i++) {
                JSONObject c = jsonObj.getJSONObject(String.valueOf(i));
                IdArray[i] = c.getString("Key");
                TimeArray[i] = ( c.getString("Time"));
                PressureArray[i] =( c.getString("Pressure"));
                LatitudeArray[i] =(c.getString("Latitude"));
                LongitudeArray[i] =(c.getString("Longitude"));
                TimeArray[i] =(c.getString("Temperature"));
                HumidityArray[i] =( c.getString("Humidity"));
                CO2Array[i] =(c.getString("CO2"));
                O3Array[i] =( c.getString("O3"));
                NO2Array[i] =( c.getString("NO2"));
                PM2_5Array[i] =(c.getString("PM2_5"));
                PM10Array[i] =(c.getString("PM10"));

            }
            String[][] valores={
                    IdArray,TimeArray,PressureArray,
                    LatitudeArray,LongitudeArray,TimeArray,
                    HumidityArray,CO2Array,O3Array,
                    NO2Array,PM2_5Array,PM10Array};
            return valores;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}




