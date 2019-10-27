package com.carlos.educaapp.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.carlos.educaapp.R;
import com.carlos.educaapp.fragments.Lista;
import com.carlos.educaapp.fragments.Perfil;
import com.carlos.educaapp.fragments.Alumnos;
import com.carlos.educaapp.fragments.Reportes;

public class DashboardActivity extends AppCompatActivity {


BottomNavigationView mbottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);
        showSelectedFragment(new Reportes());
        mbottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigationView);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.option1){
                    showSelectedFragment(new Reportes());
                }
                if (menuItem.getItemId()==R.id.option2){
                    showSelectedFragment(new Alumnos());
                }
                if (menuItem.getItemId()==R.id.option3){
                    showSelectedFragment(new Lista());
                }
                if (menuItem.getItemId()==R.id.option4){
                    showSelectedFragment(new Perfil());
                }
                return true;
            }
        });







    }
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit();
    }



}