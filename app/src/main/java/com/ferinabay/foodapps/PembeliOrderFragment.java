package com.ferinabay.foodapps;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.ferinabay.foodapps.adapters.LogOrderAdapter;
import com.ferinabay.foodapps.models.Order;
import com.ferinabay.foodapps.viewModel.OrdersViewModel;


public class PembeliOrderFragment extends Fragment {

    private Spinner spinnerKategori;
    private EditText editTextNama;
    private EditText editTextTanggalPesan;
    private EditText editTextJumlahPesan;
    private Button mButtonSaveOrder;

    private OrdersViewModel ordersViewModel;

    private RecyclerView mRecyclerOrders;
    private LogOrderAdapter adapterLogOrder;
    private String date;

    public static PembeliOrderFragment newInstance() {
        PembeliOrderFragment fragment = new PembeliOrderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_pembeli_order, container, false);
        initiateComponent(mView);
        return mView;
    }

    private void initiateComponent(View mView) {
        spinnerKategori = mView.findViewById(R.id.spinnerKategori);
        editTextNama = mView.findViewById(R.id.edt_txt_nama);
        editTextTanggalPesan = mView.findViewById(R.id.edt_tanggal_pesan);
        editTextJumlahPesan = mView.findViewById(R.id.edt_jumlah_pesan);
        mButtonSaveOrder = mView.findViewById(R.id.btn_ordermkn);

        mButtonSaveOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mView) {
                String kategori = spinnerKategori.getSelectedItem().toString();
                String nama = editTextNama.getText().toString();
                String tanggal_pesan = editTextTanggalPesan.getText().toString();
                String jmlhpesan = editTextJumlahPesan.getText().toString();
                String tanggal = date;

                if (Validation(nama, tanggal_pesan, jmlhpesan)) {
                    //Todo 6 Memanggil method yang ada di viem model untuk menginsert Db

                    ordersViewModel = ViewModelProviders.of(getActivity()).get(OrdersViewModel.class);

                    Order order = new Order(nama, tanggal_pesan, jmlhpesan, kategori);
                    //Code yang ditambahkan
                    ordersViewModel.InsertLogCalories(order);

                    DialogSave(mView, "Tersimpan!!", "Data Berhasil Disimpan. Apakah Anda Akan Memasukkan Data Lagi?");
                } else {
                    new AlertDialog.Builder(mView.getContext())
                            .setTitle("Attention!!")
                            .setMessage("Pastikan Semua Data Terisi")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).show();
                }

            }
        });
    }

    private boolean Validation(String nama, String tanggal_pesan, String jmlhpesan) {
        if ((nama.trim().length() > 0) && (tanggal_pesan.trim().length() > 0) && (jmlhpesan.trim().length() > 0)) {
            return true;
        } else return false;
    }

    private void DialogSave(View mView, String title, String message) {
        new AlertDialog.Builder(mView.getContext())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Tambah Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        spinnerKategori.setSelection(0);
                        editTextNama.setText("");
                        editTextTanggalPesan.setText("");
                        editTextJumlahPesan.setText("");
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentManager.replace(R.id.fragment_container, new OrderListFragment())
                        .addToBackStack(null)
                        .commit();
            }
        })
                .show();
    }
}
