package com.example.projectgreenveg.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectgreenveg.R;

public class SignUpActivity extends AppCompatActivity implements  View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_sign_up_2) {
            Toast.makeText(this, "Akun Anda Terdaftar", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.bt_sign_up_2) {
            Toast.makeText(this, "Harap isi data diatas", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }

    public void panggilbacksignup(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
