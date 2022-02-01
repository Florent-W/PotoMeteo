package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities.add(new City("2968815", "Paris", "France", "48.853401", "2.3486"));
        cities.add(new City("2989204", "Orsay", "France", "48.695721", "2.18727"));
       // cities.add(new City("4274994", "Manhattan", "Etats-Unis"));
        cities.add(new City("1850147", "Tokyo", "Japon", "35.689499", "139.691711"));
      //  cities.add(new City("3451189", "Rio de Janeiro", "Brésil"));
      //  cities.add(new City("2147714", "Sydney", "Australie"));
      //  cities.add(new City("498817", "Saint-Pétersbourg", "Russie", "59.894444", "30.264168"));
     //   cities.add(new City("3846616", "Londres", "Angleterre"));
      //  cities.add(new City("3169070", "Rome", "Italie"));
      //  cities.add(new City("1816670", "Pékin", "Chine"));


        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}