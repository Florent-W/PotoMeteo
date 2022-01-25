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

        mListView = (ListView) findViewById(R.id.listView);

        Ville Paris = new Ville(1,"Paris", "France");
        Ville Marseille = new Ville(2,"Marseille", "France");
        Ville Lyon = new Ville(3,"Lyon", "France");

        Ville[] Villes = new Ville[]{Paris, Marseille, Lyon};

        ArrayAdapter<Ville> adapter = new ArrayAdapter<Ville>(StartActivity.this, android.R.layout.simple_list_item_1, Villes);
        mListView.setAdapter(adapter);
    }
}