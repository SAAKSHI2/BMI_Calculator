package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView3;
    EditText editTextNumber,editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView3 = findViewById(R.id.textView3);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double w = Double.parseDouble(editTextNumber.getText().toString());
                double h = Double.parseDouble(editTextNumber2.getText().toString());
                textView3.setTextColor(Color.parseColor("#C0CA33"));
                double cal = (w / (h * h)) * 10000;
                cal = Math.round(cal * 100) / 100;
                textView3.setText("BMI is : " + cal + "\n");
                if (cal < 18.5)
                    textView3.append("You are Underweight");
                else if (cal >= 18.5 && cal <= 24.9)
                    textView3.append("You are healthy");
                else if (cal > 24.9 && cal <= 29.9)
                    textView3.append("You are Overweight");
                else if (cal >= 30.0) {
                    textView3.setTextColor(Color.parseColor("#FF0000"));
                    textView3.append("You are at risk for Obesity");
                }

            }
        });
    }
}