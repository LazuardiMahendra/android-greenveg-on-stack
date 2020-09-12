package com.example.projectgreenveg.controller.History;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectgreenveg.R;

public class HistoryActivity extends AppCompatActivity {

//    private ListView listView;
//    private ArrayList<String> listHistory;
//    private ArrayAdapter adapter;
//    private DrawerLayout drawerLayout;
//    private EditText iSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getSupportActionBar().setTitle("History");

//        listView = findViewById(R.id.iv_history);
//        listView.setOnItemClickListener(this);
//
//        listHistory = new ArrayList<>();
//        listHistory.add("Senin");
//        listHistory.add("Selasa");
//        listHistory.add("Rabu");
//        listHistory.add("Kamis");
//        listHistory.add("Jumat");
//        listHistory.add("Sabtu");
//        listHistory.add("Minggu");
//
//
//        adapter = new ArrayAdapter(this, R.layout.view_list_histori, listHistory);
//        listView.setAdapter(adapter);
//
//
//        iSearch = findViewById(R.id.h_et_search);
//        iSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//        String itemId = adapter.getItem(position).toString();
//        Toast.makeText(this, itemId, Toast.LENGTH_SHORT).show();
//    }
    }

    public void panggildetailhistory(View view) {
        Intent intent = new Intent(this, DetailHistory.class);
        startActivity(intent);
    }
    }