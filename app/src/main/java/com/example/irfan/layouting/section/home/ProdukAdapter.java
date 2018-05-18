package com.example.irfan.layouting.section.home;

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

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView judul, harga;
        public ImageView gambar;

        public MyViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.textView);
            harga = itemView.findViewById(R.id.textView2);

        }
    }

    ProdukAdapter(List<ProdukModel> produkModelList)
    {
        this.produkModels = produkModelList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyViewHolder(itemView);
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
}
