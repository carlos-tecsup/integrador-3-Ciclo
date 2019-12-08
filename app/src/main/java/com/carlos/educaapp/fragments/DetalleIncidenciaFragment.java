package com.carlos.educaapp.fragments;
import android.support.v7.widget.Toolbar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.carlos.educaapp.Activities.DashboardActivity;
import com.carlos.educaapp.Pojo.ReportesPojo;
import com.carlos.educaapp.R;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetalleIncidenciaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetalleIncidenciaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleIncidenciaFragment extends Fragment {
   Toolbar toolbar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    TextView textNombre;
    TextView textApellidoPaterno;
    TextView textApellidoMaterno;
    TextView textTipo;
    TextView textLugar;
    TextView textGrado;
    TextView textDescripcion;
    TextView textSeccion;
    TextView textHora;
    TextView textFecha;

    public DetalleIncidenciaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleIncidenciaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleIncidenciaFragment newInstance(String param1, String param2) {
        DetalleIncidenciaFragment fragment = new DetalleIncidenciaFragment();
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



        View vista =inflater.inflate(R.layout.fragment_detalle_incidencia, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setTitle("DETALLE DE INCIDENCIA");

       textNombre=(TextView)vista.findViewById(R.id.idNombre);
        textApellidoPaterno=(TextView)vista.findViewById(R.id.idApellidosPaternos);
        textSeccion=(TextView)vista.findViewById(R.id.idSeccion);
        textHora=(TextView)vista.findViewById(R.id.idHora);
        textFecha=(TextView)vista.findViewById(R.id.idFecha) ;
        textApellidoMaterno=(TextView)vista.findViewById(R.id.idApellidosMaternos);
        textGrado=(TextView)vista.findViewById(R.id.idGrado);
        textTipo=(TextView)vista.findViewById(R.id.idTipo);
        textLugar=(TextView)vista.findViewById(R.id.idLugar);
        textDescripcion=(TextView)vista.findViewById(R.id.DescripcionIncidencia) ;


        Bundle objetoincidencia=getArguments();
        Incidencias incidencias=null;
        if (objetoincidencia!=null){
            incidencias=(Incidencias) objetoincidencia.getSerializable("objeto");
            textNombre.setText(incidencias.getObservacion());
            textApellidoMaterno.setText(incidencias.getLugar());
            textApellidoPaterno.setText(incidencias.getFalta());
            textDescripcion.setText(incidencias.getGrado());

        }
        return vista;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
