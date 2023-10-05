package com.example.emi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   // declared variables for all calculation and widgets
    TextView EMI;
    EditText userMortgage, interestRate, duration;
    Button calculate;
    double mortgage, months, interest;
    double results , pow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //correlating each each widget to a variable
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EMI = (TextView) findViewById(R.id.EMI);
        duration = (EditText) findViewById(R.id.duration);
        calculate = (Button) findViewById(R.id.calculate);
        interestRate = (EditText) findViewById(R.id.interestRate);
        userMortgage = (EditText) findViewById(R.id.userMortgage);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // takes user input and places it in double variables
                mortgage = Double.parseDouble(userMortgage.getText().toString());
                interest = Double.parseDouble(interestRate.getText().toString());
                months = Double.parseDouble(duration.getText().toString());
                //using the RMI formula calculate EMI
                pow = Math.pow((1+((interest /100)/12)),(months *12));
                results = mortgage * ((interest /100)/12) * (pow/(pow-1));
                // using the results that was calculated it will round and output
                EMI.setText(String.valueOf(Math.round(results * 100.0) / 100.0));

            }
        });




    }
}