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

import com.carlos.educaapp.Pojo.AlumnosPojo;
import com.carlos.educaapp.R;
import com.carlos.educaapp.models.Alumnos;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class AdapterAlumnos extends RecyclerView.Adapter<AdapterAlumnos.ViewHolderAlumnos> implements View.OnClickListener {
    private List<Alumnos>  listaAlumnos;
    @NonNull
    Dialog myDialog;

    Context context;





    private View.OnClickListener listener;

    public AdapterAlumnos(){
        this.listaAlumnos=new ArrayList<>();
    }

    public void setListaAlumnos(List<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }


    @Override
    public ViewHolderAlumnos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_alumnos,null,false);
        view.setOnClickListener(this);
        final ViewHolderAlumnos vHolder=new ViewHolderAlumnos(view);
        context=view.getContext();
        myDialog=new Dialog(context);
        myDialog.setContentView(R.layout.fragment_detalle_alumnos);

        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {

           public void onClick(View view) {
               TextView seccion=(TextView)myDialog.findViewById(R.id.idSeccionAlumno);
               TextView grado_text=(TextView)myDialog.findViewById(R.id.idGrado);

               seccion.setText(listaAlumnos.get(vHolder.getAdapterPosition()).getSeccion());
               grado_text.setText(listaAlumnos.get(vHolder.getAdapterPosition()).getGrado());
                myDialog.show();

                Toast.makeText(context,"Text Click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlumnos viewHolderAlumnos, int i) {
        viewHolderAlumnos.nombre.setText(listaAlumnos.get(i).getNombre());
        viewHolderAlumnos.apellidosmaternos.setText(listaAlumnos.get(i).getApeMaterno());
        viewHolderAlumnos.apellidospaternos.setText(listaAlumnos.get(i).getApePaterno());

        //viewHolderAlumnos.correo.setText(listaAlumnos.get(i).getCorreo());
        //viewHolderAlumnos.seccion.setText(listaAlumnos.get(i).getSeccion());
        //viewHolderAlumnos.faltas.setText(listaAlumnos.get(i).getFaltas());
    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

        @Override
        public void onClick(View view) {
            if (listener!=null){
                listener.onClick(view);
            }

        }

        public class ViewHolderAlumnos extends RecyclerView.ViewHolder {
        private LinearLayout item_contact;
        TextView nombre,apellidospaternos,apellidosmaternos,faltas,seccion,correo;
        public ViewHolderAlumnos(@NonNull View itemView) {
            super(itemView);
            item_contact=(LinearLayout) itemView.findViewById(R.id.item_concat);
            nombre=itemView.findViewById(R.id.idNombreAlumno);
            apellidospaternos=itemView.findViewById(R.id.idApellidosPaternosAlumno);
            apellidosmaternos=itemView.findViewById(R.id.idApellidosMaternosAlumno);
            //faltas=itemView.findViewById(R.id.FaltaAlumno);
            //seccion=itemView.findViewById(R.id.idSeccionAlumno);
            //correo=itemView.findViewById(R.id.idCoreoAlumno);
        }
    }
}
