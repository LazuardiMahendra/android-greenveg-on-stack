package com.example.projectgreenveg.controller.History;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.controller.History.HistoryActivity;

import java.util.ArrayList;

public class ListHistory extends AppCompatActivity  implements ListView.OnItemClickListener{

    private ListView listView;
    private ArrayList<String> listHistory;
    private ArrayAdapter adapter;
    private EditText iSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_history);

        getSupportActionBar().setTitle("List History");

        listView = findViewById(R.id.iv_history);
        listView.setOnItemClickListener(this);

        listHistory = new ArrayList<>();
        listHistory.add("History 1");
        listHistory.add("History 2");
        listHistory.add("History 3");
        listHistory.add("History 4");
        listHistory.add("History 5");
        listHistory.add("History 6");
        listHistory.add("History 7");


        adapter = new ArrayAdapter(this, R.layout.view_list_histori, listHistory);
        listView.setAdapter(adapter);


        iSearch = findViewById(R.id.h_et_search);
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
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    }


