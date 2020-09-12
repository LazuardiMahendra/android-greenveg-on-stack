package com.example.projectgreenveg.controller.Transaksi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.projectgreenveg.Beli;
import com.example.projectgreenveg.Keranjang.ListKeranjang;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.adapter.TransaksiAdapter;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.service.ProdukDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListTransaksi extends AppCompatActivity  {

    private List<Produk> listTransaksi = new ArrayList<>();
    private RecyclerView recyclerView;
    private TransaksiAdapter transaksiAdapter;
    private EditText iSearch;
    private FloatingActionButton bt_fab_cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaksi);

//        getSupportActionBar().setTitle("Transaksi");

        recyclerView = findViewById(R.id.rv_shop);

        Toolbar toolbar = findViewById(R.id.toolbar_shop);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Produk");

        DbConnection db = DbConnection.getDatabase(getApplicationContext());
        ProdukDao daoProduk = db.produkDao();
        listTransaksi = daoProduk.fondAll();

        transaksiAdapter = new TransaksiAdapter(listTransaksi);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(transaksiAdapter);

//        //Pengaturan NavigationView

        bt_fab_cart = findViewById(R.id.fab_cart);
        bt_fab_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListTransaksi.this, ListKeranjang.class);
                startActivity(i);
            }
        });


        transaksiAdapter.setOnClickListenerTransaksi(new TransaksiAdapter.OnClickListenerTransaksi() {
            @Override
            public void onClickTransaksi(Produk produk) {
                Intent i = new Intent(ListTransaksi.this, Beli.class);
                i.putExtra("produkId", produk.getId());
                i.putExtra("produkNama", produk.getNama());
                i.putExtra("produkHarga", produk.getHarga());
                i.putExtra("produkStok", produk.getStok());
                i.putExtra("produkKategori", produk.getKategoriId());
                i.putExtra("produkFoto", produk.getPhoto());
                startActivity(i);
                System.out.println("ALHAMDULILAH BISA YA ALLAH");

            }
        });

    }


}
