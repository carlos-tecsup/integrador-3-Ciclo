package com.carlos.educaapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlos.educaapp.R;
import com.carlos.educaapp.Pojo.ReportesPojo;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;

import java.util.ArrayList;
import java.util.List;

public class AdapterReportes  extends RecyclerView.Adapter<AdapterReportes.ViewHolderReportes> implements View.OnClickListener {


    private List<Incidencias> listaincidencias;
    private View.OnClickListener listener;
    public AdapterReportes() {
        this.listaincidencias =new ArrayList<>();
    }

    public void setListaincidencias(List<Incidencias> listaincidencias) {
        this.listaincidencias = listaincidencias;
    }


    @Override
    public ViewHolderReportes onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);

        view.setOnClickListener(this);
        return new ViewHolderReportes(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderReportes holder, int position) {
        Incidencias incidencias = this.listaincidencias.get(position);
         holder.Codigo.setText(String.valueOf(listaincidencias.get(position).getId()));
        holder.hora.setText(listaincidencias.get(position).getFechaCreacion());



    }

    @Override
    public int getItemCount() {
        return listaincidencias.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolderReportes extends RecyclerView.ViewHolder {
        private  TextView Codigo,fecha,hora,lugar,tipo,Seccion,Nombre,ApellidoPaterno,ApellidoMaterno,Descripcion;
        public ViewHolderReportes(@NonNull View itemView) {
            super(itemView);
            hora=itemView.findViewById(R.id.idHoraIncidencia);
            Codigo=itemView.findViewById(R.id.idReporte);


        }


    }
}
