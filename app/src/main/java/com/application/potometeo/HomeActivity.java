package com.application.potometeo; /**/

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Context context;
    private ConstraintLayout ll;
    private TextView tv1;
    private TextView tv2;
    private ImageView potoImg;
    private String temperature;
    private String city;
    private String country;
    private String lat;
    private String lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle extras = getIntent().getExtras();
        context = getApplicationContext();
        ll = findViewById(R.id.ActivityHome);
        tv1 = findViewById(R.id.tempText);
        tv2 = findViewById(R.id.nomVille);
        potoImg = findViewById(R.id.potoImg);
        if (extras != null) {
            city = extras.getString("city");
            country = extras.getString("country");
            lat = extras.getString("lat");
            lon = extras.getString("lon");
        }
        temperature = new WeatherRequest().getTemperature(lat, lon);
        if (temperature != null) {
            tv1.setText(temperature + "°C");
            tv2.setText(city + ", " + country);
            double t = Double.parseDouble(temperature);
            if (t < 10) {
                ll.setBackgroundResource(R.drawable.cold);
                ll.setContentDescription("un forêt enneigé");
            } else if (t > 25) {
                ll.setBackgroundResource(R.drawable.hot);
                ll.setContentDescription("un thermomètre géant");
            } else {
                ll.setBackgroundResource(R.drawable.mid);
                ll.setContentDescription("un beau ciel bleu parsemé de nuages");
            }
        }
        String imgLink = new DBHelper(context).getPotoLink();
        String imgName = new DBHelper(context).getPotoImg();
        if (imgLink == null) {
            imgLink = InventoryActivity.d.getLinkImg();
        }
        if (imgName == null) {
            imgName = InventoryActivity.d.getNameImg();
        }
        potoImg.setImageResource(this.getDrawableResIdByName(imgLink));
        potoImg.setContentDescription("la mascotte poto porte une " + imgName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        potoImg.setImageResource(this.getDrawableResIdByName(InventoryActivity.d.getLinkImg()));
        potoImg.setContentDescription("la mascotte poto porte une " + InventoryActivity.d.getNameImg());
    }

    public int getDrawableResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("HomeActivity", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    public void ParamClicked(View view) {
        Intent intent1 = new Intent(this, SettingsActivity.class);
        startActivity(intent1);
    }

    public void InventoryClicked(View view) {
        Intent intent2 = new Intent(this, InventoryActivity.class);
        startActivity(intent2);
    }

    public void OtherCityClicked(View view) {
        Intent intent3 = new Intent(this, StartActivity.class);
        startActivity(intent3);
    }
}