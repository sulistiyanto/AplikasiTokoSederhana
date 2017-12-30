package com.tubandev.aplikasitokosederhana.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public class Barang {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("stok")
    @Expose
    private String stok;
    @SerializedName("pemasok")
    @Expose
    private String pemasok;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getStok() {
        return stok;
    }

    public String getPemasok() {
        return pemasok;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }
}
