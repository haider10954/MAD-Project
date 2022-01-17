package com.example.mad_assignment_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Button btn = findViewById(R.id.map);
        btn.setOnClickListener(view ->{
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);
        } );
        txt = findViewById(R.id.email);
        Button btn1 = findViewById(R.id.button_login);
        btn1.setOnClickListener(v -> {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        });
        Bundle bnd = getIntent().getExtras();
        if (bnd != null)
        {
            EditText edt = findViewById(R.id.email);
            EditText edt1 = findViewById(R.id.password);
            String uname = bnd.getString("Email");
            String psd = bnd.getString("Password");
            edt.setText(uname);
            edt1.setText(psd);
        }
    }
}