package com.devs.muestra.Mapeo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Nexo {

    @SerializedName("hits")
    private List<MProductos> mData;

    public List<MProductos> getmData() {
        return mData;
    }





}
