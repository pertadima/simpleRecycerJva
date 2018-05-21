package com.example.irfan.layouting.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ProdukModel implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gambar);
        dest.writeString(this.judul);
        dest.writeDouble(this.harga);
    }

    protected ProdukModel(Parcel in) {
        this.gambar = in.readString();
        this.judul = in.readString();
        this.harga = in.readDouble();
    }

    public static final Parcelable.Creator<ProdukModel> CREATOR = new Parcelable.Creator<ProdukModel>() {
        @Override
        public ProdukModel createFromParcel(Parcel source) {
            return new ProdukModel(source);
        }

        @Override
        public ProdukModel[] newArray(int size) {
            return new ProdukModel[size];
        }
    };
}
