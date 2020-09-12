package com.example.projectgreenveg.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.controller.History.ListHistory;
import com.example.projectgreenveg.controller.Laporan.list_laporan;
import com.example.projectgreenveg.controller.Produk.ListProduk;
import com.example.projectgreenveg.controller.Transaksi.ListTransaksi;


public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }


    public void panggilproduk(View view) {
        Intent intent = new Intent(this, ListProduk.class);
        startActivity(intent);
    }

    public void panggiltoko(View view) {
        Intent intent = new Intent(this, TokoActivity.class);
        startActivity(intent);
    }

    public void panggillaporan(View view) {
        Intent intent = new Intent(this, list_laporan.class);
        startActivity(intent);
    }

    public void panggilhistory(View view) {
        Intent intent = new Intent(this, ListHistory.class);
        startActivity(intent);
    }

    public void panggiltransaksi(View view) {
        Intent intent = new Intent(this, ListTransaksi.class);
        startActivity(intent);


    }
}