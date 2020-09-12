package com.example.projectgreenveg.controller.Produk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectgreenveg.Helper.ImageConverter;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.service.ProdukDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditProduk extends AppCompatActivity implements  View.OnClickListener{

    private EditText  edNama, edHarga, edStok;
    private TextView edId;
    private EditText edKategori;
    private ImageView ivFoto;
    private Button bt_save;
    private Bitmap nBitmap;
    final int RESULT_EGALLERY = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produk);

        getSupportActionBar().setTitle("Edit Produk");

        edId = findViewById(R.id.ed_editId_produk);
        edNama = findViewById(R.id.ed_editNama_produk);
        edHarga = findViewById(R.id.ed_editHarga_produk);
        edStok = findViewById(R.id.ed_editStok_produk);
        edKategori = findViewById(R.id.ed_editKat_produk);
        ivFoto = findViewById(R.id.iv_addFoto_produk);
//
//        bt_simpan = findViewById(R.id.bt_editSimpan_produk);
//        bt_simpan.setOnClickListener(this);
//
        /////MENGAMBIL DATA DARI DETAIL////////////////
        Intent intent = getIntent();

        Integer produkId = intent.getExtras().getInt("produkId");
        edId.setText((String.valueOf(produkId)));

        String produkNama = intent.getExtras().getString("produkNama");
        edNama.setText(produkNama);

        Double produkHarga = intent.getExtras().getDouble("produkHarga");
        edHarga.setText((String.valueOf(produkHarga)));

        Double produkStok = intent.getExtras().getDouble("produkStok");
        edStok.setText((String.valueOf(produkStok)));

        Integer produkKategori = intent.getExtras().getInt("produkKategori");
        edKategori.setText((String.valueOf(produkKategori)));

//        byte []  produkFoto = intent.getExtras().getByteArray("produkFoto");
//        ivFoto.setImageBitmap(ImageConverter.toImage(produkFoto));
//        System.out.println("BISMILLAH BISA YA ALLAH");

        bt_save = findViewById(R.id.bt_editSimpan_produk);
        bt_save.setOnClickListener(this);

//


//        tvId    =findViewById(R.id.tv_detailId_produk);
//        tvNama  =findViewById(R.id.tv_detailNama_produk);
//        tvHarga =findViewById(R.id.tv_detailHarga_produk);
//        tvKategori =findViewById(R.id.tv_detailKategori_produk);
//        DbConnection db = DbConnection.getDatabase(getApplicationContext());
//        ProdukDao daoProduk = db.produkDao();
//        produkList = daoProduk.fondAll();
//        Produk produk = new Produk();
//
//        Intent intent = new Intent().getExtras().
//        Bundle b = getIntent().getExtras();
//        produk.getId() = b.getInt("id");


    }

    public  void panggileditgambar(View view){
        Intent intent = new Intent(
                Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_EGALLERY);
    }

//    versi 1
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_EGALLERY) {

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
        nBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        ivFoto.setImageBitmap(nBitmap);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_editSimpan_produk:

                DbConnection db = DbConnection.getDatabase(getApplicationContext());
                ProdukDao dao   =db.produkDao();
                Produk produk = new Produk();


                produk.setId(Integer.parseInt(edId.getText().toString()));
                produk.setNama(edNama.getText().toString());
                produk.setHarga(Double.parseDouble(edHarga.getText().toString()));
                produk.setStok(Double.parseDouble(edStok.getText().toString()));
                produk.setKategoriId(Integer.parseInt(edKategori.getText().toString()));
                produk.setPhoto(ImageConverter.toImage(nBitmap));
                dao.update(produk);

                System.out.println("Save Kategori" + produk.getId()+ "Sukses" );

                List<Produk> produkList = dao.fondAll();
                for (Produk p: produkList){
                    System.out.println(p.getId() + ". Nama : " +p.getNama()+ " - Kategori : " +p.getKategoriId()+ " - Harga : " +p.getHarga());
                }

                Toast.makeText(EditProduk.this, "Produk berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditProduk.this, ListProduk.class);
                startActivity(intent);
                break;

        }
    }
}