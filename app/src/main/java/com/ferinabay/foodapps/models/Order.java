package com.ferinabay.foodapps.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "log_order")
public class Order {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "tglorder")
    private String tglorder;

    @ColumnInfo(name = "jumlah")
    private String jumlah;

    @ColumnInfo(name = "kategori")
    private String kategori;


    public Order(String nama, String tglorder, String jumlah, String kategori) {
        this.nama = nama;
        this.tglorder = tglorder;
        this.jumlah = jumlah;
        this.kategori = kategori;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglorder() {
        return tglorder;
    }

    public void setTglorder(String tglorder) {
        this.tglorder = tglorder;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }


}
