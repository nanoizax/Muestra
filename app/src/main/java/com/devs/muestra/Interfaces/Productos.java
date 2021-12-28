package com.devs.muestra.Interfaces;

import com.devs.muestra.Mapeo.Nexo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Productos {

    @GET("api/v1/search_by_date?query=mobile/")
    Call<Nexo> getProductos();

}
