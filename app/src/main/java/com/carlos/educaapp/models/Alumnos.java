package com.carlos.educaapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class Alumnos {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("ape_paterno")
    @Expose
    private String apePaterno;
    @SerializedName("ape_materno")
    @Expose
    private String apeMaterno;
    @SerializedName("email_padre")
    @Expose
    private String emailPadre;
    @SerializedName("grado")
    @Expose
    private String grado;
    @SerializedName("seccion")
    @Expose
    private String seccion;
    @SerializedName("cantidad_incidencias")
    @Expose
    private Integer cantidadIncidencias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getEmailPadre() {
        return emailPadre;
    }

    public void setEmailPadre(String emailPadre) {
        this.emailPadre = emailPadre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Integer getCantidadIncidencias() {
        return cantidadIncidencias;
    }

    public void setCantidadIncidencias(Integer cantidadIncidencias) {
        this.cantidadIncidencias = cantidadIncidencias;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", apePaterno='" + apePaterno + '\'' +
            ", apeMaterno='" + apeMaterno + '\'' +
            ", emailPadre='" + emailPadre + '\'' +
            ", grado='" + grado + '\'' +
            ", seccion='" + seccion + '\'' +
            ", cantidadIncidencias=" + cantidadIncidencias +
            '}';
    }
}
