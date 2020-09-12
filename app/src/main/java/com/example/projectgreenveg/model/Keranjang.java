package com.example.projectgreenveg.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "keranjang",
        primaryKeys = {"produk_id", "nota_id"},
        indices = {
                @Index("nama_produk"),
                @Index("nota_id"),
                @Index("produk_id")
        },
        foreignKeys ={ @ForeignKey(entity = Produk.class, parentColumns = "id",
                childColumns = "produk_id"),
                @ForeignKey(entity = Nota.class, parentColumns = "id",
                        childColumns = "nota_id")}
)

public class Keranjang {

    @NonNull
    @ColumnInfo(name = "produk_id")
    private long produk_id;

    @NonNull
    @ColumnInfo(name = "nota_id")
    private long nota_id;

    @NonNull
    @ColumnInfo(name = "nama_produk")
    private String nama_produk;

    @NonNull
    @ColumnInfo(name = "jumlah_produk")
    private Integer jumlah_produk;

    @NonNull
    @ColumnInfo(name = "sub_total")
    private Double sub_total;

    @NonNull
    @ColumnInfo(name = "status_pembelian")
    private String status_pembelian;


    @NonNull
    @ColumnInfo(name = "harga")
    private Double harga;

    @NonNull
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] photo;

    public Keranjang() {
    }

    @NonNull
    public long getProduk_id() {
        return produk_id;
    }

    public void setProduk_id(@NonNull long produk_id) {
        this.produk_id = produk_id;
    }

    @NonNull
    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(@NonNull String nama_produk) {
        this.nama_produk = nama_produk;
    }

    @NonNull
    public Integer getJumlah_produk() {
        return jumlah_produk;
    }

    public void setJumlah_produk(@NonNull Integer jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    @NonNull
    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(@NonNull Double sub_total) {
        this.sub_total = sub_total;
    }

    @NonNull
    public String getStatus_pembelian() {
        return status_pembelian;
    }

    public void setStatus_pembelian(@NonNull String status_pembelian) {
        this.status_pembelian = status_pembelian;
    }

    @NonNull
    public long getNota_id() {
        return nota_id;
    }

    public void setNota_id(@NonNull long nota_id) {
        this.nota_id = nota_id;
    }

    @NonNull
    public Double getHarga() {
        return harga;
    }

    public void setHarga(@NonNull Double harga) {
        this.harga = harga;
    }

    @NonNull
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(@NonNull byte[] photo) {
        this.photo = photo;
    }
}