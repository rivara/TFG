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

      //preguntar en stackoverflow como encapsular un mapa
        // Default google map
        //get values from bbdd
        // Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(
        // "http://maps.google.com/maps?q=loc:51.5, 0.125"));

        // web on_blank
        //WebView mWebView = (WebView) findViewById(R.id.view);
        //mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.getSettings().setMinimumFontSize(1);
        //mWebView.getSettings().setMinimumLogicalFontSize(1);
        //mWebView.loadUrl("http://www.google.com");



        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Map.this, MainActivity.class);
                startActivity(intent);

            }
        });



    }
}
