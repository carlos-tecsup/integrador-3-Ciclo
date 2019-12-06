package com.carlos.educaapp.Activities;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import android.support.v7.widget.Toolbar;

import com.carlos.educaapp.AuthInterceptor;
import com.carlos.educaapp.Pojo.AlumnosPojo;
import com.carlos.educaapp.Pojo.ReportesPojo;
import com.carlos.educaapp.R;
import com.carlos.educaapp.fragments.DetalleAlumnosFragment;
import com.carlos.educaapp.fragments.DetalleIncidenciaFragment;
import com.carlos.educaapp.fragments.ListaAlumnosFragment;
import com.carlos.educaapp.fragments.ListaReportesFragment;
import com.carlos.educaapp.fragments.MonitoreoFragment;
import com.carlos.educaapp.interfaces.IComunicaFragments;
import com.carlos.educaapp.interfaces.IComunicaFragmentsAlumnos;
import com.carlos.educaapp.profile.Perfil;
import com.carlos.educaapp.profile.ProfileFragment;

public class DashboardActivity extends AppCompatActivity implements IComunicaFragments,DetalleAlumnosFragment.OnFragmentInteractionListener, ListaAlumnosFragment.OnFragmentInteractionListener, ListaReportesFragment.OnFragmentInteractionListener, DetalleIncidenciaFragment.OnFragmentInteractionListener {

    ListaAlumnosFragment listaFragment;
    ListaReportesFragment listaReportesFragment;
    DetalleAlumnosFragment detalleAlumnosFragment;
    DetalleIncidenciaFragment detalleFragment;
BottomNavigationView mbottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,listaFragment).commit();*/

   /*     verifyLoginStatus();*/

        listaFragment=new ListaAlumnosFragment();


        listaReportesFragment=new ListaReportesFragment();


        getSupportActionBar().hide();

        setContentView(R.layout.activity_dashboard);

        showSelectedFragment(new ListaReportesFragment());
        mbottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigationView);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.option1){
                    showSelectedFragment(new ListaReportesFragment());
                }
                if (menuItem.getItemId()==R.id.option2){
                    showSelectedFragment(new ListaAlumnosFragment());
                }
               /* if (menuItem.getItemId()==R.id.option3){
                    showSelectedFragment(new MonitoreoFragment());
                }*/
                if (menuItem.getItemId()==R.id.option3){
                    showSelectedFragment(new Perfil());
                }
                return true;
            }
        });


    }




    private void verifyLoginStatus(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean islogged = sp.getBoolean("islogged", false);

        if(!islogged){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

    }

    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit();
    }




    @Override
    public void onFragmentInteraction(Uri uri) {


    }



    public void enviarIncidencia(ReportesPojo reporte) {
        detalleFragment=new DetalleIncidenciaFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("objeto",reporte);
        detalleFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,detalleFragment).addToBackStack(null).commit();
    }




}