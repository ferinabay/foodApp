package com.ferinabay.foodapps.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ferinabay.foodapps.Room.OrdersRoomDatabase;
import com.ferinabay.foodapps.models.Order;
import com.ferinabay.foodapps.service.OrderService;

import java.util.List;

public class OrdersRepository {

    private OrdersRoomDatabase ordersRoomDatabase;
    private  static OrderService logOrdersDao;

    public OrdersRepository(Context context) {
        ordersRoomDatabase = OrdersRoomDatabase.GetDatabase(context);
        logOrdersDao = ordersRoomDatabase.logOrdersDao();
    }

    public void InsertOrders(Order order){
        new InsertOrdersAsynTask().execute(order);
    }

    public class InsertOrdersAsynTask extends AsyncTask<Order,Void,Void> {
        @Override
        protected Void doInBackground(Order... orders) {
            logOrdersDao.InsertLogOrders(orders[0]);
            return null;
        }
    }

    public LiveData<List<Order>> GetAllOrder(){
        return logOrdersDao.GetAllLogOrder();
    }
}
