package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.mainbutton);
        TextView resultText = findViewById(R.id.result);
        TextView resultText2 = findViewById(R.id.result2);


        EditText nameInput = findViewById(R.id.nameText);


        EditText heightInput = findViewById(R.id.HeightText);
        EditText weightInput = findViewById(R.id.WeightText);


        RadioButton woman =  findViewById(R.id.womanRB);
        RadioButton man =  findViewById(R.id.manRB);









        button.setOnClickListener((View.OnClickListener) v -> {

            try {
                String gender = "";
                String color = "#FFFFFF";
                String result2Text = "";
                String nameText = nameInput.getText().toString();
                double h =  Double.parseDouble(heightInput.getText().toString());
                int w =  Integer.parseInt(weightInput.getText().toString());

                boolean flag = false; // flag to set whether we are using another activity or just using the main one


                if (woman.isChecked()) {

                    gender = "Ms";

                }
                else if (man.isChecked()) {

                        gender = "Mr";

                } else {
                    resultText.setText("Please Select a Gender");
                    return;
                }

                double bmi = Math.round(w / Math.pow(h , 2)) ;
                System.out.println("Weight"+w);
                System.out.println("Height"+h);
                System.out.println("Gender"+gender);
                System.out.println(bmi);



                if (bmi < 16) {
                    result2Text = "Severe Thinness";
                    color = "#FF0000"; // Red
                } else if (bmi >= 16 && bmi < 17) {
                    result2Text = "Moderate Thinness";
                    color = "#FFA500"; // Orange
                } else if (bmi >= 17 && bmi < 18.5) {
                    result2Text = "Mild Thinness";
                    color = "#FFFF00"; // Yellow
                } else if (bmi >= 18.5 && bmi < 25) {
                    result2Text = "Normal";
                    color = "#008000"; // Green
                } else if (bmi >= 25 && bmi < 30) {
                    result2Text = "Overweight";
                    color = "#0000FF"; // Blue
                } else if (bmi >= 30 && bmi < 35) {
                    result2Text = "Obese Class I";
                    color = "#800080"; // Purple
                } else if (bmi >= 35 && bmi < 40) {
                    result2Text = "Obese Class II";
                    color = "#FFC0CB"; // Pink
                } else {
                    result2Text = "Obese Class III";
                    color = "#800000"; // Maroon
                }

                String resultTextfinal = gender+" "+nameText+" your IMC is "+bmi;
                if (flag == true) {
                    resultText.setText(resultTextfinal);

                    resultText2.setText(result2Text);
                    resultText2.setTextColor(Color.parseColor(color));
                    resultText2.setTextSize(20);
                }
                else {


                    Intent resultIntent = new Intent(this, result.class);
                    resultIntent.putExtra("resultText" , resultTextfinal);
                    resultIntent.putExtra("resultText2" , result2Text);
                    resultIntent.putExtra("resultText2_Color" , color);

                    startActivity(resultIntent);


                }


            }
            catch (Exception e)
            {
                resultText.setText("Please Enter your details");
            }
        });
    }

    }