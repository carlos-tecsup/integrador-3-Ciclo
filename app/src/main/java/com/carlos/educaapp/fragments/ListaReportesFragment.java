package com.carlos.educaapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carlos.educaapp.Activities.NuevaIncidencia;
import com.carlos.educaapp.Adapter.AdapterAlumnos;
import com.carlos.educaapp.Adapter.AdapterReportes;
import com.carlos.educaapp.HeaderDialogFragment;
import com.carlos.educaapp.interfaces.IComunicaFragments;
import com.carlos.educaapp.R;
import com.carlos.educaapp.Pojo.ReportesPojo;
import com.carlos.educaapp.models.Alumnos;
import com.carlos.educaapp.models.AlumnosInvolucrado;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;
import com.carlos.educaapp.services.ApiService;

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

 * to handle interaction events.
 * Use the {@link ListaReportesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaReportesFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Incidencias> listaincidencias;
    private OnFragmentInteractionListener mListener;


    RecyclerView recyclerReportes;
    Activity activity;
    IComunicaFragments interfaceComunicaFragments;





    public ListaReportesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaReportesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaReportesFragment newInstance(String param1, String param2) {
        ListaReportesFragment fragment = new ListaReportesFragment();
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




    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_lista_reportes, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setTitle("LISTA DE INCIDENCIAS");
        final FloatingActionButton fab = (FloatingActionButton) vista.findViewById(R.id.añadir);
        fab.setOnClickListener(this);


        recyclerReportes=(RecyclerView)vista.findViewById(R.id.RecyclerId);
        recyclerReportes.setLayoutManager(new LinearLayoutManager(getContext()));

        AdapterReportes adapter=new AdapterReportes();
        recyclerReportes.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* interfaceComunicaFragments.enviarIncidencia(listaincidencias.get(recyclerReportes.getChildAdapterPosition(view)));*/
            }
        });
        testRest();
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
        Call<List<Incidencias>> call=service.getIncidencias();
        call.enqueue(new Callback<List<Incidencias>>() {
            @Override
            public void onResponse(Call<List<Incidencias>> call, Response<List<Incidencias>> response) {
                if(response.isSuccessful()){
                    List<Incidencias> incidencias=response.body();
                    Log.d("Activity","alumnos"+incidencias);
                    AdapterReportes adapter=(AdapterReportes) recyclerReportes.getAdapter();

                    adapter.setListaincidencias(incidencias);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getContext(), "Error: " + response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Incidencias>> call, Throwable t) {
                Toast.makeText(getContext(), "Error crítico: "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
          *//*  this.activity= (Activity) context;
            interfaceComunicaFragments=(IComunicaFragments)this.activity;*//*
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    @Override
    public void onClick(View view) {
     /*   switch (view.getId()){
            case R.id.añadir:
                showCreateHeaderDialog();
                break;
            }*/
        Intent intent = new Intent(getActivity(), NuevaIncidencia.class);
        startActivity(intent);
        }

    private void showCreateHeaderDialog(){
        FragmentManager fragmentManager = getFragmentManager();
        HeaderDialogFragment newFragment = new HeaderDialogFragment();


            // The device is smaller, so show the fragment fullscreen
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            // For a little polish, specify a transition animation
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            // To make it fullscreen, use the 'content' root view as the container
            // for the fragment, which is always the root view for the activity
            transaction.add(android.R.id.content, newFragment)
                .addToBackStack(null).commit();
        }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */



