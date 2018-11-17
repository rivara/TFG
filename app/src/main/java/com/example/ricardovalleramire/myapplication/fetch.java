package com.example.ricardovalleramire.myapplication;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import static android.content.ContentValues.TAG;

public class fetch  extends AsyncTask<Void,Void,String> {
    //v funcional
    String data="";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    protected String doInBackground(Void... voids) {
        httpHandler sh = new httpHandler();
        // Making a request to url and getting response
        // String url = "http://wezalia.com/tfg/user.json";
        String url = "http://wezalia.com/tfg/prueba.php";
        String jsonStr = sh.makeServiceCall(url);

        Log.e(TAG, "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                // Getting JSON User node
                //data= jsonObj.toString();
                String Id ="";
                String Time ="";
                String Pressure="";
                String Latitude ="";
                String Longitude="";
                String Temperature="";
                String Humidity ="";
                String CO2="";
                String O3="";
                String NO2="";
                String PM2_5="";
                String PM10="";
                List<String> IdArray = new ArrayList<String>();
                List<String> TimeArray = new ArrayList<String>();
                List<String> PressureArray = new ArrayList<String>();
                List<String> LatitudeArray = new ArrayList<String>();
                List<String> LongitudeArray = new ArrayList<String>();
                List<String> HumidityArray = new ArrayList<String>();
                List<String> CO2Array = new ArrayList<String>();
                List<String> O3Array = new ArrayList<String>();
                List<String> NO2Array = new ArrayList<String>();
                List<String> PM2_5Array = new ArrayList<String>();
                List<String> PM10Array = new ArrayList<String>();

                for (int i = 0; i < jsonObj.length(); i++) {
                    JSONObject c = jsonObj.getJSONObject(String.valueOf(i));
                    Id = c.getString("Key");
                    Time = c.getString("Time");
                    PressureArray.add( c.getString("Pressure"));
                    LatitudeArray.add(c.getString("Latitude"));
                    LongitudeArray.add(c.getString("Longitude"));
                    TimeArray.add(c.getString("Temperature"));
                    HumidityArray.add( c.getString("Humidity"));
                    CO2Array.add(c.getString("CO2"));
                    O3Array.add( c.getString("O3"));
                    NO2Array.add( c.getString("NO2"));
                    PM2_5Array.add(c.getString("PM2_5"));
                    PM10Array.add(c.getString("PM10"));

                }


                data=";"+TimeArray+";"+PressureArray;






            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());

            }

        } else {
            Log.e(TAG, "Couldn't get json from server.");

        }

        return null;
    }


    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Graphics.data.setText(this.data);

    }
}




