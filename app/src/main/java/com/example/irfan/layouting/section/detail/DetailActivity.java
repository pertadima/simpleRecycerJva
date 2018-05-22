package com.example.irfan.layouting.section.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.example.irfan.layouting.R;
import com.example.irfan.layouting.data.ProdukModel;

public class DetailActivity extends AppCompatActivity {
    Bundle bundle;
    ProdukModel produk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        bundle = getIntent().getExtras();
        if (bundle != null) {
            produk = bundle.getParcelable("produk");
            getSupportActionBar().setTitle(produk.getJudul());
        }


    }
}
