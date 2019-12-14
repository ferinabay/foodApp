package com.ferinabay.foodapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuAwalActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_awal);
    }

    public void launchPembeli(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void launchPelayan(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainPenjualActivity.class);
        startActivity(intent);
    }
}
