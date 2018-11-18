package com.example.ricardovalleramire.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class faq extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.faq);
        Button firstButton = (Button) findViewById(R.id.btnBack);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: Clicked Button One!");
                //toastMessage("Clicked Button One");
                Intent intent = new Intent(faq.this, MainActivity.class);
                startActivity(intent);
                //intent= findViewById(R.id.mapView);
            }
        });
    }
}