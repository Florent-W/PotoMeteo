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