package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateBtn = findViewById(R.id.calculateBtn);
        resultText = findViewById(R.id.resultText);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                    float weight = Float.parseFloat(weightStr);
                    float heightCm = Float.parseFloat(heightStr);
                    float heightM = heightCm / 100;

                    float bmi = weight / (heightM * heightM);
                    String category;

                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi < 25) {
                        category = "Normal weight";
                    } else if (bmi < 30) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    resultText.setText(String.format("BMI: %.2f\nCategory: %s", bmi, category));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter valid inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
