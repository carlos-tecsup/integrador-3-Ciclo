package com.carlos.educaapp.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.carlos.educaapp.Adapter.AdapterAlumnos;
import com.carlos.educaapp.R;
import com.carlos.educaapp.models.Alumnos;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;
import com.carlos.educaapp.models.Lugar;
import com.carlos.educaapp.models.TipoIncidencia;
import com.carlos.educaapp.services.ApiService;
import com.google.gson.Gson;
import com.orm.query.Select;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.carlos.educaapp.services.ApiService.API_BASE_URL;

public class NuevaIncidencia  extends AppCompatActivity implements View.OnClickListener {
    Button bfecha,bhora;
    EditText efecha,ehora,elugar,descripcion;
    int dia,mes,ano,hora,minutos ;
    Spinner spinnerlugar;
    Button mBtn;
    TextView mTextV;
    private Toolbar toolbar;
    Button btnLogin;
    Spinner spinnerLugar;
    Spinner spinnerTipo;
    Spinner spinnerGrado;
    Spinner spinnerSección;





/*


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }

*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_incidencia);
        getSupportActionBar().setTitle("NUEVA INCIDENCIA");
    /*    Toolbar toolbar=findViewById(R.id.toolbarnuevaincidencia);
        setSupportActionBar(toolbar);*/

        btnLogin=(Button)findViewById(R.id.button2);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente=new Intent(NuevaIncidencia.this,DashboardActivity.class);
                startActivity(siguiente);


            }

        });
        spinnerlugar=(Spinner)findViewById(R.id.SpinnerLugar);
        ArrayList<String> incidenciaslugar=new ArrayList<String>();

        incidenciaslugar.add("Acoso");
        incidenciaslugar.add("Robo");
        incidenciaslugar.add("Agresión");
        incidenciaslugar.add("Falta de Respeto");
        ArrayAdapter<CharSequence> adapterlugar=new ArrayAdapter(this,R.layout.spinner_item,incidenciaslugar );
        spinnerlugar.setAdapter(adapterlugar);
        spinnerlugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /* if ()*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerlugar=(Spinner)findViewById(R.id.SpinnerSeccion);


        obtenerDatosTipo();
        obtenerDatosLugar();
        spinnerlugar=(Spinner)findViewById(R.id.SpinnerGrado);


        spinnerTipo=(Spinner)findViewById(R.id.SpinnerTipo);
        ArrayList<String> incidencias=new ArrayList<String>();
        incidencias.add("Acoso");
        incidencias.add("Robo");



        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,R.layout.spinner_item,incidencias );
        spinnerTipo.setAdapter(adapter);
        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        descripcion=(EditText)findViewById(R.id.DescripcionIncidencia);

        bfecha=(Button) findViewById(R.id.buttonhora);
        bhora=(Button) findViewById(R.id.buttonfecha);
        efecha=(EditText) findViewById(R.id.editTextFecha);
        ehora=(EditText)findViewById(R.id.editTextHora);
        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
        mBtn = (Button) findViewById(R.id.btnAlumnosInvolucrados);
        mTextV = (TextView) findViewById(R.id.textAlumnosInvolucrados);
        /*List<Incidencia> incidencias;*/
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(NuevaIncidencia.this);
              /*  List<Incidencia> colorsArray=new ArrayList<Incidencia>();*/
                String[] colorsArray = new String[]{
                    "Luis Choy Vega",
                    "Juan",
                    "Jose",
                    "Antonio",
                    "Mauricio",
                    "Genaro",
                    "Carlos",
                    "Juan",
                    "Jose",
                    "Antonio",
                    "Mauricio",
                    "Genaro",
                    "Carlos",
                    "Juan",
                    "Jose",
                    "Antonio",
                    "Mauricio",
                    "Genaro",

                };
                final boolean[] checkedColorsArray = new boolean[colorsArray.length];

                final List<String> colorsList = Arrays.asList(colorsArray);
                builder.setTitle(" Seleccionar Alumnos");
                builder.setIcon(R.drawable.ico);
                builder.setMultiChoiceItems(colorsArray, checkedColorsArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                            checkedColorsArray[which]=isChecked;
                            String currentItem=colorsList.get(which);


                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTextV.setText("\n");
                        for (int i=0;i<checkedColorsArray.length;i++){
                            boolean checked=checkedColorsArray[i];
                            if(checked){
                                mTextV.setText(mTextV.getText()+colorsList.get(i)+"\n");
                            }
                        }
                    }
                });
                builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });




     /*   List<Incidencia> incidencias;
        finish();
*/
      /*  incidencias=Select.from(Incidencia.class)
            .where("id")
            .orderBy("ID desc")
            .list();*/
    /*    spinnerlugar.setAdapter(new ArrayAdapter<String>(this,R.layout.));*/



    }

    private void obtenerDatosLugar() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        final String token = sp.getString("token", "usuario");
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        final ApiService service = retrofit.create(ApiService.class);
        Call<List<Lugar>> call=service.getLugar();
        call.enqueue(new Callback<List<Lugar>>() {
            @Override
            public void onResponse(Call<List<Lugar>> call, Response<List<Lugar>> response) {
                if (response.isSuccessful()){

                    List<Lugar> lugar=response.body();
                    Log.d("Activity","lugar"+lugar);
                    if(response.isSuccessful()){
                        poblarSpinnerLugar(lugar);







                    }
                    else {
                        Toast.makeText(getApplicationContext(),"ads,", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Lugar>> call, Throwable t) {

            }
        });


    }

    private void poblarSpinnerLugar(List<Lugar> lugar) {
        List<String> list=new ArrayList<String>();
        for (Lugar r: lugar){
            list.add(r.getDescripcion());

        }

        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,R.layout.spinner_item,list );
        spinnerTipo.setAdapter(adapter);

    }

    private void obtenerDatosTipo() {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            final String token = sp.getString("token", "usuario");
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                    return chain.proceed(newRequest);
                }
            }).build();
            Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            final ApiService service = retrofit.create(ApiService.class);

            Call<List<TipoIncidencia>> call=service.getTipoIncidencia();
            call.enqueue(new Callback<List<TipoIncidencia>>() {
                @Override
                public void onResponse(Call<List<TipoIncidencia>> call, Response<List<TipoIncidencia>> response) {
                    if (response.isSuccessful()){

                        List<TipoIncidencia> tipo=response.body();
                        Log.d("Activity","tipo"+tipo);
                            if(response.isSuccessful()){
                                poblarSpinnerTipo(tipo);







                            }
                            else {
                                Toast.makeText(getApplicationContext(),"ads,", Toast.LENGTH_LONG).show();
                            }
                    }
                    else {

                    }

                }

                @Override
                public void onFailure(Call<List<TipoIncidencia>> call, Throwable t) {
                    Toast.makeText(NuevaIncidencia.this, t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
    }

    private void poblarSpinnerTipo(List<TipoIncidencia> tipo) {
        List<String> list=new ArrayList<String>();
        for (TipoIncidencia r: tipo){
            list.add(r.getNombre());

        }

        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,R.layout.spinner_item,list );
        spinnerTipo.setAdapter(adapter);

    }

  /*  private void poblarSpinnerTipo(TipoIncidencia incidencia) {
        List<TipoIncidencia> tipo= new ArrayList<>();

        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,R.layout.spinner_item,tipo );
        spinnerTipo.setAdapter(adapter);
    }*/

    @Override
    public void onClick(View v) {

        if (v==bfecha){
            final Calendar c=Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    efecha.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }
                ,ano,mes,dia);
            datePickerDialog.show();



        }
        if (v==bhora){
            final Calendar c=Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

           TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    ehora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
                timePickerDialog.show();
        }
    }
}
