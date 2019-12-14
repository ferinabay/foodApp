package com.ferinabay.foodapps;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ferinabay.foodapps.adapters.OrdersAdapter;
import com.ferinabay.foodapps.models.Order;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment implements OrdersAdapter.OnOrderClickedListener {

    private TextView orderText;
    private OrdersAdapter ordersAdapter;
    private RecyclerView orderView;
    private OnFragmentInteractionListener mListener;

    public OrderFragment() {
        // Required empty public constructor
    }

    public static OrderFragment newInstance() {
        OrderFragment fragment = new OrderFragment();
        return fragment;
    }

    public interface OnFragmentInteractionListener {
        void onOrderFragmentCreated(final View view, final OrdersAdapter adapter, final TextView orderText);
//        void onAddOrderButtonClicked();
        void onOrderClicked(Order order);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
//        profile = Application.provideProfile();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        Context context = getActivity();

        orderView = view.findViewById(R.id.rv_orders);

        // setup recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        ordersAdapter = new OrdersAdapter(context, this);
        orderView.setLayoutManager(layoutManager);
        orderView.setAdapter(ordersAdapter);

        if (mListener != null) {
            mListener.onOrderFragmentCreated(getView(), ordersAdapter, orderText);

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onOrderClicked(Order order) {
        if (mListener != null) {
            mListener.onOrderClicked(order);
        }
    }


}
