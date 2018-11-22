package com.example.ricardovalleramire.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.RelativeLayout;

public class Map extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        Button firstButton = (Button) findViewById(R.id.btnBack);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(
         "http://maps.google.com/maps?q=loc:51.5, 0.125"));


        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Map.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
