package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username,password;

    Button login;
    String userName = "user1";
    String passWord = "password1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.user);
        password=findViewById(R.id.pass);
        login=findViewById(R.id.loginBtn);


        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext()," Please enter both username or password",Toast.LENGTH_LONG).show();
        }else if(!username.getText().toString().equals(userName)||!password.getText().toString().equals(passWord))
        {
            Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_LONG).show();
        }else
        {
            Intent intent = new Intent(this, CountryActivity.class);
            startActivity(intent);
        }
    }
}