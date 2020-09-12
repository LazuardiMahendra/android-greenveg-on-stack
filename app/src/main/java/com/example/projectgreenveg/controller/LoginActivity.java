package com.example.projectgreenveg.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.connection.DbConnection;
import com.example.projectgreenveg.model.Produk;
import com.example.projectgreenveg.service.ProdukDao;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar actionBar;
    private TextView tvRegister;
    private TextView tvLostPwd;

    private EditText etEmail;
    private EditText etPassword;

    private EditText etNama;
    private Button btLogin;
    private Button btDelete;
    private Button btUpdate;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        // pemberian judul pada actionbar
//
//        actionBar       =getSupportActionBar();
//                        actionBar.setTitle("login");
//
//        // define textView
//
//        tvRegister      =findViewById(R.id.tv_register);
//                        tvRegister.setOnClickListener(this);
//
//        tvLostPwd       =findViewById(R.id.tv_lost_password);
//                        tvLostPwd.setOnClickListener(this);
//
//        etEmail         =(EditText)findViewById(R.id.et_email);
//        etPassword      =(EditText)findViewById(R.id.et_password);
//
//        // define button

        btLogin         =findViewById(R.id.bt_login);
                        btLogin.setOnClickListener(this);

        btUpdate         =findViewById(R.id.bt_update);
                        btUpdate.setOnClickListener(this);

        btDelete         =findViewById(R.id.bt_delete);
                        btDelete.setOnClickListener(this);

        etNama          =findViewById(R.id.nama_produk);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_login:
                System.out.println("Redirect to Dashboard");


                DbConnection db = DbConnection.getDatabase(getApplicationContext());
                ProdukDao dao   =db.produkDao();

                Produk produk   =new Produk();
                produk.setNama(this.etNama.getText().toString());
                                 dao.update(produk);
                                 System.out.println(("Save produk" + produk.getId() + "Sukses"));

                List<Produk> produkList =dao.fondAll();
                                        for(Produk p: produkList){
                                            System.out.println(p.getId() + " | " + p.getNama());
                                        }
//
//                Produk oneProduk    =dao.findOneById(5);
//                                        System.out.println("find one produk"  +oneProduk.getId() + " | " + oneProduk.getNama());
        }
    }
}
