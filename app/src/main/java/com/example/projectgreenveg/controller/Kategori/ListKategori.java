package com.example.projectgreenveg.controller.Kategori;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectgreenveg.Keranjang.ListKeranjang;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.adapter.KategoriAdapter;
import com.example.projectgreenveg.adapter.ProdukAdapter;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.controller.DashboardActivity;
import com.example.projectgreenveg.controller.Produk.AddProduk;
import com.example.projectgreenveg.controller.Produk.DetailProduk;
import com.example.projectgreenveg.controller.Produk.ListProduk;
import com.example.projectgreenveg.controller.Transaksi.ListTransaksi;
import com.example.projectgreenveg.model.Kategori;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.service.KategoriDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListKategori extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    private EditText etId;
    private List<Kategori> katagoriList = new ArrayList<>();
    private KategoriAdapter kategoriAdapter;
    private RecyclerView recycleView;

    private DrawerLayout drawerLayout;

    private FloatingActionButton bt_fab_add_kat;
    private Button bt_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kategori);


// set navigation drawer
        Toolbar toolbar = findViewById(R.id.toolbark);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kategori");
        drawerLayout = findViewById(R.id.mDrawerk);
        NavigationView navigationView = findViewById(R.id.nav_view_k);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//set floating action button


        recycleView = findViewById(R.id.rv_kategori);

        DbConnection db = DbConnection.getDatabase(getApplicationContext());
        KategoriDao daoKategori = db.kategoriDao();
        katagoriList    = daoKategori.findAll();

        kategoriAdapter = new KategoriAdapter(katagoriList);
        RecyclerView.LayoutManager nLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycleView.setLayoutManager(nLayoutManager);
        recycleView.setItemAnimator(new DefaultItemAnimator());
        recycleView.setAdapter(kategoriAdapter);

        bt_fab_add_kat = findViewById(R.id.fab_add_kat);
        bt_fab_add_kat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListKategori.this, AddKategori.class);
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
                daoKategori.delete(kategoriAdapter.getKategoriAt(viewHolder.getAdapterPosition()));
                Toast.makeText(ListKategori.this, "Produk Dihapus", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recycleView);

        kategoriAdapter.setOnClickListenerKat(new KategoriAdapter.OnClickListenerKat() {
            @Override
            public void onClickKat(Kategori kategori) {
                Intent i = new Intent(ListKategori.this, DetailKategori.class);
                i.putExtra("katId",kategori.getId());
                i.putExtra("katNama",kategori.getNama());
                startActivity(i);
                System.out.println("ALHAMDULILAH BISA YA ALLAH");
//

//                Intent eProdukId = intent.putExtra(DetailProduk.EXTRA_ID_PRODUK, produk.getId());
//                Intent eProdukNama = intent.putExtra(DetailProduk.EXTRA_NAMA_PRODUK, produk.getNama());
//                Intent eProdukHarga = intent.putExtra(DetailProduk.EXTRA_HARGA_PRODUK, produk.getNama());
//                Intent eProdukKat = intent.putExtra(DetailProduk.EXTRA_KATEGORI_PRODUK, produk.getKategoriId());
//
//                startActivity(intent);


            }
        });





//        iSearch = findViewById(R.id.k_et_search);
//        iSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
        etId = findViewById(R.id.et_delete_k);

        bt_delete = findViewById(R.id.bt_delete_k);
        bt_delete.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_delete_k:

                DbConnection db = DbConnection.getDatabase(getApplicationContext());
                KategoriDao dao = db.kategoriDao();
                Kategori kategori = new Kategori();

                kategori.setId(Integer.parseInt(etId.getText().toString()));
                dao.delete(kategori);

        }

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.bt_add_kategori) {
            Intent i = new Intent(ListKategori.this, AddKategori.class);
            startActivity(i);
        } else if (id == R.id.bt_add_produk) {
            Intent i = new Intent(ListKategori.this, AddProduk.class);
            startActivity(i);
        } else if (id == R.id.bt_list_kategori) {
            Intent i = new Intent(ListKategori.this, ListKategori.class);
            startActivity(i);
        } else if (id == R.id.bt_list_produk) {
            Intent i = new Intent(ListKategori.this, ListProduk.class);
            startActivity(i);
        } else if (id == R.id.bt_dashboard) {
            Intent i = new Intent(ListKategori.this, DashboardActivity.class);
            startActivity(i);
        }
        return true;
    }
}


