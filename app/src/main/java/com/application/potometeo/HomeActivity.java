package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class HomeActivity extends AppCompatActivity {
    int temperature;
    String var;
    String ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        temperature = 0;
        var = "0";
        ville = "Paris";
        Integer.parseInt(var);
        ConstraintLayout ll = findViewById(R.id.ActivityHome);
        TextView tv1 = (TextView)findViewById(R.id.temptextView);
        tv1.setText(var+"°C");
        TextView tv2 = (TextView)findViewById(R.id.nomVille);
        tv2.setText(ville);


        if (temperature<10){
            ll.setBackgroundResource(R.drawable.cold);
        }
        else if (temperature>25){
            ll.setBackgroundResource(R.drawable.hot);
        }
        else{
            ll.setBackgroundResource(R.drawable.mid);
        }
    }
    public void ParamClicked(View view) {

        Intent intent1 = new Intent(this, Bidon.class);
        startActivity(intent1);

    }
    public void InventoryClicked(View view) {

        Intent intent2 = new Intent(this, Bidon.class);
        startActivity(intent2);

    }
}