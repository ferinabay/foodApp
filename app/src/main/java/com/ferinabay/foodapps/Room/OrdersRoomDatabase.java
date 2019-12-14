package com.ferinabay.foodapps.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ferinabay.foodapps.models.Order;
import com.ferinabay.foodapps.service.OrderService;

@Database(entities = {Order.class}, version = 2 , exportSchema = false)
public abstract class OrdersRoomDatabase extends RoomDatabase
{
    private  static  OrdersRoomDatabase Instance;
    private static final String DATABASE_NAME = "OrdersDatabase";

    public abstract OrderService logOrdersDao();

    public static OrdersRoomDatabase GetDatabase(Context context) {
        if(Instance == null){
            synchronized (OrdersRoomDatabase.class) {
                if (Instance == null) {
                    Instance = Room.databaseBuilder(context, OrdersRoomDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return Instance;
    }
}
