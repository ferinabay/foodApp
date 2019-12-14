package com.ferinabay.foodapps;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ferinabay.foodapps.adapters.LogOrderAdapter;
import com.ferinabay.foodapps.models.Order;
import com.ferinabay.foodapps.viewModel.OrdersViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment {

    private OrdersViewModel ordersViewModel;
    private RecyclerView mRecyclerOrders;
    private Button mButtonAddFood;
    private LogOrderAdapter adapterLogOrder;
    private String date;

    public OrderListFragment() {
        // Required empty public constructor
    }

    public static OrderListFragment newInstance() {
        OrderListFragment fragment = new OrderListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_order_list, container, false);
        initiateComponent(mView);
        return mView;
    }

    private void initiateComponent(View mView) {
        mButtonAddFood = mView.findViewById(R.id.buttonAddFood);

        mRecyclerOrders = mView.findViewById(R.id.recyclerOrderList);
        mRecyclerOrders.setLayoutManager(new LinearLayoutManager(getActivity()));

        mButtonAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentManager.replace(R.id.fragment_container,new PembeliOrderFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        adapterLogOrder = new LogOrderAdapter(getActivity());
        mRecyclerOrders.setAdapter(adapterLogOrder);
        //Todo 7 Menggunakan View Model untuk Mengeset adapter
        ordersViewModel = ViewModelProviders.of(getActivity()).get(OrdersViewModel.class);
        ordersViewModel.GetListOrders().observe(getActivity(), new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> logOrderEntities) {
                adapterLogOrder.SetListLogOrder(logOrderEntities);
            }
        });
    }

}
