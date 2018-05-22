package com.example.irfan.layouting.section.categories;

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
import com.example.irfan.layouting.data.CategoriesModel;
import com.example.irfan.layouting.section.categories.adapter.CategoriesAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategories extends Fragment implements CategoriesAdapter.ItemListener{
    View layout;
    private List<CategoriesModel> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_categories, container, false);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = layout.findViewById(R.id.recycler);
        categoriesAdapter = new CategoriesAdapter(list, getContext(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoriesAdapter);

        masukkanData();
    }

    private void masukkanData() {
        list.clear();
        CategoriesModel categoriesModel = new CategoriesModel ("Hat");
        list.add(categoriesModel);


        categoriesModel =  new CategoriesModel ("Top");
        list.add(categoriesModel);


        categoriesModel = new CategoriesModel ("Pants");
        list.add(categoriesModel);


        categoriesModel = new CategoriesModel ("Shoes");
        list.add(categoriesModel);

        categoriesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

    }
}
