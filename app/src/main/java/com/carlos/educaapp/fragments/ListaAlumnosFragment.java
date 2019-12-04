package com.carlos.educaapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carlos.educaapp.Activities.MainActivity;
import com.carlos.educaapp.Adapter.AdapterAlumnos;
import com.carlos.educaapp.AuthInterceptor;
import com.carlos.educaapp.Pojo.AlumnosPojo;
import com.carlos.educaapp.R;
import com.carlos.educaapp.interfaces.IComunicaFragmentsAlumnos;
import com.carlos.educaapp.models.Alumnos;
import com.carlos.educaapp.services.ApiService;
import com.carlos.educaapp.services.ApiServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaAlumnosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaAlumnosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaAlumnosFragment extends Fragment {
    private static final String TAG=ListaAlumnosFragment.class.getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerAlumno;

    Activity activity;
    IComunicaFragmentsAlumnos interfaceComunicaFragmentsAlumnos;


    public ListaAlumnosFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaAlumnosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaAlumnosFragment newInstance(String param1, String param2) {
        ListaAlumnosFragment fragment = new ListaAlumnosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        //initialize();

    }

  /*  private void initialize() {
        ApiService service= ApiServiceGenerator.createService(ApiService.class);
        service.findAll().enqueue(new Callback<List<AlumnosFragmento>>() {
            @Override
            public void onResponse(Call<List<AlumnosFragmento>> call, Response<List<AlumnosFragmento>> response) {
                if (response.isSuccessful()){
                    List<AlumnosFragmento> alumnos=response.body();
                    Log.d(TAG,"alumnos :"+alumnos);
                }
                else {

                    Toast.makeText(getContext(), "Error: "+response,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<AlumnosFragmento>> call, Throwable t) {
                Toast.makeText(getContext(), "Error crítico: "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_lista_alumnos, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setTitle("LISTA DE ALUMNOS");


        recyclerAlumno= (RecyclerView)vista.findViewById(R.id.RecyclerAlumnos);
        recyclerAlumno.setLayoutManager(new LinearLayoutManager(getContext()));
        //llenarLista();

        AdapterAlumnos adapter=new AdapterAlumnos();
        recyclerAlumno.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* interfaceComunicaFragmentsAlumnos.enviarAlumnos(listaAlumnos.get(recyclerAlumno.getChildAdapterPosition(view)));*/
             }
        });
        testRest();
       //initialize();
        return vista;
    }

    private void testRest() {


       SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
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
        ApiService service = retrofit.create(ApiService.class);

        Call<List<Alumnos>> call=service.findAll();
        call.enqueue(new Callback<List<Alumnos>>() {
            @Override
            public void onResponse(Call<List<Alumnos>> call, Response<List<Alumnos>> response) {
                if(response.isSuccessful()){
                    List<Alumnos> alumnos=response.body();
                    Log.d("Activity","alumnos"+alumnos);
                    AdapterAlumnos adapter=(AdapterAlumnos)recyclerAlumno.getAdapter();
                    adapter.setListaAlumnos(alumnos);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getContext(), "Error: " + response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Alumnos>> call, Throwable t) {
                Toast.makeText(getContext(), "Error crítico: "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void initialize() {



         ApiService service = ApiServiceGenerator.createService(getContext(),ApiService.class);


        service.findAll().enqueue(new Callback<List<Alumnos>>(){
            @Override
            public void onResponse(@NonNull Call<List<Alumnos>> call,@NonNull Response<List<Alumnos> >response) {
                try {
                    if (response.isSuccessful()) {
                        List<Alumnos> alumnos = response.body();
                        Log.d(TAG, "alumnos :" + alumnos);
                    } else {
                        Toast.makeText(getContext(), "Error: " + response, Toast.LENGTH_SHORT).show();
                    }

                } catch (Throwable t) {
                    Log.e(TAG, "onThrowable: " + t.getMessage(), t);
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Alumnos>> call, Throwable t) {
                Toast.makeText(getContext(), "Error crítico: "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }


                });}



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            this.activity=(Activity)context;
            interfaceComunicaFragmentsAlumnos= (IComunicaFragmentsAlumnos) this.activity;
            
        }
        if (context instanceof OnFragmentInteractionListener){
            mListener=(OnFragmentInteractionListener)context;
        }
        else {
            throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }*/
/*
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
