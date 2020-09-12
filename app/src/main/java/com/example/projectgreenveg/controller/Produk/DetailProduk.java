package com.example.projectgreenveg.controller.Produk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectgreenveg.Helper.ImageConverter;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.adapter.ProdukAdapter;
import com.example.projectgreenveg.model.Produk;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DetailProduk extends AppCompatActivity  {

    private  TextView tvId, tvNama, tvHarga, tvKategori, tvStok;
    private ImageView tvFoto;
    private FloatingActionButton bt_fabEdit;
    private ProdukAdapter produkAdapter;
    private List<Produk> produkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

//        getSupportActionBar().setTitle("Detail Produk");
//
//        tvId = findViewById(R.id.tv_detailId_produk);
//        tvNama = findViewById(R.id.tv_detailNama_produk);
//        tvHarga = findViewById(R.id.tv_detailHarga_produk);
//        tvStok = findViewById(R.id.tv_detailStok_produk);
//        tvKategori = findViewById(R.id.tv_detailKat_produk);
//        tvFoto = findViewById(R.id.iv_detailPic_produk);
//
//        produkAdapter = new ProdukAdapter(produkList);
//
//        Intent intent = getIntent();
//        Integer produkId = intent.getExtras().getInt("produkId");
//        tvId.setText((String.valueOf(produkId)));
//
//        String produkNama = intent.getExtras().getString("produkNama");
//        tvNama.setText(produkNama);
//
//        Double produkHarga = intent.getExtras().getDouble("produkHarga");
//        tvHarga.setText((String.valueOf(produkHarga)));
//
//        Double produkStok = intent.getExtras().getDouble("produkStok");
//        tvStok.setText((String.valueOf(produkStok)));
//
//        Integer produkKategori = intent.getExtras().getInt("produkKategori");
//        tvKategori.setText((String.valueOf(produkKategori)));
//
//        byte []  produkFoto = intent.getExtras().getByteArray("produkFoto");
//        tvFoto.setImageBitmap(ImageConverter.toImage(produkFoto));
//        System.out.println("BISMILLAH BISA YA ALLAH");
//
//        bt_fabEdit = findViewById(R.id.fab_edit_produk);
//        bt_fabEdit.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Produk produk = new Produk();
//                Intent i = new Intent(DetailProduk.this, EditProduk.class);
//                i.putExtra("produkId",produk.getId());
//                i.putExtra("produkNama",produk.getNama());
//                i.putExtra("produkHarga",produk.getHarga());
//                i.putExtra("produkStok",produk.getStok());
//                i.putExtra("produkKategori",produk.getKategoriId());
//                i.putExtra("produkFoto",produk.getPhoto());
//                startActivity(i);
//                System.out.println("ALHAMDULILAH BISA YA ALLAH");
//                startActivity(i);
//            }
//        });

    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bt_edit_produk:
//
//                DbConnection db = DbConnection.getDatabase(getApplicationContext());
//                ProdukDao dao   =db.produkDao();
//                Produk produk = new Produk();
//
//                produk.setId(Integer.parseInt(tvId.getText().toString()));
//                produk.setNama(tvNama.getText().toString());
//                produk.setHarga(Double.parseDouble(tvHarga.getText().toString()));
//                produk.setStok(Double.parseDouble(tvStok.getText().toString()));
//                produk.setKategoriId(Integer.parseInt(tvKategori.getText().toString()));
//                dao.update(produk);
//
//                System.out.println("Save Kategori" + produk.getId()+ "Sukses" );
//
//                List<Produk> produkList = dao.fondAll();
//                for (Produk p: produkList){
//                    System.out.println(p.getId() + ". Nama : " +p.getNama()+ " - Kategori : " +p.getKategoriId()+ " - Harga : " +p.getHarga());
//                }
//
//                Toast.makeText(DetailProduk.this, "Produk berhasil ditambahkan", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, ListProduk.class);
//                startActivity(intent);
//                break;
//
//        }
//    }
}