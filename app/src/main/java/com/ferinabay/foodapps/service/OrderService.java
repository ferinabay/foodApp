package com.ferinabay.foodapps.service;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ferinabay.foodapps.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

@Dao
public interface OrderService {

//    @GET("ferinabay/dbOrderFood/orders")
//    Call<List<Order>> getOrder();

    @Insert
    void InsertLogOrders(Order order);

    @Query("Select * from log_order")
    public LiveData<List<Order>> GetAllLogOrder();
}
