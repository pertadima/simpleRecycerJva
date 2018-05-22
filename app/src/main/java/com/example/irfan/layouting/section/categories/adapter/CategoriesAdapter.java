package com.example.irfan.layouting.section.categories.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.irfan.layouting.R;
import com.example.irfan.layouting.data.CategoriesModel;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {
    private List<CategoriesModel> categoriesModels;
    private ItemListener itemListener;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View rootView;
        public TextView kategori;

        private ItemListener itemListener;

        public MyViewHolder(View itemView, final ItemListener itemListener) {
            super(itemView);
            this.rootView = itemView;
            kategori = itemView.findViewById(R.id.txt_kategori);
            rootView.setOnClickListener(this);
            this.itemListener = itemListener;
        }

        @Override
        public void onClick(View v) {
            itemListener.onItemClick(getAdapterPosition());
        }
    }

    public CategoriesAdapter(List<CategoriesModel> categoriesModelList, Context context, ItemListener listener) {
        this.categoriesModels = categoriesModelList;
        this.context = context;
        itemListener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categories, parent, false);

        return new MyViewHolder(itemView, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CategoriesModel categoriesModel = categoriesModels.get(position);
        holder.kategori.setText(categoriesModel.getKategori());
    }


    @Override
    public int getItemCount() {
        return categoriesModels.size();
    }

    public List<CategoriesModel> getProdukList() {
        return categoriesModels;
    }

    public interface ItemListener {
        void onItemClick(int position);
    }
}
