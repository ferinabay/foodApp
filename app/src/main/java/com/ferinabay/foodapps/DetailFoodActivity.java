package com.ferinabay.foodapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFoodActivity extends AppCompatActivity {

    String name, harga, deskripsi, img;
    ImageView pict;
    TextView ViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        ViewData = (TextView) findViewById(R.id.tv_content);
        pict = (ImageView) findViewById(R.id.imgFood);

        Intent intent = getIntent();

        name = intent.getStringExtra("data_nama");
        harga = intent.getStringExtra("data_harga");
        deskripsi = intent.getStringExtra("data_deskripsi");
        img = intent.getStringExtra("pesan_img");

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null){
            int resid = bundle.getInt("pesan_img");
            pict.setImageResource(resid);
        }
        ViewData.setText(String.format("Nama Makanan : %s\nHarga : %s\nDeskripsi : %s", name, harga, deskripsi));
    }
}
