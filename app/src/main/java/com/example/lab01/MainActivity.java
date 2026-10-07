package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        otworz(R.id.b1, R.layout.zadanie1);
        otworz(R.id.b2, R.layout.zadanie2);
        otworz(R.id.b3, R.layout.zadanie3);
        otworz(R.id.b4, R.layout.zadanie4);
        otworz(R.id.b5, R.layout.zadanie5);
        otworz(R.id.b6, R.layout.zadanie6);

        findViewById(R.id.b7).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, Zadanie7Activity.class)));
    }

    private void otworz(int przyciskId, int layoutId) {
        findViewById(przyciskId).setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, PodgladActivity.class);
            i.putExtra("layout", layoutId);
            startActivity(i);
        });
    }
}
