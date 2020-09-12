package com.example.projectgreenveg.connection;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projectgreenveg.model.Kategori;
import com.example.projectgreenveg.model.Keranjang;
import com.example.projectgreenveg.model.Nota;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.model.Toko;
import com.example.projectgreenveg.service.KategoriDao;
import com.example.projectgreenveg.service.KeranjangDao;
import com.example.projectgreenveg.service.NotaDao;
import com.example.projectgreenveg.service.ProdukDao;
import com.example.projectgreenveg.service.TokoDao;

@Database(
        entities = {
                Produk.class,
                Kategori.class,
                Keranjang.class,
                Nota.class,
                Toko.class
        },
        version = 1, exportSchema = true
)
public abstract class DbConnection  extends RoomDatabase
{

    private static DbConnection INSTANCE;

    public abstract ProdukDao produkDao();
    public abstract KategoriDao kategoriDao();
    public abstract KeranjangDao keranjangDao();
    public abstract NotaDao notaDao();
    public abstract TokoDao tokoDao();

    public static DbConnection getDatabase (Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DbConnection.class, "app-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
