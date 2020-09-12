package com.example.projectgreenveg.Keranjang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.adapter.KeranjangAdapter;
import com.example.projectgreenveg.adapter.ProdukAdapter;
import com.example.projectgreenveg.controller.Produk.AddProduk;
import com.example.projectgreenveg.controller.Produk.ListProduk;
import com.example.projectgreenveg.controller.Transaksi.ListTransaksi;
import com.example.projectgreenveg.model.Keranjang;
import com.example.projectgreenveg.model.Produk;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ListKeranjang extends AppCompatActivity {

    private List<Keranjang> keranjangList = new ArrayList<>();
    private KeranjangAdapter keranjangAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_keranjang);

        getSupportActionBar().setTitle("Keranjang");

        recyclerView = findViewById(R.id.rv_keranjang);


    }
}
