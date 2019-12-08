package com.carlos.educaapp.models;

import com.orm.dsl.Table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


public class Incidencia {
    private Long id ;
    private String Hora;
    private String Fecha;
    private String Lugar;
    private String Tipo;
    private String Grado;
    private String Seccion;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Descripcion;
    public  Incidencia(){

    }

    public Incidencia(String hora, String fecha, String lugar, String tipo, String grado, String seccion, String nombre, String apellidoPaterno, String apellidoMaterno, String descripcion) {
        Hora = hora;
        Fecha = fecha;
        Lugar = lugar;
        Tipo = tipo;
        Grado = grado;
        Seccion = seccion;
        Nombre = nombre;
        ApellidoPaterno = apellidoPaterno;
        ApellidoMaterno = apellidoMaterno;
        Descripcion = descripcion;
    }

}



