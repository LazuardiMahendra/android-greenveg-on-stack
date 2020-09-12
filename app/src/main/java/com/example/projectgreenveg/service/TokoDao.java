package com.example.projectgreenveg.service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectgreenveg.model.Toko;

import java.util.List;

@Dao
public interface TokoDao {
    @Query("SELECT * FROM toko")
    public List<Toko> fondAll();

    @Query("SELECT * FROM toko WHERE npwp = :npwp")
    public Toko findOneById(Integer npwp);

    @Insert
    public  void save(Toko toko);

    @Delete
    public  void delete(Toko toko);

    @Update
    public  void update(Toko toko);
}
