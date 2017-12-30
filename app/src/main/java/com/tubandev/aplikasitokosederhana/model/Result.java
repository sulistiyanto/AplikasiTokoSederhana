package com.tubandev.aplikasitokosederhana.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public class Result {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("error_msg")
    @Expose
    private String error_msg;
    @SerializedName("barang")
    @Expose
    private List<Barang> barang = null;

    public Boolean getError() {
        return error;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<Barang> getBarang() {
        return barang;
    }
}
