package com.ferinabay.foodapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ferinabay.foodapps.adapters.FoodAdapter;
import com.ferinabay.foodapps.models.Food;

import java.util.ArrayList;
import java.util.List;

public class ListFoodActivity extends AppCompatActivity implements FoodAdapter.OnAdapterClickListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);

        recyclerView = findViewById(R.id.rv_food);

        List<Food> students = new ArrayList<>();
        students.add(new Food("Es Degan", "Rp. 10.000,00","Dengan wadah kelapa asli",'d', 'y'));
        students.add(new Food("Banana Smoothies", "Rp. 22.000,00","Paduan Fresh Banana dan Yogurt",'d','y'));
        students.add(new Food("Jus Buah Naga", "Rp. 14.000,00","Dari Buah Naga dengan daging berwarna putih",'d', 't'));
        students.add(new Food("Lalapan Ayam", "Rp. 15.000,00", "Tersedia potongan ayam bagian paha/dada dengan bumbu kuning",'f','t'));
        students.add(new Food("Es Teh Manis", "Rp. 5.000,00", "Tersedia dengan gelas medium",'d','t'));
        students.add(new Food("Pizza Combo", "Rp. 80.000,00", "Dengan diameter 28cm dan potongan beef, paprika dan mashroom",'f','t'));
        students.add(new Food("Chicken Burger", "Rp. 23.000,00", "Dengan ukuran medium dan isian yang fresh",'f','t'));
        students.add(new Food("Orange Squash", "Rp. 18.000,00", "Tersedia dengan gelas small dengan kesegaran jeruk asli",'d','t'));
        students.add(new Food("Nasi Goreng", "Rp. 14.000,00", "Terdapat potongan ayam, sayuran dan telur",'f','t'));
        students.add(new Food("Martabak Asin", "Rp. 38.000,00", "Terserdia pilihan menu isian ayam dan beef",'f','t'));
        students.add(new Food("Es Beras Kencur", "Rp. 10.000,00", "Tersedia dengan gelas medium",'d','t'));
        students.add(new Food("Capjay Goreng", "Rp. 20.000,00", "Terdiri dari potongan sayuran yang segar",'f','t'));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        FoodAdapter studentAdapter = new FoodAdapter(students,this);
        FoodAdapter.setListener(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);
    }


    @Override
    public void onClick(Food food) {
        Toast.makeText(this,food.getName(), Toast.LENGTH_SHORT)
                .show();
        Log.i(ListFoodActivity.class.getSimpleName(), food.getName());
    }
}
