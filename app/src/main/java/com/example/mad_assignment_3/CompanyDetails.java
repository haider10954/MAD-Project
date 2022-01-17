package com.example.mad_assignment_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyDetails extends AppCompatActivity {
    TextView textView;
    @SuppressLint("SetTextI18n")@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String location = bundle.getString("location");
        String year = bundle.getString("year");
        textView.setText("Company Name: " + name + "\n" + "Location: " + location + "\n" + "Since: " + year);
    }
}