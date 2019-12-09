
package com.carlos.educaapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlumnosInvolucrado {
/*    @SerializedName("id_alumno")
    @Expose
    private Integer idAlumno;*/
    @SerializedName("nombre_alumno")
    @Expose
    private String nombreAlumno;
    @SerializedName("ape_paterno")
    @Expose
    private String apePaterno;
  /*  @SerializedName("ape_materno")
    @Expose
    private String apeMaterno;
*/
    /*public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }*/

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

/*    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }*/

    @Override
    public String toString() {
        return "AlumnosInvolucrado{" +
            "nombreAlumno='" + nombreAlumno + '\'' +
            ", apePaterno='" + apePaterno + '\'' +
            '}';
    }
}
