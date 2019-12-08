package com.carlos.educaapp.models;

import java.util.List;

public abstract class a {

    private List<Alumnos_involucrados> alumnos_involucrados;
    private String seccion;
    private String grado;
    private String lugar;
    private String falta;
    private String profesor_apellido;
    private String profesor_nombre;
    private String observacion;
    private String fecha_creacion;
    private int id;

    public List<Alumnos_involucrados> getAlumnos_involucrados() {
        return alumnos_involucrados;
    }

    public void setAlumnos_involucrados(List<Alumnos_involucrados> alumnos_involucrados) {
        this.alumnos_involucrados = alumnos_involucrados;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    public String getProfesor_apellido() {
        return profesor_apellido;
    }

    public void setProfesor_apellido(String profesor_apellido) {
        this.profesor_apellido = profesor_apellido;
    }

    public String getProfesor_nombre() {
        return profesor_nombre;
    }

    public void setProfesor_nombre(String profesor_nombre) {
        this.profesor_nombre = profesor_nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Alumnos_involucrados {
        private String ape_materno;
        private String ape_paterno;
        private String nombre_alumno;
        private int id_alumno;

        public String getApe_materno() {
            return ape_materno;
        }

        public void setApe_materno(String ape_materno) {
            this.ape_materno = ape_materno;
        }

        public String getApe_paterno() {
            return ape_paterno;
        }

        public void setApe_paterno(String ape_paterno) {
            this.ape_paterno = ape_paterno;
        }

        public String getNombre_alumno() {
            return nombre_alumno;
        }

        public void setNombre_alumno(String nombre_alumno) {
            this.nombre_alumno = nombre_alumno;
        }

        public int getId_alumno() {
            return id_alumno;
        }

        public void setId_alumno(int id_alumno) {
            this.id_alumno = id_alumno;
        }
    }
}
