package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

        ArrayAdapter<City> adapter = new ArrayAdapter<>(StartActivity.this, android.R.layout.simple_list_item_1, MainActivity.cities);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(StartActivity.this, HomeActivity.class);
                intent.putExtra("SelectedCity", position);
                startActivity(intent);
            }
        });
    }
}