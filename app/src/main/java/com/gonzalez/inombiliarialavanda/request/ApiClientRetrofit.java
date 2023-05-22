package com.gonzalez.inombiliarialavanda.request;

import com.gonzalez.inombiliarialavanda.modelo.Propietario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public class ApiClientRetrofit {

    private static final String PATH="http://192.168.0.15:5029/API/";
    private static  EndPointInmobiliaria endPointInmobiliaria;

    public static EndPointInmobiliaria getEndpointInmobiliaria(){

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endPointInmobiliaria=retrofit.create(EndPointInmobiliaria.class);

        return endPointInmobiliaria;
    }

    public interface EndPointInmobiliaria{

        @POST("Propietarios/login")
        Call<String> login(@Body Propietario propietario);

        @GET("Propietarios/MiPerfil")
        Call<Propietario> obtenerPerfil(@Header("Authorization") String token);

    }
}
