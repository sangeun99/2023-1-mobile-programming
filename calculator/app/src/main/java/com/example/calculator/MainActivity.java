package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = (EditText) findViewById(R.id.editNum1);
        editNum2 = (EditText) findViewById(R.id.editNum2);
        btnCalc = (Button) findViewById(R.id.btnCalc);

    }

    public void mOnClick(View v){

    }
}