package com.carlos.educaapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.carlos.educaapp.Activities.MainActivity;

import java.util.Calendar;

public class HeaderDialogFragment extends DialogFragment implements View.OnClickListener {
    Button bfecha,bhora;
    EditText efecha,ehora;
    private  int dia,mes,ano,hora,minutos ;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.nuevaincidencia,container,false);

         bfecha = (Button) view.findViewById(R.id.buttonfecha);
        bhora = (Button) view.findViewById(R.id.buttonhora);
        efecha = (EditText) view.findViewById(R.id.editTextFecha);
        ehora=(EditText) view.findViewById(R.id.editTextHora);
        bfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog=super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }


    @Override
    public void onClick(View v) {

    }

}
