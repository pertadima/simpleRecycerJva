package com.example.irfan.layouting.section.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.irfan.layouting.R;
import com.example.irfan.layouting.data.ProdukModel;
import com.example.irfan.layouting.section.detail.DetailActivity;
import com.example.irfan.layouting.section.home.adapter.ProdukAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment implements ProdukAdapter.ItemListener {
    View layout;
    private List<ProdukModel> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProdukAdapter produkAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = layout.findViewById(R.id.recyclerView);

        produkAdapter = new ProdukAdapter(list,getContext(),this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(produkAdapter);

        masukkanData();
    }

    private void masukkanData() {
        ProdukModel produkModel = new ProdukModel("", "Pure White Water", 14.50);
        list.add(produkModel);


        produkModel = new ProdukModel("", "dsadsadasdas", 12.00);
        list.add(produkModel);


        produkModel = new ProdukModel("", "dsadsadasdadasdsadas", 12.00);
        list.add(produkModel);


        produkModel = new ProdukModel("", "d1111dasdsadas", 12.00);
        list.add(produkModel);

        produkAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        ProdukModel produkModel = produkAdapter.getProdukList().get(position);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("produk", produkModel);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
