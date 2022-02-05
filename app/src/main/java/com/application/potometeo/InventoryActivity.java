package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        List<Display> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomGridAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener((a, v, position, id) -> {
            Object o = gridView.getItemAtPosition(position);
            Display country = (Display) o;
            Toast.makeText(InventoryActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
        });
    }

    private List<Display> getListData() {
        List<Display> list = new ArrayList<Display>();
        Display Poto_Bleu = new Display("Poto Bleu", "bleu", "Oui");
        Display Poto_Violet = new Display("Poto Violet", "violet", "Oui");
        Display Poto_Jaune = new Display("Poto Jaune", "jaune", "Oui");
        Display Poto_Vert = new Display("Poto Vert", "vert", "Oui");
        Display Poto_Rose = new Display("Poto Violet", "vert", "Oui");
        Display Poto_Noir = new Display("Poto Violet", "vert", "Oui");
        Display Poto_Blanc = new Display("Poto Violet", "vert", "Oui");
        Display Poto_Marron = new Display("Poto Violet", "vert", "Oui");

        list.add(Poto_Bleu);
        list.add(Poto_Violet);
        list.add(Poto_Jaune);
        list.add(Poto_Vert);
        list.add(Poto_Rose);
        list.add(Poto_Noir);
        list.add(Poto_Blanc);
        list.add(Poto_Marron);

        return list;
    }

}