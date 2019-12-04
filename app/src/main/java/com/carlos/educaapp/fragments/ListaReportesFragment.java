package com.carlos.educaapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carlos.educaapp.Activities.NuevaIncidencia;
import com.carlos.educaapp.Adapter.AdapterReportes;
import com.carlos.educaapp.HeaderDialogFragment;
import com.carlos.educaapp.interfaces.IComunicaFragments;
import com.carlos.educaapp.R;
import com.carlos.educaapp.Pojo.ReportesPojo;

import java.util.ArrayList;

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

    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerReportes;
    ArrayList<ReportesPojo> listaIncidencias;
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

        listaIncidencias=new ArrayList<>();
        recyclerReportes=(RecyclerView)vista.findViewById(R.id.RecyclerId);
        recyclerReportes.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        AdapterReportes adapter=new AdapterReportes(listaIncidencias);
        recyclerReportes.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                interfaceComunicaFragments.enviarIncidencia(listaIncidencias.get(recyclerReportes.getChildAdapterPosition(view)));
            }
        });

        return vista;
    }

    private void llenarLista() {
        listaIncidencias.add(new ReportesPojo(6,"06:23","12-02-13","Salon1","Agresion Fisica","4","C","Carlos","Huaynates","Soto","El alumnso repite el mismo comportamiento"));
        listaIncidencias.add(new ReportesPojo(5,"06:23","12-02-13","Salon1","Agresion Fisica","4","C","Jose","Huaynates","Soto","El alumnso repite el mismo comportamiento"));
        listaIncidencias.add(new ReportesPojo(4,"06:23","12-02-13","Salon1","Agresion Fisica","4","C","Juan","Huaynates","Soto","El alumnso repite el mismo comportamiento"));
        listaIncidencias.add(new ReportesPojo(3,"06:23","12-02-13","Salon1","Agresion Fisica","4","C","Andres","Huaynates","Soto","El alumnso repite el mismo comportamiento"));
        listaIncidencias.add(new ReportesPojo(2,"06:23","12-02-13","Salon1","Agresion Fisica","4","C","Dante","Huaynates","Soto","El alumnso repite el mismo comportamiento"));
        listaIncidencias.add(new ReportesPojo(1,"06:23","12-02-13","Salon1","Agresion Fisica","4","C","Carlos","Huaynates","Soto","El alumnso repite el mismo comportamiento"));
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.activity= (Activity) context;
            interfaceComunicaFragments=(IComunicaFragments)this.activity;
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
    }

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



