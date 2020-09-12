package com.example.projectgreenveg.controller.History;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectgreenveg.R;

public class DetailHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        getSupportActionBar().setTitle("Detail History");
    }


}
