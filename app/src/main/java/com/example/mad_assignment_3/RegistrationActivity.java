package com.example.mad_assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText e_name, e_email, e_password, e_re_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e_name = findViewById(R.id.inputUsername);
        e_email = findViewById(R.id.email);
        e_password = findViewById(R.id.password);
        e_re_password = findViewById(R.id.repassword);
        Button register = findViewById(R.id.regButton);

        register.setOnClickListener(v -> {
            String name = e_name.getText().toString();
            String email = e_email.getText().toString();
            String password = e_password.getText().toString();
            String re_password = e_re_password.getText().toString();
            Bundle bnd = new Bundle();
            bnd.putString("Username",name);
            bnd.putString("Email",email);
            bnd.putString("Password",password);
            bnd.putString("RePassword",re_password);

            if( validationName() && validationEmail() && validationPassword())
            {
                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                i.putExtras(bnd);
                startActivity(i);
            }
        });

    }

    private boolean validationName()
    {
        String val = e_name.getText().toString();
        if (val.isEmpty())
        {
            e_name.setError("Field cannont be emply");
            return false;
        }
        else {
            e_name.setError(null);
            return true;
        }
    }

    private boolean validationEmail()
    {
        String val = e_email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty())
        {
            e_email.setError("Field cannot be empty");
            return false;
        }
        else if (!val.matches((emailPattern)))
        {
            e_email.setError("Invalid Email");
            return false;
        }
        else
            {
            e_email.setError(null);
            return true;
        }
    }

    private boolean validationPassword()
    {
        String val = e_password.getText().toString();
//        String  pattern = "[a-zA-Z0-9._]" + "(?=.*[@#$%^&+=])" + "(?=\\s+$)" + ".{4, }" + "$";
        if (val.isEmpty())
        {
            e_password.setError("Field cannont be emply");
        }
//            else if ( !val.matches((pattern)))
//            {
//                e_password.setError("Password is too weak");
//            }

        else {
            e_password.setError(null);
            return true;
        }
        return false;
    }

//    private boolean validationRe_password(String pass)
//    {
//        String val = e_re_password.getText().toString();
//        if (val.isEmpty())
//        {
//            e_re_password.setError("Field can not be empty");
//            return false;
//        }
//        else if (pass != val)
//        {
//            e_re_password.setError("Password Does not Match");
//            return false;
//        }
//        else
//            {
//            e_re_password.setError(null);
//            return true;
//        }
//
//    }
}