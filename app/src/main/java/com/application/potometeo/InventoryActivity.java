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

    public static Display d = new Display("Poto Bleu", "bleu", "Disponible");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        List<Display> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomGridAdapter(this, image_details));
        // When the user clicks on the GridItem
        gridView.setOnItemClickListener((a, v, position, id) -> {
            d = (Display) gridView.getItemAtPosition(position);
            new DBHelper(getApplicationContext()).setPoto(d.getNameImg(), d.getLinkImg());
        });
    }

    private List<Display> getListData() {
        List<Display> list = new ArrayList<Display>();
        Display Poto_Bleu = new Display("chemise bleue", "bleu", "Obtenu");
        Display Poto_Violet = new Display("chemise violette", "violet", "Obtenu");
        Display Poto_Jaune = new Display("chemise jaune", "jaune", "Obtenu");
        Display Poto_Vert = new Display("chemise verte", "vert", "Obtenu");
        list.add(Poto_Bleu);
        list.add(Poto_Violet);
        list.add(Poto_Jaune);
        list.add(Poto_Vert);
        return list;
    }

}