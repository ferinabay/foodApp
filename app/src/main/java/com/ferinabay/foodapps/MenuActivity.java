package com.ferinabay.foodapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
//    TextView ContactUs;
    private Button mButtonAddOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        ContactUs = findViewById(R.id.tv_contactus);
//
//        ContactUs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(LOG_TAG, "Button clicked!");
//                Intent intent = new Intent(this, ContactUsActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    public void launchListFood(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, ListFoodActivity.class);
        startActivity(intent);
    }

    public void launchOrderFood(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainPembeliOrderActivity.class);
        startActivity(intent);
//        mButtonAddOrder = findViewById(R.id.btn_order);
//        mButtonAddOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
//                fragmentManager.replace(R.id.fragment_container,new PembeliOrderFragment())
//
//                        .commit();
//            }
//        });
    }

    public void launchContactUs(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, ContactUsActivity.class);
        startActivity(intent);
    }
}
