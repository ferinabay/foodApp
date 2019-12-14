package com.ferinabay.foodapps.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ferinabay.foodapps.Repository.OrdersRepository;
import com.ferinabay.foodapps.models.Order;

import java.util.List;

public class OrdersViewModel extends AndroidViewModel
{
        private OrdersRepository mOrderRepository;
    private LiveData<List<Order>> listLogCalories;
    private OrdersViewModel logOrdersViewModel;


    public OrdersViewModel(@NonNull Application application) {
        super(application);
        mOrderRepository = new OrdersRepository(application);
    }

    public LiveData<List<Order>> GetListOrders() {
        return this.mOrderRepository.GetAllOrder();
    }

    public void InsertLogCalories(Order order){
        mOrderRepository.InsertOrders(order);
    }
}
