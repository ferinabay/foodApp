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

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private Context context;
    private List<Order> orders;
    private OnOrderClickedListener listener;

    public interface OnOrderClickedListener {
        void onOrderClicked(Order order);
    }

    public OrdersAdapter(Context context, OnOrderClickedListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);
        // TODO: Bind object calory dengan holder
        holder.nameText.setText(order.getNama());
        holder.jumlahText.setText(order.getJumlah());
        holder.tglorderText.setText(order.getTglorder());
        holder.kategoriText.setText(order.getKategori());
        holder.bind(order, listener);
    }

    @Override
    public int getItemCount() {
        return (orders != null) ? orders.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView jumlahText;
        TextView tglorderText;
        TextView kategoriText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.tv_nama);
            jumlahText = itemView.findViewById(R.id.tv_jumlah);
            tglorderText = itemView.findViewById(R.id.tv_tglorder);
            kategoriText = itemView.findViewById(R.id.tv_kategori);
        }
        public void bind(final Order order, final OnOrderClickedListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onOrderClicked(order);
                }
            });
        }
    }
}
