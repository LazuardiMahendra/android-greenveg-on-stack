package com.example.projectgreenveg.service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectgreenveg.model.Produk;

import java.util.List;

@Dao
public interface ProdukDao {

    @Query("SELECT * FROM produk")
    public List<Produk> fondAll();

    @Query("SELECT * FROM produk WHERE id = :id")
    public Produk findOneById(Integer id);

    @Query("SELECT * FROM Produk " +
            "INNER JOIN Kategori ON Kategori.id = Produk.Kategori_id " +
            "WHERE Kategori.id = :id")
    public Produk findLeftJoin(Integer id);

    @Insert
    public  void save(Produk produk);

    @Delete
    public  void delete(Produk produk);

    @Update
    public  void update(Produk produk);
}
