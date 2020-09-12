package com.example.projectgreenveg.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "produk",
        indices = {
                @Index("id"),
                @Index("kategori_id")
        },
        foreignKeys = @ForeignKey(entity = Kategori.class, parentColumns = "id",
                childColumns = "kategori_id")
)
public class Produk {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "nama")
    private String nama;


    @NonNull
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] photo;

    @NonNull
    @ColumnInfo(name = "harga")
    private Double harga;

    @NonNull
    public Double getStok() {
        return stok;
    }

    public void setStok(@NonNull Double stok) {
        this.stok = stok;
    }

    @NonNull
    @ColumnInfo(name = "stok")
    private Double stok;


    @NonNull
    @ColumnInfo(name = "kategori_id")
    private Integer kategoriId;

    public Produk() {
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getNama() {
        return nama;
    }

    public void setNama(@NonNull String nama) {
        this.nama = nama;
    }

    @NonNull
    public Double getHarga() {
        return harga;
    }

    public void setHarga(@NonNull Double harga) {
        this.harga = harga;
    }


    @NonNull
    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(@NonNull Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    @NonNull
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(@NonNull byte[] photo) {
        this.photo = photo;
    }
}
