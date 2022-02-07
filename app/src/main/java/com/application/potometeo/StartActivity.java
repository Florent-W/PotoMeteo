package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/***
 * Activité permettant de choisir sa ville au démarrage
 */
public class StartActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mListView = findViewById(R.id.listView);

        if (mListView.getAdapter() == null) {
            ArrayAdapter<City> adapter = new ArrayAdapter<>(StartActivity.this, android.R.layout.simple_list_item_1, MainActivity.cities);

            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(StartActivity.this, HomeActivity.class);
                    City c = (City) parent.getAdapter().getItem(position);
                    String city = c.getName(), country = c.getCountry(), lat = c.getLat(), lon = c.getLon();
                    new DBHelper(getApplicationContext()).setCity(city, country, lat, lon);
                    intent.putExtra("city", city);
                    intent.putExtra("country", country);
                    intent.putExtra("lat", lat);
                    intent.putExtra("lon", lon);
                    startActivity(intent); // Démarre l'application après le choix de la ville
                }
            });
        }
    }
}