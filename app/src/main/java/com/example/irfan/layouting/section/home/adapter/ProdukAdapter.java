package com.example.irfan.layouting.section.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irfan.layouting.R;
import com.example.irfan.layouting.data.ProdukModel;

import java.util.List;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.MyViewHolder> {
    private List<ProdukModel> produkModels;
    private ItemListener itemListener;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View rootView;
        public TextView judul, harga;
        public ImageView gambar;

        private ItemListener itemListener;

        public MyViewHolder(View itemView, final ItemListener itemListener) {
            super(itemView);
            this.rootView = itemView;
            judul = itemView.findViewById(R.id.textView);
            harga = itemView.findViewById(R.id.textView2);
            rootView.setOnClickListener(this);
            this.itemListener = itemListener;
        }

        @Override
        public void onClick(View v) {
            itemListener.onItemClick(getAdapterPosition());
        }
    }

    public ProdukAdapter(List<ProdukModel> produkModelList, Context context, ItemListener listener) {
        this.produkModels = produkModelList;
        this.context = context;
        itemListener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyViewHolder(itemView, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProdukModel produkModel = produkModels.get(position);
        holder.judul.setText(produkModel.getJudul());
        holder.harga.setText(String.valueOf(produkModel.getHarga()));


    }


    @Override
    public int getItemCount() {
        return produkModels.size();
    }

    public List<ProdukModel> getProdukList() {
        return produkModels;
    }

    public interface ItemListener {
        void onItemClick(int position);
    }
}
