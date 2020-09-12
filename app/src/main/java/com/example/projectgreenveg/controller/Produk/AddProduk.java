package com.example.projectgreenveg.controller.Produk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectgreenveg.Helper.ImageConverter;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.service.ProdukDao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AddProduk extends AppCompatActivity implements  View.OnClickListener {

    private EditText etId, etNama, etHarga, etKategori, etStok;
    private ImageView addPhoto;
    private Button bt_simpan, bt_photo;
    private  Bitmap mBitmap;

    String imgToString;
    final int RESULT_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produk);

        getSupportActionBar().setTitle("Add Produk");

        DbConnection db = DbConnection.getDatabase(getApplicationContext());

        addPhoto    = findViewById(R.id.iv_addPhoto_produk);

        etNama  =findViewById(R.id.et_addNama_produk);
        etHarga =findViewById(R.id.et_addHarga_produk);
        etStok  =findViewById(R.id.et_addStok_produk);
        etKategori  =findViewById(R.id.et_addKategori_produk);

        mBitmap = null;
        bt_simpan = findViewById(R.id.bt_simpan_produk);
        bt_simpan.setOnClickListener(this);
        Button reset = (Button) findViewById(R.id.bt_batal);
    }

    public  void panggilgambar(View view){
        Intent intent = new Intent(
                Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_GALLERY);
    }



//versi 1
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_GALLERY) {

            if (resultCode == RESULT_OK) {
                if (data != null) {
                    // Get the URI of the selected file
                    final Uri uri = data.getData();
                    try {
                        useImage(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            super.onActivityResult(requestCode, resultCode, data);

        }

    }
    void useImage(Uri uri) throws IOException {
       mBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        //use the bitmap as you like
        addPhoto.setImageBitmap(mBitmap);
    }


    public void reset(View view){

        etNama= findViewById(R.id.et_addNama_produk);
        etNama.setText("");

        etHarga = findViewById(R.id.et_addHarga_produk);
        etHarga.setText("");

        etStok= findViewById(R.id.et_addStok_produk);
        etStok.setText("");

        etKategori = findViewById(R.id.et_addKategori_produk);
        etKategori.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_simpan_produk:

                DbConnection db = DbConnection.getDatabase(getApplicationContext());
                ProdukDao dao   =db.produkDao();
                Produk produk = new Produk();

                produk.setNama(etNama.getText().toString());
                produk.setHarga(Double.parseDouble(etHarga.getText().toString()));
                produk.setStok(Double.parseDouble(etStok.getText().toString()));
                produk.setKategoriId(Integer.parseInt(etKategori.getText().toString()));
                produk.setPhoto(ImageConverter.toImage(mBitmap));
                dao.save(produk);

                System.out.println("Save Kategori" + produk.getId()+ "Sukses" );

                List<Produk> produkList = dao.fondAll();
                for (Produk p: produkList){
                    System.out.println(p.getId() + ". Nama : " +p.getNama()+ " - Kategori : " +p.getKategoriId()+ " - Harga : " +p.getHarga());
                }

                Toast.makeText(AddProduk.this, "Produk berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ListProduk.class);
                startActivity(intent);
                break;
        }

    }
}
