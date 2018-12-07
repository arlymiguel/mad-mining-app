package com.upc.mina.dam_minaapp;

import com.upc.mina.dam_minaapp.model.Conductores;
import com.upc.mina.dam_minaapp.model.ListaVehiculos;
import com.upc.mina.dam_minaapp.model.Vehiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServicesImp {

    @FormUrlEncoded
    @POST("user-management/v1/authenticate")
    Call<String> login(@Field("username") String username,@Field("password") String password);

    @GET("vehicle")
    Call<ListaVehiculos> listvehiculos();

    @GET("vehicle-management/v1/vehicle")
    Call<List<Vehiculo>> vehiculos();

    @GET("driver-management/v1/driver")
    Call<List<Conductores>> conductores();

}
