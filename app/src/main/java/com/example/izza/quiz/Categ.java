package com.example.izza.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categ extends AppCompatActivity {

    Button btnFlags,btnFruits,btnLegumes,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categ);

        btnFlags = (Button) findViewById(R.id.btnFlags);
        btnFlags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLegumes = (Button) findViewById(R.id.btnLegume);
        btnLegumes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), legumes.class);
                startActivity(intent);
                finish();
            }
        });

        btnFruits = (Button) findViewById(R.id.btnFruit);
        btnFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fruits.class);
                startActivity(intent);
                finish();
            }
        });

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Animal.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
