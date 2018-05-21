package com.example.irfan.layouting.data;

import java.io.Serializable;

public class Produk2Model implements Serializable {
    private String gambar;
    private String judul;
    private double harga;

    public Produk2Model(String gambar, String judul, double harga)
    {
        this.setGambar(gambar);
        this.setJudul(judul);
        this.setHarga(harga);
    }


    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
