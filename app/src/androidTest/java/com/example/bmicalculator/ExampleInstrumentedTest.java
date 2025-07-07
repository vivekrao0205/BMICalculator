package com.example.bmicalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.bmicalculator", appContext.getPackageName());
    }

    public static class MainActivity extends AppCompatActivity {

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
}