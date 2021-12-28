package com.devs.muestra.Interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitIntenace {
    public static final String BASE_URL = "https://hn.algolia.com/";
    static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
