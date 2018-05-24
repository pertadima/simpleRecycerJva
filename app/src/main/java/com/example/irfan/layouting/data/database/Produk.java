package com.example.irfan.layouting.data.database;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Produk") //Table name in DB
public class Produk implements Parcelable {

    @Id(autoincrement = true)   //primary key
    private Long id;
    @Property(nameInDb = "judul") //row name
    private String judul;
    @Property(nameInDb = "harga") //row name
    private double harga;


    public Produk() {
    }

    @Generated(hash = 1599905272)
    public Produk(Long id, String judul, double harga) {
        this.id = id;
        this.judul = judul;
        this.harga = harga;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.judul);
        dest.writeDouble(this.harga);
    }

    protected Produk(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.judul = in.readString();
        this.harga = in.readDouble();
    }

    public static final Parcelable.Creator<Produk> CREATOR = new Parcelable.Creator<Produk>() {
        @Override
        public Produk createFromParcel(Parcel source) {
            return new Produk(source);
        }

        @Override
        public Produk[] newArray(int size) {
            return new Produk[size];
        }
    };
}
