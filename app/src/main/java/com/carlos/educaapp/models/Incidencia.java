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

    public String getDescripcion() {
        return Descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getHora() {
        return Hora;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getLugar() {
        return Lugar;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getGrado() {
        return Grado;
    }

    public String getSeccion() {
        return Seccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
            "id=" + id +
            ", Hora='" + Hora + '\'' +
            ", Fecha='" + Fecha + '\'' +
            ", Lugar='" + Lugar + '\'' +
            ", Tipo='" + Tipo + '\'' +
            ", Grado='" + Grado + '\'' +
            ", Seccion='" + Seccion + '\'' +
            ", Nombre='" + Nombre + '\'' +
            ", ApellidoPaterno='" + ApellidoPaterno + '\'' +
            ", ApellidoMaterno='" + ApellidoMaterno + '\'' +
            ", Descripcion='" + Descripcion + '\'' +
            '}';
    }
}



