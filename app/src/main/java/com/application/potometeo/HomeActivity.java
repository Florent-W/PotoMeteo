package com.application.potometeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    /*public void ParamClicked(View view) {

        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);

    }
    public void InventoryClicked(View view) {

        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);

    }*/
}