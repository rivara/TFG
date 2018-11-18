package com.example.ricardovalleramire.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
public class Map extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.map);
        Button firstButton = (Button) findViewById(R.id.btnBack);
        // Default google map
        //get values from bbdd
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(
                "http://maps.google.com/maps?q=loc:51.5, 0.125"));

       startActivity(intent);
        //myHabitsMap=intent();
        //intentar hacer lo mismo en lugar de btn id del map
        //Button firstButton = (Button) findViewById(R.id.btnBack);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: Clicked Button One!");
                //toastMessage("Clicked Button One");
                Intent intent = new Intent(Map.this, MainActivity.class);
                startActivity(intent);
                //intent= findViewById(R.id.mapView);
            }
        });



    }
}
