package com.carlos.educaapp.profile;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.carlos.educaapp.Activities.DashboardActivity;
import com.carlos.educaapp.Activities.MainActivity;
import com.carlos.educaapp.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    private Toolbar toolbar;

    private String nombreUser;
    private String apellidoUser;
    private String emailUser;
    private String DniUsuario;


    private TextView nombreUserText;
    private TextView apellidoUserText;
    private TextView emailUserText;
    private TextView dniUserText;


    private Button BotonSalir;


    public Perfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_perfil, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setTitle("PERFIL");


        nombreUserText=(TextView)view.findViewById(R.id.nombreUser);
        apellidoUserText=(TextView)view.findViewById(R.id.apellidosUser);
        emailUserText=(TextView)view.findViewById(R.id.correoUser);
        dniUserText=(TextView)view.findViewById(R.id.DniUser);
        BotonSalir = (Button)view.findViewById(R.id.BotonSalir);

        nombreUserText.setText(nombreUser);
        apellidoUserText.setText(apellidoUser);
        emailUserText.setText(emailUser);
        dniUserText.setText(DniUsuario);



        BotonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        return view;

    }






    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.main,menu);


    }

    @Override
    public void onCreate( Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        verifyLoginStatus();

        setHasOptionsMenu(true);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());

        nombreUser = sp.getString("nombre", "usuario");
        apellidoUser=sp.getString("apellido","usuario");
        emailUser=sp.getString("email","usuario");
        DniUsuario=sp.getString("dni","usuario");



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_logout:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void verifyLoginStatus(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean islogged = sp.getBoolean("islogged", false);

        if(!islogged){
            Intent intent = new Intent();
            intent.setClass(getActivity(), MainActivity.class);
            getActivity().startActivity(intent);
        }

    }


    private void logout(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        sp.edit().remove("islogged").remove("token").commit();
        sp.edit().remove("islogged").remove("dni").commit();
        sp.edit().remove("islogged").remove("nombre").commit();
        sp.edit().remove("islogged").remove("apellido").commit();
        sp.edit().remove("islogged").remove("email").commit();
        sp.edit().remove("islogged").remove("telefono").commit();

        Intent intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        getActivity().startActivity(intent);

    }


}

