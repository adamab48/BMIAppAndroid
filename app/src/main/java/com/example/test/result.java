package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        Intent resultIntent = getIntent();
        TextView resultText2 = findViewById(R.id.resultA);
        TextView resultText22 = findViewById(R.id.resultA2);

        resultText2.setText(resultIntent.getStringExtra("resultText"));
        resultText22.setTextColor(Color.parseColor(resultIntent.getStringExtra("resultText2_Color")));
        resultText22.setText(resultIntent.getStringExtra("resultText2"));




    }




}