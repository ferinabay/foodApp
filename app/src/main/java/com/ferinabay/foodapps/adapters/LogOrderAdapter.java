package com.ferinabay.foodapps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ferinabay.foodapps.R;
import com.ferinabay.foodapps.models.Order;

import java.util.List;

public class LogOrderAdapter extends RecyclerView.Adapter<LogOrderAdapter.MyViewHolder> {

    private final LayoutInflater mInflater;
    private List<Order> mLogOrderEntities;

    public LogOrderAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void SetListLogOrder(List<Order> logOrderEntities){
        mLogOrderEntities = logOrderEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView =mInflater.inflate(R.layout.item_log_orders,parent,false);
        return  new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Order order = mLogOrderEntities.get(position);
        holder.tvKategori.setText(order.getKategori());
        holder.tvNama.setText(order.getNama());
        holder.tvJumlah.setText(order.getJumlah());
        holder.tvTanggal.setText(order.getTglorder());
    }

    @Override
    public int getItemCount() {
        return mLogOrderEntities==null? 0:mLogOrderEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvKategori, tvNama, tvJumlah, tvTanggal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            tvNama = itemView.findViewById(R.id.tvFoodName);
            tvJumlah= itemView.findViewById(R.id.tvJumlah);
            tvTanggal = itemView.findViewById(R.id.tvTanggalOrder);
        }
    }
}
