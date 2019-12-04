package com.carlos.educaapp.Pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class    ReportesPojo implements Serializable {


        private int Id;
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

    public ReportesPojo(int id, String hora, String fecha, String lugar, String tipo, String grado, String seccion, String nombre, String apellidoPaterno, String apellidoMaterno, String descripcion) {
        Id = id;
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

    public int getId() {
        return Id;
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

    public String getDescripcion() {
        return Descripcion;
    }


    }


