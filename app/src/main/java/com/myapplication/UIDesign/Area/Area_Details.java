package com.myapplication.UIDesign.Area;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.myapplication.UIDesign.R;

public class Area_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area__details);
        Bundle title = getIntent().getExtras();
        setTitle(title.getString("areaTitle"));
    }
}