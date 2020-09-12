package com.example.projectgreenveg.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "toko",
        indices = {
                @Index("npwp")
        }
)

public class Toko {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "npwp")
    private Integer npwp;

    @NonNull
    @ColumnInfo(name = "nama")
    private String nama;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    @NonNull
    @ColumnInfo(name = "alamat")
    private String alamat;

    @NonNull
    @ColumnInfo(name = "telpon")
    private String telpon;

    @NonNull
    @ColumnInfo(name = "ppn")
    private Double ppn;

    @NonNull
    @ColumnInfo(name = "total_trx")
    private Integer total_trx;

    @NonNull
    @ColumnInfo(name = "akhir_trx")
    private String akhir_trx;

    public Toko() {
    }

    @NonNull
    public Integer getNpwp() {
        return npwp;
    }

    public void setNpwp(@NonNull Integer npwp) {
        this.npwp = npwp;
    }

    @NonNull
    public String getNama() {
        return nama;
    }

    public void setNama(@NonNull String nama) {
        this.nama = nama;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(@NonNull String alamat) {
        this.alamat = alamat;
    }

    @NonNull
    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(@NonNull String telpon) {
        this.telpon = telpon;
    }

    @NonNull
    public Double getPpn() {
        return ppn;
    }

    public void setPpn(@NonNull Double ppn) {
        this.ppn = ppn;
    }

    @NonNull
    public Integer getTotal_trx() {
        return total_trx;
    }

    public void setTotal_trx(@NonNull Integer total_trx) {
        this.total_trx = total_trx;
    }

    @NonNull
    public String getAkhir_trx() {
        return akhir_trx;
    }

    public void setAkhir_trx(@NonNull String akhir_trx) {
        this.akhir_trx = akhir_trx;
    }
}
