package com.carlos.educaapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seccion {
    @SerializedName("grado")
    @Expose
    private String grado;
    @SerializedName("seccion")
    @Expose
    private String seccion;

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

    @Override
    public String toString() {
        return "Seccion{" +
            "grado='" + grado + '\'' +
            ", seccion='" + seccion + '\'' +
            '}';
    }
}
