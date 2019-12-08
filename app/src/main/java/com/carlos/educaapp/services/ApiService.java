package com.carlos.educaapp.services;

import com.carlos.educaapp.models.Alumnos;
import com.carlos.educaapp.models.AlumnosAtributos;
import com.carlos.educaapp.models.Incidencia;
import com.carlos.educaapp.models.Incidencias;
import com.carlos.educaapp.models.Lugar;
import com.carlos.educaapp.models.TipoIncidencia;
import com.carlos.educaapp.models.Usuario;
import com.carlos.educaapp.retrofit.ResponseLogin;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    String API_BASE_URL = "http://192.168.1.61:8000";
    //http://192.168.1.61:8000

    @FormUrlEncoded
    @POST("/api/login")
    Call<ResponseLogin> login(@Field("dni") String username,
                              @Field("password") String password);

    @GET("/api/v1/user/alumnos")

    Call<List<Alumnos>> findAll();


    @GET("/api/v1/user/reportes")
    Call<List<Incidencias>> getIncidencias();

    @GET("/api/v1/faltas")
    Call<List<TipoIncidencia>> getTipoIncidencia();
    @GET("/api/v1/lugares")
    Call<List<Lugar>> getLugar();



}
