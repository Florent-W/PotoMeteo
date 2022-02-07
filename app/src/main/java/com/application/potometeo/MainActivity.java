package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.os.StrictMode;

public class MainActivity extends AppCompatActivity {

    public static List<City> cities = new ArrayList<>();
    private DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /* NECESSAIRE POUR FAIRE LES REQUETES NE PAS RETIRER */
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        /* ------------------------------------------------- */
        City c = db.getCity();
        Intent intent;
        if (c == null) {
            cities.add(new City("2759794", "Amsterdam", "Pays-Bas", "52.374031", "4.88969"));
            cities.add(new City("264371", "Athènes", "Grèce", "37.97945", "23.716221"));
            cities.add(new City("2950158", "Berlin", "Allemagne", "54.033329", "10.45"));
            cities.add(new City("2800866", "Bruxelles", "Belgique", "50.853321", "4.35144"));
            cities.add(new City("2618425", "Copenhague", "Danemark", "55.675941", "12.56553"));
            cities.add(new City("2964574", "Dublin", "Irlande", "53.34399", "-6.26719"));
            cities.add(new City("2643743", "Londres", "Angleterre", "51.50853", "-0.12574"));
            cities.add(new City("3117735", "Madrid", "Espagne", "40.4165", "-3.70256"));
            cities.add(new City("2995469", "Marseille", "France", "43.296951", "5.38107"));
            cities.add(new City("3996063", "Mexico", "Mexique", "23.0", "-102.0"));
            cities.add(new City("524894", "Moscou", "Russie", "55.761665", "37.606667"));
            cities.add(new City("2989204", "Orsay", "France", "48.695721", "2.18727"));
            cities.add(new City("2968815", "Paris", "France", "48.853401", "2.3486"));
            cities.add(new City("1816670", "Pékin", "Chine", "39.907501", "116.397232"));
            cities.add(new City("964137", "Pretoria", "Afrique du Sud", "-25.74486", "28.18783"));
            cities.add(new City("3169070", "Rome", "Italie", "41.894741", "12.4839"));
            cities.add(new City("1835847", "Séoul", "Corée du Sud", "37.583328", "127.0"));
            cities.add(new City("2673722", "Stockholm", "Suède", "59.5", "18.0"));
            cities.add(new City("4140963", "Washington, DC", "Etats-Unis", "38.895111", "-77.036369"));
            intent = new Intent(this, StartActivity.class);
        } else {
            intent = new Intent(this, HomeActivity.class);
            intent.putExtra("city", c.getName());
            intent.putExtra("country", c.getCountry());
            intent.putExtra("lat", c.getLat());
            intent.putExtra("lon", c.getLon());
        }
        startActivity(intent);
    }
}