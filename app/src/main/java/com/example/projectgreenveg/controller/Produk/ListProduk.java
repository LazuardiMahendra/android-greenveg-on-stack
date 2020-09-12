package com.example.projectgreenveg.controller.Produk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.adapter.ProdukAdapter;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.controller.DashboardActivity;
import com.example.projectgreenveg.controller.Kategori.ListKategori;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.service.ProdukDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListProduk extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private List<Produk> produkList = new ArrayList<>();
    private ProdukAdapter produkAdapter;
    private RecyclerView recyclerView;
    private DrawerLayout drawerLayout;
    private FloatingActionButton bt_fab_add_produk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);


        //buat onclick list produk

        recyclerView = findViewById(R.id.rv_produk);

        //Tampilan ActionBar

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Produk");

        //Koneksi dan Adapter

        DbConnection db = DbConnection.getDatabase(getApplicationContext());
        ProdukDao daoProduk = db.produkDao();
        produkList = daoProduk.fondAll();

        produkAdapter = new ProdukAdapter(produkList);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(produkAdapter);

        //Pengaturan NavigationView

        drawerLayout = findViewById(R.id.mDrawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //FloatingActionBar

        bt_fab_add_produk = findViewById(R.id.fab_add_produk);
        bt_fab_add_produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListProduk.this, AddProduk.class);
                startActivity(i);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                daoProduk.delete(produkAdapter.getProdukAt(viewHolder.getAdapterPosition()));
                Toast.makeText(ListProduk.this, "Produk Dihapus", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        produkAdapter.setOnClickListenerProduk(new ProdukAdapter.OnClickListenerProduk() {
            @Override
            public void onClickProduk(Produk produk) {
                Intent i = new Intent(ListProduk.this, EditProduk.class);
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


    //
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.bt_list_kategori) {
            Intent i = new Intent(ListProduk.this, ListKategori.class);
            startActivity(i);
        } else if (id == R.id.bt_list_produk) {
            Intent i = new Intent(ListProduk.this, ListProduk.class);
            startActivity(i);
        } else if (id == R.id.bt_dashboard) {
            Intent i = new Intent(ListProduk.this, DashboardActivity.class);
            startActivity(i);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
