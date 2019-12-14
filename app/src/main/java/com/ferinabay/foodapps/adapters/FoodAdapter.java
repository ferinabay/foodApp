package com.ferinabay.foodapps.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ferinabay.foodapps.DetailFoodActivity;
import com.ferinabay.foodapps.R;
import com.ferinabay.foodapps.models.Food;

import java.util.List;

public class FoodAdapter extends
        RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foods;
    private Context context;

    public OnAdapterClickListener getListener() {
        return listener;
    }

    public static void setListener(OnAdapterClickListener listener) {
        listener = listener;
    }

    OnAdapterClickListener listener;

    public interface OnAdapterClickListener {
        void onClick(Food food);
    }

    public FoodAdapter(List<Food> foods, Context context) {
        this(foods,context,null);
    }

    public FoodAdapter(List<Food> foods, Context context, OnAdapterClickListener listener) {
        this.foods = foods;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.rv_item_food, parent, false);
        return new FoodViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        Food food = foods.get(position);
        holder.nameText.setText(food.getName());
        holder.hargaText.setText(food.getHarga());
        if(food.getKategori()=='f'){
            holder.img.setImageResource(R.drawable.groceries);
        } else {
            holder.img.setImageResource(R.drawable.champagne);
        }
        if(food.getFav()=='y'){
            holder.img2.setImageResource(R.drawable.star_color);
        } else {
            holder.img2.setImageResource(R.drawable.star_nocolor);
        }

    }

    @Override
    public int getItemCount() {
        return (foods != null) ? foods.size() : 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView hargaText;
        TextView deskripsiText;
        ImageView img;
        ImageView img2;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.text_namefood);
            hargaText = itemView.findViewById(R.id.text_harga);
            deskripsiText = itemView.findViewById(R.id.text_deskripsi);
            img = (ImageView) itemView.findViewById(R.id.iconFood);
            img2 = (ImageView) itemView.findViewById(R.id.iconFav);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Food food = foods.get(getAdapterPosition());

                    Intent intent = new Intent(context, DetailFoodActivity.class);

                    intent.putExtra("data_nama", nameText.getText().toString());
                    intent.putExtra("data_harga", hargaText.getText().toString());
                    intent.putExtra("data_deskripsi", deskripsiText.getText().toString());

                    if (food.getKategori() == 'f'){
                        intent.putExtra("pesan_img", R.drawable.groceries);
                    }else{
                        intent.putExtra("pesan_img", R.drawable.champagne);
                    }
                    context.startActivity(intent);

                }
            });
        }
    }
}
