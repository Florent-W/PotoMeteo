package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
            if(MainActivity.cities.size() < 1) {
                MainActivity.cities.add(new City("2759794", "Amsterdam", "Pays-Bas", "52.374031", "4.88969"));
                MainActivity.cities.add(new City("264371", "Athènes", "Grèce", "37.97945", "23.716221"));
                MainActivity.cities.add(new City("2950158", "Berlin", "Allemagne", "54.033329", "10.45"));
                MainActivity.cities.add(new City("2800866", "Bruxelles", "Belgique", "50.853321", "4.35144"));
                MainActivity.cities.add(new City("2618425", "Copenhague", "Danemark", "55.675941", "12.56553"));
                MainActivity.cities.add(new City("2964574", "Dublin", "Irlande", "53.34399", "-6.26719"));
                MainActivity.cities.add(new City("2643743", "Londres", "Angleterre", "51.50853", "-0.12574"));
                MainActivity.cities.add(new City("3117735", "Madrid", "Espagne", "40.4165", "-3.70256"));
                MainActivity.cities.add(new City("2995469", "Marseille", "France", "43.296951", "5.38107"));
                MainActivity.cities.add(new City("3996063", "Mexico", "Mexique", "23.0", "-102.0"));
                MainActivity.cities.add(new City("524894", "Moscou", "Russie", "55.761665", "37.606667"));
                MainActivity.cities.add(new City("2989204", "Orsay", "France", "48.695721", "2.18727"));
                MainActivity.cities.add(new City("2968815", "Paris", "France", "48.853401", "2.3486"));
                MainActivity.cities.add(new City("1816670", "Pékin", "Chine", "39.907501", "116.397232"));
                MainActivity.cities.add(new City("964137", "Pretoria", "Afrique du Sud", "-25.74486", "28.18783"));
                MainActivity.cities.add(new City("3169070", "Rome", "Italie", "41.894741", "12.4839"));
                MainActivity.cities.add(new City("1835847", "Séoul", "Corée du Sud", "37.583328", "127.0"));
                MainActivity.cities.add(new City("2673722", "Stockholm", "Suède", "59.5", "18.0"));
                MainActivity.cities.add(new City("4140963", "Washington, DC", "Etats-Unis", "38.895111", "-77.036369"));
            }
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