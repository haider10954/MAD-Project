package com.example.mad_assignment_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Base64;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_assignment_3.model.Geolocation;

public class CompanyDetails extends AppCompatActivity {
    TextView textView,Name;
    double longitude, latitude;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name =findViewById(R.id.companyDetails);
        textView = findViewById(R.id.textView);
        Button button=findViewById(R.id.button2);
        ImageView Disp = findViewById(R.id.Image);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String location = bundle.getString("location");
        String year = bundle.getString("year");
        String address = bundle.getString("address");
        longitude = bundle.getDouble("longitude");
        latitude = bundle.getDouble("latitude");
        String logo=bundle.getString("logo");
        String base64Image=logo.split(",")[1];
        byte[] decodeimage= Base64.decode(base64Image,Base64.DEFAULT);
        Bitmap decodebyte = BitmapFactory.decodeByteArray(decodeimage,0, decodeimage.length);
        Disp.setImageBitmap(decodebyte);
        Name.setText(name);
        textView.setText("Company Name: " + name + "\n" + "Location: " + location + "\n" + "Description: " +
                year+"\n"+"Address"+address+"\n"+ "Geolocation: "+"\n"+longitude+" : "+latitude);
        button.setOnClickListener(V->toMaps());
    }
    public void toMaps(){
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("longitude",longitude);
        intent.putExtra("latitude",latitude);
        startActivity(intent);
    }

}