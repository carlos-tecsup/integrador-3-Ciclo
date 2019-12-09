package com.carlos.educaapp.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.carlos.educaapp.R;
import com.carlos.educaapp.Pojo.ReportesPojo;
import com.carlos.educaapp.models.AlumnosInvolucrado;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;
import com.carlos.educaapp.models.Lugar;
import com.carlos.educaapp.models.TipoIncidencia;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.NameList;

import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.carlos.educaapp.services.ApiService.API_BASE_URL;

public class AdapterReportes  extends RecyclerView.Adapter<AdapterReportes.ViewHolderReportes> implements View.OnClickListener {
    Dialog myDialog;

    Context context;


    private List<Incidencias> listaincidencias;

    private View.OnClickListener listener;
    private ListView listviewa;

    public AdapterReportes() {
        this.listaincidencias =new ArrayList<>();

    }


    public void setListaincidencias(List<Incidencias> listaincidencias) {
        this.listaincidencias = listaincidencias;
    }


    @Override
    public ViewHolderReportes onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);

        view.setOnClickListener(this);
        final ViewHolderReportes vHolder=new ViewHolderReportes(view);
        context=view.getContext();
        myDialog=new Dialog(context);
        myDialog.setContentView(R.layout.fragment_detalle_incidencia);
        vHolder.item_reportes.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    List<String> list2=new ArrayList<String>();
                    String[] alumnos= null;
                    for (Incidencias r: listaincidencias) {

                        list2.add(r.getAlumnosInvolucrados().toString().replaceAll("AlumnosInvolucrado", "").replaceAll("nombreAlumno","").replaceAll("\\=","")
                            .replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\}","").replaceAll("\\{","").replaceAll("\\'",""));


                    }




                    TextView textAlumnos=(TextView)myDialog.findViewById(R.id.idNombreAlumnoReporte);
                    textAlumnos.setText(list2.get(vHolder.getAdapterPosition()).toString());
                    TextView textSeccion=(TextView)myDialog.findViewById(R.id.idSeccionReporte);
                TextView textHora=(TextView)myDialog.findViewById(R.id.idFechaReporte);
                TextView textGrado=(TextView)myDialog.findViewById(R.id.idGradoReporte);
                TextView textTipo=(TextView)myDialog.findViewById(R.id.idTipoReporte);
                TextView textLugar=(TextView)myDialog.findViewById(R.id.idLugarReporte);
                TextView textDescripcion=(TextView)myDialog.findViewById(R.id.DescripcionIncidencia) ;

                textTipo.setText(listaincidencias.get(vHolder.getAdapterPosition()).getFalta());
                textSeccion.setText(listaincidencias.get(vHolder.getAdapterPosition()).getSeccion());
                textGrado.setText(listaincidencias.get(vHolder.getAdapterPosition()).getGrado());
                textHora.setText(listaincidencias.get(vHolder.getAdapterPosition()).getFechaCreacion());

                textLugar.setText(listaincidencias.get(vHolder.getAdapterPosition()).getLugar());
                textDescripcion.setText(listaincidencias.get(vHolder.getAdapterPosition()).getObservacion());
                myDialog.show();
                Window window = myDialog.getWindow();
                window.setLayout(Toolbar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

                Toast.makeText(context,"Text Click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });
                 return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderReportes holder, int i) {
        holder.Codigo.setText(String.valueOf(listaincidencias.get(i).getSeccion()));

        holder.hora.setText(listaincidencias.get(i).getFechaCreacion());
        holder.Grado.setText(listaincidencias.get(i).getGrado());



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
        private LinearLayout item_reportes;

        TextView Codigo,hora,Grado;
        public ViewHolderReportes(@NonNull View itemView) {

            super(itemView);
            item_reportes=(LinearLayout) itemView.findViewById(R.id.VistaReporte);
            hora=itemView.findViewById(R.id.idHoraIncidencia);
            Codigo=itemView.findViewById(R.id.idReporte);
            Grado=itemView.findViewById(R.id.idGradoIncidencia);



        }


    }
}
