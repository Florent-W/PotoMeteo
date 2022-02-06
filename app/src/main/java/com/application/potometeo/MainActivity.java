package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.os.StrictMode;

public class MainActivity extends AppCompatActivity {

    public static List<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /* NECESSAIRE POUR FAIRE LES REQUETES NE PAS RETIRER */
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        /* ------------------------------------------------- */
        cities.add(new City("2968815", "Paris", "France", "48.853401", "2.3486"));
        cities.add(new City("4140963", "Washington, DC", "Etats-Unis", "38.895111", "-77.036369"));
        cities.add(new City("2759794", "Amsterdam", "Pays-Bas", "52.374031", "4.88969"));
        cities.add(new City("3451189", "Rio de Janeiro", "Brézil", "-22", "-42.5"));
        cities.add(new City("524894", "Moscou", "Russie", "55.761665", "37.606667"));
        cities.add(new City("2643743", "Londres", "Angleterre", "51.50853", "-0.12574"));
        cities.add(new City("3169070", "Rome", "Italie", "41.894741", "12.4839"));
        cities.add(new City("1816670", "Pékin", "Chine", "39.907501", "116.397232"));
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}