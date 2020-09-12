package com.example.projectgreenveg.controller.Kategori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.model.Kategori;
import com.example.projectgreenveg.service.KategoriDao;

import java.util.List;

public class DetailKategori extends AppCompatActivity implements View.OnClickListener {

    private EditText etId, etNama;
    private Button bt_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kategori);

        bt_edit = findViewById(R.id.bt_edit_kat);
        bt_edit.setOnClickListener(this);

        etId = findViewById(R.id.tv_detailId_kat);
        etNama = findViewById(R.id.tv_detailNama_kat);

        Intent intent = getIntent();

        Integer katId = intent.getExtras().getInt("katId");
        etId.setText((String.valueOf(katId)));
        String katNama = intent.getExtras().getString("katNama");
        etNama.setText(katNama);

        System.out.println("BISMILLAH BISA YA ALLAH");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_edit_kat:

                DbConnection db = DbConnection.getDatabase(getApplicationContext());
                KategoriDao dao   =db.kategoriDao();

                Kategori kategori   = new Kategori();
                kategori.setId(Integer.parseInt(etId.getText().toString()));
                kategori.setNama(this.etNama.getText().toString());
                dao.update(kategori);
                System.out.println("Save Kategori" + kategori.getId()+ "Sukses" );

                List<Kategori> listkategori = dao.findAll();
                for (Kategori p : listkategori) {
                    System.out.println(p.getId() + ". Kategori : " + p.getNama());
                }

                Toast.makeText(DetailKategori.this, "Produk berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ListKategori.class);
                startActivity(intent);
                break;
        }
    }
}
