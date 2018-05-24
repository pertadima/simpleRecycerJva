package com.example.irfan.layouting.section.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.irfan.layouting.MainApp;
import com.example.irfan.layouting.R;
import com.example.irfan.layouting.data.database.DaoSession;
import com.example.irfan.layouting.data.database.Produk;
import com.example.irfan.layouting.section.detail.DetailActivity;
import com.example.irfan.layouting.section.home.adapter.ProdukAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment implements ProdukAdapter.ItemListener, FragmentAddProduk.ProdukAddCallback {
    View layout;
    private List<Produk> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProdukAdapter produkAdapter;
    private FloatingActionButton addButton;
    private FragmentAddProduk fragmentAddProduk;
    private DaoSession daoSession;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = layout.findViewById(R.id.recyclerView);
        addButton = layout.findViewById(R.id.add);

        produkAdapter = new ProdukAdapter(list, getContext(), this);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        daoSession = ((MainApp) getActivity().getApplication()).getDaoSession(); // akses singleton

        list = new ArrayList<>();
        list = daoSession.getProdukDao().loadAll(); //memuat database

        produkAdapter.updateProdukList(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(produkAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Produk produk = produkAdapter.getProdukList().get(position);
        fragmentAddProduk = FragmentAddProduk.newInstance(false, produk.getId(), produk.getJudul(), String.valueOf(produk.getHarga()));
        fragmentAddProduk.setTargetFragment(this, 1);

        if (!fragmentAddProduk.isVisible()) {
            fragmentAddProduk.show(getFragmentManager(), fragmentAddProduk.getTag());
        }
    }

    public void showDialog() {
        fragmentAddProduk = FragmentAddProduk.newInstance(true, null, "", "");
        fragmentAddProduk.setTargetFragment(this, 1);

        if (!fragmentAddProduk.isVisible()) {
            fragmentAddProduk.show(getActivity().getSupportFragmentManager(), fragmentAddProduk.getTag());
        }
    }

    @Override
    public void onSaveClick(Produk produk) {
        daoSession.getProdukDao().insert(produk); //menambahkan data
        produkAdapter.updateProdukList(
                daoSession.getProdukDao().loadAll()
        );
    }

    @Override
    public void onUpdateClick(Long id, String name, double price) {
        for (Produk produk : daoSession.getProdukDao().loadAll()) {
            if (id.equals(produk.getId())) {
                produk.setJudul(name);
                produk.setHarga(price);
                daoSession.getProdukDao().update(produk); //modify data
                produkAdapter.updateProdukList(
                        daoSession.getProdukDao().loadAll()
                );
                break;
            }
        }
    }

    @Override
    public void onDeleteClick(Long id) {
        for (Produk produk : daoSession.getProdukDao().loadAll()) {
            if (id.equals(produk.getId())) {
                daoSession.getProdukDao().delete(produk); //menghapus data
                produkAdapter.updateProdukList(
                        daoSession.getProdukDao().loadAll()
                );
                break;
            }
        }
    }
}
