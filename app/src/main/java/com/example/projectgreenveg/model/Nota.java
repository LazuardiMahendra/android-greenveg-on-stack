package com.example.projectgreenveg.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.projectgreenveg.Helper.TimestampConverter;

import java.util.Date;

@Entity(tableName = "nota",
        indices = {
                @Index("id"),
                @Index("toko_npwp")
        },
        foreignKeys = @ForeignKey(entity = Toko.class, parentColumns = "npwp",
                childColumns = "toko_npwp")
)

public class Nota {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;


    @ColumnInfo(name = "tanggal")
    @TypeConverters(TimestampConverter.class)

    private Date tanggal;

    @ColumnInfo(name = "pembeli")
    private String pembeli ;

    @ColumnInfo(name = "ppn")
    private Double ppn;

    @ColumnInfo(name = "total_pembelian")
    private Double total_pembelian;

    @ColumnInfo(name = "bayar")
    private Double bayar;

    @ColumnInfo(name = "kembalian")
    private Double kembalian;

    @ColumnInfo(name = "status_pembayaran")
    private String status_pembayaran;

    @ColumnInfo(name = "toko_npwp")
    private Integer toko_npwp;

    public Nota() {
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getPembeli() {
        return pembeli;
    }

    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    public Double getPpn() {
        return ppn;
    }

    public void setPpn(Double ppn) {
        this.ppn = ppn;
    }

    public Double getTotal_pembelian() {
        return total_pembelian;
    }

    public void setTotal_pembelian(Double total_pembelian) {
        this.total_pembelian = total_pembelian;
    }

    public Double getBayar() {
        return bayar;
    }

    public void setBayar(Double bayar) {
        this.bayar = bayar;
    }

    public Double getKembalian() {
        return kembalian;
    }

    public void setKembalian(Double kembalian) {
        this.kembalian = kembalian;
    }

    public String getStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(String status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

    public Integer getToko_npwp() {
        return toko_npwp;
    }

    public void setToko_npwp(Integer toko_npwp) {
        this.toko_npwp = toko_npwp;
    }
}
