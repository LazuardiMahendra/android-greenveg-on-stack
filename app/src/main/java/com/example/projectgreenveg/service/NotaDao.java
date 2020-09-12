package com.example.projectgreenveg.service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectgreenveg.model.Nota;
import com.example.projectgreenveg.model.Produk;

import java.util.List;

@Dao
public interface NotaDao {

    @Query("SELECT * FROM nota")
    public List<Nota> fondAll();

    @Query("SELECT * FROM nota WHERE id = :id")
    public Nota findOneById(Integer id);

    @Insert
    public  void save(Nota nota);

    @Delete
    public  void delete(Nota nota);

    @Update
    public  void update(Nota nota);
}

