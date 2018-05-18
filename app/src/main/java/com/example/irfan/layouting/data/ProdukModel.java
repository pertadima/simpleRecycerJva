package com.example.irfan.layouting.data;

public class ProdukModel  {
    private String gambar;
    private String judul;
    private double harga;


    public ProdukModel(String gambar, String judul, double harga)
    {
        this.gambar = gambar;
        this.judul = judul;
        this.harga = harga;
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
