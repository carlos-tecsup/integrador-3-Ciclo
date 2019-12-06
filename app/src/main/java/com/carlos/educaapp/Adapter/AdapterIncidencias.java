package com.carlos.educaapp.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.carlos.educaapp.R;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class AdapterIncidencias extends RecyclerView.Adapter<AdapterIncidencias.ViewHolder> implements View.OnClickListener{
    @NonNull
    private List<Incidencias> incidencias;
    private View.OnClickListener listener;
    /*  return new ViewHolder(view);

     */
 /*   Dialog myDialog = new Dialog(this);*/

    public void setIncidencias(@NonNull List<Incidencias> incidencias) {
        this.incidencias = incidencias;
    }
    public AdapterIncidencias(){
        this.incidencias=new  ArrayList<>();

    }


    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Incidencias incidencia=this.incidencias.get(position);
       /* viewHolder.Codigo.setText(String.valueOf(incidencia.getId()));
        viewHolder.fecha.setText(incidencia.getFecaCreacion());
        viewHolder.hora.setText(incidencia.getHora());*/





    }

    @Override
    public int getItemCount() {
        return this.incidencias.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private  TextView Codigo,fecha,hora,lugar,tipo,Seccion,Nombre,ApellidoPaterno,ApellidoMaterno,Descripcion;

        private LinearLayout item_incidencia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_incidencia=(LinearLayout) itemView.findViewById(R.id.VistaReporte);
            hora=itemView.findViewById(R.id.idHoraIncidencia);
            Codigo=itemView.findViewById(R.id.idReporte);
            fecha=itemView.findViewById(R.id.idFechaIncidencia);
        }

    }
}
