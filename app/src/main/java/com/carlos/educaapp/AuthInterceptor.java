package com.carlos.educaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.carlos.educaapp.Activities.MainActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public abstract class AuthInterceptor extends Context implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String token = sp.getString("token", null);
        Request request=chain.request().newBuilder().addHeader("Authorization","Bearer"+token).build();
        return chain.proceed(request);







    }
}
