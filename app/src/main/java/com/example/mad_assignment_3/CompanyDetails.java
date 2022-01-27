package com.example.mad_assignment_3;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_assignment_3.model.Geolocation;

import java.util.Base64;

public class CompanyDetails extends AppCompatActivity {
    TextView textView,Name;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name =findViewById(R.id.companyDetails);
        textView = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String location = bundle.getString("location");
        String year = bundle.getString("year");
        String address = bundle.getString("address");
        double longitude = bundle.getDouble("longitude");
        double latitude = bundle.getDouble("latitude");
//        byte[] decodeimage= Base64.getDecoder().decode(bundle.getByteArray("logo"));

        Name.setText(name);
        textView.setText("Company Name: " + name + "\n" + "Location: " + location + "\n" + "Description: " +
                year+"\n"+"Address"+address+"\n"+ "Geolocation: "+"\n"+longitude+" : "+latitude);
    }
}