package com.carlos.educaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.carlos.educaapp.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnLogin=findViewById(R.id.button);

        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intentLogin=new Intent(this,DashboardActivity.class);
        startActivity(intentLogin);
    }
}
