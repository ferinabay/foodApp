package com.ferinabay.foodapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {

    private Button btnLoadFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        btnLoadFragment = this.findViewById(R.id.button_kontak);
    }

    public void loadKontakFragment(View view) {

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //memunculkan fragment di placeholder yg ada di view
        ft.replace(R.id.frameKontak, new KontakFragment());
//        ft.replace(R.id.framePlaceholder2, new FirstFragment());
        ft.commit();

    }
}
