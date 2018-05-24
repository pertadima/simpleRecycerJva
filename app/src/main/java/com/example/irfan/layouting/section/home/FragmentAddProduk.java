package com.example.irfan.layouting.section.home;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.irfan.layouting.R;
import com.example.irfan.layouting.data.database.Produk;

public class FragmentAddProduk extends DialogFragment {
    private View layout;

    private Button btnSave, btnDelete, btnUpdate;
    private EditText txtProduk, txtHarga;
    private Long id;
    private ProdukAddCallback callback;

    public static FragmentAddProduk newInstance(boolean isAdd, Long id, String produk, String harga) {

        Bundle args = new Bundle();
        args.putBoolean(IntentKey.IS_ADD, isAdd);
        if (null != id) {
            args.putLong(IntentKey.PRODUK_ID, id);
        }
        args.putString(IntentKey.PRODUK_NAME, produk);
        args.putString(IntentKey.PRODUK_PRICE, harga);
        FragmentAddProduk fragment = new FragmentAddProduk();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_dialog, container, false);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callback = (ProdukAddCallback) getTargetFragment();
        txtProduk = layout.findViewById(R.id.txt_produk);
        txtHarga = layout.findViewById(R.id.txt_harga);
        btnSave = layout.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onSaveClick(
                        new Produk(
                                null,
                                txtProduk.getText().toString(),
                                Double.parseDouble(txtHarga.getText().toString())
                        )
                );
                dismiss();
            }
        });
        btnDelete = layout.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onDeleteClick(id);
                dismiss();
            }
        });
        btnUpdate = layout.findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onUpdateClick(
                        id,
                        txtProduk.getText().toString(),
                        Double.parseDouble(txtHarga.getText().toString())
                );
                dismiss();
            }
        });

        Bundle bundle = getArguments();
        if (null != bundle) {
            String name = bundle.getString(IntentKey.PRODUK_NAME, "");
            txtProduk.setText(name);

            String gender = bundle.getString(IntentKey.PRODUK_PRICE, "");
            txtHarga.setText(gender);

            boolean isAdd = bundle.getBoolean(IntentKey.IS_ADD, false);

            btnDelete.setVisibility(
                    (isAdd) ? View.GONE : View.VISIBLE
            );

            btnUpdate.setVisibility(
                    (isAdd) ? View.GONE : View.VISIBLE
            );

            btnSave.setVisibility(
                    (isAdd) ? View.VISIBLE : View.GONE
            );

            Long _id = bundle.getLong(IntentKey.PRODUK_ID);
            if (null != _id) {
                this.id = _id;
            }
        }
    }


    public final class IntentKey {
        private IntentKey() {
        }

        public static final String IS_ADD = "FragmentAddProduk.IS_ADD";
        public static final String PRODUK_ID = "FragmentAddProduk.PRODUK_ID";
        public static final String PRODUK_NAME = "FragmentAddProduk.PRODUK_NAME";
        public static final String PRODUK_PRICE = "FragmentAddProduk.PRODUK_PRICE";
    }


    public interface ProdukAddCallback {
        void onSaveClick(Produk produk);

        void onUpdateClick(Long id, String name, double price);

        void onDeleteClick(Long id);
    }


}
