package com.example.projectgreenveg.service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectgreenveg.model.Keranjang;

import java.util.List;

@Dao
public interface KeranjangDao {

    @Query("SELECT * FROM keranjang")
    public List<Keranjang> findAll();

    @Query("SELECT * FROM keranjang WHERE nama_produk LIKE :nama_produk ")
    public Keranjang findOneById(String nama_produk);


    @Query("SELECT * FROM Keranjang " +
            "INNER JOIN Nota ON Nota.id = Keranjang.produk_id " +
            "WHERE Nota.id = :nota_id")
    public List<Keranjang> findInner(int nota_id);

    @Query("SELECT * FROM Keranjang " +
            "LEFT JOIN Nota ON Nota.id = Keranjang.nota_id " )
    public List<Keranjang> findLeft();

    @Insert
    public void save(Keranjang keranjang);

    @Update
    public void update(Keranjang keranjang);

    @Delete
    public void  delete(Keranjang keranjang);


}
