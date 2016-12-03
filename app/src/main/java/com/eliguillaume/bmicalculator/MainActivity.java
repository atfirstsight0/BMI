package com.eliguillaume.bmicalculator;

    // Purpose of this application is to demonstrate comprehension of Android Development basic
    // fundementals.

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float height;
    private float weight;
    private float BMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button compute_button = (Button) findViewById(R.id.compute_button);
        final EditText height_value = (EditText) findViewById(R.id.height);
        final EditText weight_value = (EditText) findViewById(R.id.weight);
        final TextView result = (TextView) findViewById(R.id.result);


        compute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (height_value.getText().length() > 0

                    && weight_value.getText().length() > 0){

                    height = Float.parseFloat(height_value.getText().toString());

                    weight = Float.parseFloat(weight_value.getText().toString());

                    BMI = calculateBMI(weight, height);
                    if (BMI < 16) {
                        result.setText("Your BMI: " + BMI + "(Severely underweight )");
                    } else if (BMI < 18.5) {
                        result.setText("Your BMI: " + BMI + "( Underweight )");
                    } else if (BMI < 25){
                        result.setText("Your BMI: " + BMI + "( Normal )");
                    } else if (BMI < 30) {
                        result.setText("Your BMI: " + BMI + "(Overweight )");
                    } else {
                        result.setText("Your BMI: " + BMI + "(Obese )");
                    }

                }

            }
        });
    }
    private float calculateBMI(float weight, float height){
        height = (height / 100);
        return weight / (height * height);
    }
}
