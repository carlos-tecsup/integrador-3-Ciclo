package com.carlos.educaapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.carlos.educaapp.R;
import com.carlos.educaapp.models.Usuario;
import com.carlos.educaapp.retrofit.ApiError;
import com.carlos.educaapp.retrofit.ResponseLogin;
import com.carlos.educaapp.services.ApiService;
import com.carlos.educaapp.services.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        usernameInput = findViewById(R.id.DniLogin);
        passwordInput = findViewById(R.id.PasswordLogin);
        loginButton = findViewById(R.id.ButtonLogin);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        loadLastUsername();

        verifyLoginStatus();


    }




    private void login() {
        String dni=usernameInput.getText().toString();
        String password=passwordInput.getText().toString();

        if(dni.isEmpty()){
            Toast.makeText(this, "Ingrese dni", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.isEmpty()){
            Toast.makeText(this, "Ingrese el password", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<ResponseLogin> call = service.login(dni, password);
        call.enqueue(new Callback<ResponseLogin>(){


            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful()) {
                    ResponseLogin usuarioResponse = response.body();
                    Log.d(TAG, "usuarioResponse" + usuarioResponse);
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    sp.edit()
                        .putString("dni", usuarioResponse.getUser().getDni())
                        .putString("nombre", usuarioResponse.getUser().getNombre())
                        .putString("apellido", usuarioResponse.getUser().getApellido())
                        .putString("email", usuarioResponse.getUser().getEmail())
                        .putString("telefono", usuarioResponse.getUser().getTelefono())
                        .putString("token", usuarioResponse.getToken())
                        .putBoolean("islogged", true)
                        .commit();
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                    finish();

                    Toast.makeText(MainActivity.this, "Bienvenido " + usuarioResponse.getUser().getNombre(), Toast.LENGTH_LONG).show();

                }else{
                 /*   ApiError error = ApiServiceGenerator.parseError(response);*/
                   /* Toast.makeText(MainActivity.this, "onError:" + error.getMessage(), Toast.LENGTH_LONG).show();*/
                    Toast.makeText(MainActivity.this, "Error en el dni o la contraseña", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure: " + t.toString(), Toast.LENGTH_LONG).show();

            }


        });


    }
    private void loadLastUsername(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        String username = sp.getString("dni", null);
        if(username != null){
            usernameInput.setText(username);
        }
    }
    private void verifyLoginStatus(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean islogged = sp.getBoolean("islogged", false);

        if(islogged){
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }

    }

}

    


