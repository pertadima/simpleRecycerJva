package com.example.irfan.layouting.data.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Produk") //Table name in DB
public class Produk {

    @Id(autoincrement = true)   //primary key
    private Long id;
    @Property(nameInDb = "judul") //row name
    private String judul;
    @Property(nameInDb = "harga") //row name
    private double harga;

    @Generated(hash = 2127717744)
    public Produk(String judul, double harga) {
        this.setJudul(judul);
        this.setHarga(harga);
    }

    @Generated(hash = 1556870573)
    public Produk() {
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
