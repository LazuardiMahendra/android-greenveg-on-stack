package com.example.projectgreenveg.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectgreenveg.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText iEmail;
    private EditText iPassword;
    private Button signInBtn;
    private Button signUpBtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iEmail      =findViewById(R.id.et_email);
        iPassword   =findViewById(R.id.et_password);

        signInBtn   =findViewById(R.id.bt_sign_in);
        signInBtn.setOnClickListener(this);

        signUpBtn   =findViewById(R.id.bt_sign_up);
        signInBtn.setOnClickListener(this);

    }
    @Override
    public  void onClick(View v){
        if (v.getId()==R.id.bt_sign_in){
            Pegawai pegawai = new Pegawai(
                    this.iEmail.getText().toString(), this.iPassword.getText().toString()
            );
            if (pegawai.getEmail().equals("aku@lazu.com") && pegawai.getPassword().equals("12345")) {
                pegawai.catatIdentitasPegawai();

                intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Maaf, akun anda tidak terdaftar.", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, MainActivity.class);

                intent.putExtra("paramEmail", this.iEmail.getText().toString());
                intent.putExtra("paramPassword", this.iPassword.getText().toString());
//                intent.putExtra("param")

                startActivity(intent);
            }
        }

        }



    public void panggilsignup(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
