
package com.example.projectgreenveg.controller.Kategori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.model.Kategori;
import com.example.projectgreenveg.service.KategoriDao;

import java.util.List;

public class AddKategori extends AppCompatActivity implements View.OnClickListener {

    private EditText etNama, etId;
    private Button btSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kategori);

        getSupportActionBar().setTitle("Add Kategori");

        etNama = findViewById(R.id.et_addNama_kat);

        btSimpan    =findViewById(R.id.bt_simpan_kat);
                    btSimpan.setOnClickListener(this);

        Button reset = (Button) findViewById(R.id.bt_batal);
    }



    public void reset(View view) {
        etNama = findViewById(R.id.et_addNama_kat);
        etNama.setText("");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_simpan_kat:

                DbConnection db = DbConnection.getDatabase(getApplicationContext());
                KategoriDao dao   =db.kategoriDao();

                Kategori kategori   = new Kategori();
//                kategori.setId(Integer.parseInt(etId.getText().toString()));
                kategori.setNama(this.etNama.getText().toString());
                                    dao.save(kategori);
                                    System.out.println("Save Kategori" + kategori.getId()+ "Sukses" );

                List<Kategori> listkategori = dao.findAll();
                for (Kategori p : listkategori) {
                    System.out.println(p.getId() + ". Kategori : " + p.getNama());
                }

                Toast.makeText(AddKategori.this, "Produk berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ListKategori.class);
                startActivity(intent);
                break;
        }
    }
}
