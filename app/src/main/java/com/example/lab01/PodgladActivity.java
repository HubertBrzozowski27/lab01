package com.example.lab01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PodgladActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getIntent().getIntExtra("layout", 0);
        setContentView(layoutId);
    }
}
