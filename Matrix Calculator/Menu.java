package com.mat.matrixcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button multiplication;
    private Button addition;
    private Button subtraction;
    private Button inverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Intent sendSpecVal = new Intent(Menu.this, mainInput.class);
        final Intent startInverse = new Intent(Menu.this, InverseScreen.class);

        multiplication = (Button) findViewById(R.id.multiplication);
        multiplication.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int specVal = 3;
                sendSpecVal.putExtra("SPECVAL", specVal);
                startActivity(sendSpecVal);
            }
        }));

        addition = (Button) findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int specVal = 1;
                sendSpecVal.putExtra("SPECVAL", specVal);
                startActivity(sendSpecVal);
            }
        });
        subtraction = (Button) findViewById(R.id.subtraction);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int specVal = 2;
                sendSpecVal.putExtra("SPECVAL", specVal);
                startActivity(sendSpecVal);
            }
        });

        inverse = (Button) findViewById(R.id.inverse);
        inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startInverse);
            }
        });




    }


}