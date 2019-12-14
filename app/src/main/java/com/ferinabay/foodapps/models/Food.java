package com.ferinabay.foodapps.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    private String name;
    private String harga;
    private String deskripsi;
    private Character kategori;
    private Character fav;
    int[] images;

    public Food(String name, String harga, String deskripsi, Character kategori, Character fav) {
        this.name = name;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.fav = fav;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Character getKategori() {
        return kategori;
    }

    public void setKategori(Character kategori) {
        this.kategori = kategori;
    }

    public Character getFav() {
        return fav;
    }

    public void setFav(Character fav) {
        this.fav = fav;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
