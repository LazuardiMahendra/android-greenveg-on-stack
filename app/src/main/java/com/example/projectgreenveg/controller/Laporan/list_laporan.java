package com.example.projectgreenveg.controller.Laporan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projectgreenveg.R;

import java.util.ArrayList;

public class list_laporan extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView listView;
    private ArrayList<String> listLaporan;
    private ArrayAdapter adapter;
    private EditText iSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_laporan);

        getSupportActionBar().setTitle("Laporan");

        listView = findViewById(R.id.iv_laporan);
        listView.setOnItemClickListener(this);

        listLaporan = new ArrayList<>();
        listLaporan.add("Laporan 1");
        listLaporan.add("Laporan 2");
        listLaporan.add("Laporan 3");
        listLaporan.add("Laporan 4");
        listLaporan.add("Laporan 5");
        listLaporan.add("Laporan 6");
        listLaporan.add("Laporan 7");


        adapter = new ArrayAdapter(this, R.layout.view_list_laporan, listLaporan);
        listView.setAdapter(adapter);


        iSearch = findViewById(R.id.l_et_search);
        iSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String itemId = adapter.getItem(position).toString();
        Intent intent = new Intent(this, LaporanActivity.class);
        startActivity(intent);
    }
}
