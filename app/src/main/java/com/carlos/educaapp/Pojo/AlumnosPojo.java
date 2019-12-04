package com.carlos.educaapp.Pojo;

import java.io.Serializable;

public class AlumnosPojo implements Serializable {
   private String nombre;
    private String ApellidosPaternos;
    private String ApellidosMaternos;
    private String faltas;
    private String seccion;
    private String correo;

    public AlumnosPojo(String nombre, String apellidosPaternos, String apellidosMaternos, String faltas, String seccion, String correo) {
        this.nombre = nombre;
        ApellidosPaternos = apellidosPaternos;
        ApellidosMaternos = apellidosMaternos;
        this.faltas = faltas;
        this.seccion = seccion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidosPaternos() {
        return ApellidosPaternos;
    }

    public String getApellidosMaternos() {
        return ApellidosMaternos;
    }

    public String getFaltas() {
        return faltas;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getCorreo() {
        return correo;
    }
}
