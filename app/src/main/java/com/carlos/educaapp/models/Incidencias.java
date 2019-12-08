
package com.carlos.educaapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Incidencias {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fecha_creacion")
    @Expose
    private String fechaCreacion;
    @SerializedName("observacion")
    @Expose
    private String observacion;
    @SerializedName("profesor_nombre")
    @Expose
    private String profesorNombre;
    @SerializedName("profesor_apellido")
    @Expose
    private String profesorApellido;
    @SerializedName("falta")
    @Expose
    private String falta;
    @SerializedName("lugar")
    @Expose
    private String lugar;
    @SerializedName("grado")
    @Expose
    private String grado;
    @SerializedName("seccion")
    @Expose
    private String seccion;
    @SerializedName("alumnos_involucrados")
    @Expose
    private List<AlumnosInvolucrado> alumnosInvolucrados;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public String getProfesorApellido() {
        return profesorApellido;
    }

    public void setProfesorApellido(String profesorApellido) {
        this.profesorApellido = profesorApellido;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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

    public List<AlumnosInvolucrado> getAlumnosInvolucrados() {
        return alumnosInvolucrados;
    }

    public void setAlumnosInvolucrados(List<AlumnosInvolucrado> alumnosInvolucrados) {
        this.alumnosInvolucrados = alumnosInvolucrados;
    }
}



