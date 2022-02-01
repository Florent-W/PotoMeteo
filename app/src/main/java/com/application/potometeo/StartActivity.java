package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mListView = findViewById(R.id.listView);

        City Paris = new City("1","Paris", "France");
        City Marseille = new City("2","Marseille", "France");
        City Lyon = new City("3","Lyon", "France");

        City[] Citys = new City[]{Paris, Marseille, Lyon};

        ArrayAdapter<City> adapter = new ArrayAdapter<>(StartActivity.this, android.R.layout.simple_list_item_1, Citys);
        mListView.setAdapter(adapter);
    }
}