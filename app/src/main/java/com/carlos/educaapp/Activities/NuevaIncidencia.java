package com.carlos.educaapp.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.carlos.educaapp.R;
import com.carlos.educaapp.models.Incidencia;
import com.orm.query.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class NuevaIncidencia  extends AppCompatActivity implements View.OnClickListener {
    Button bfecha,bhora;
    EditText efecha,ehora,elugar,descripcion;
    int dia,mes,ano,hora,minutos ;
    Spinner spinnerlugar;
    Button mBtn;
    TextView mTextV;
    private Toolbar toolbar;
    Button btnLogin;

/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuopciones,menu);
        return super.onCreateOptionsMenu(menu);
    }
*/





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_incidencia);
        getSupportActionBar().setTitle("NUEVA INCIDENCIA");
        btnLogin=(Button)findViewById(R.id.button2);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente=new Intent(NuevaIncidencia.this,DashboardActivity.class);
                startActivity(siguiente);


            }
        });







        spinnerlugar=(Spinner)findViewById(R.id.SpinnerLugar);
        ArrayList<String> incidencias=new ArrayList<String>();
        incidencias.add("Acoso");
        incidencias.add("Robo");
        incidencias.add("Agresión");
        incidencias.add("Falta de Respeto");


        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,R.layout.spinner_item,incidencias );
        spinnerlugar.setAdapter(adapter);
        spinnerlugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
