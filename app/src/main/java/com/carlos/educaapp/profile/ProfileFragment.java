package com.carlos.educaapp.profile;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.carlos.educaapp.R;


public class ProfileFragment extends Fragment {


    TextView nombre,curso,apellido;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.profile_fragment, container, false);
      /*  curso=v.findViewById(R.id.editText2);
        apellido=v.findViewById(R.id.editText1);
        nombre=v.findViewById(R.id.editText1);*/

        return v;
    }



}
