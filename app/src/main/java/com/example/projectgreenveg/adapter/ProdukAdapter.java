package com.example.projectgreenveg.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectgreenveg.Helper.ImageConverter;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.controller.Produk.DetailProduk;
import com.example.projectgreenveg.model.Produk;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ViewHolder> {
    private List<Produk> listProduk;

    private OnClickListenerProduk listenerProduk;


    public ProdukAdapter(List<Produk> listProduk) {
        this.listProduk = listProduk;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukAdapter.ViewHolder holder, int position) {
        Produk produk = listProduk.get(position);

        holder.tvNama.setText(produk.getNama());
        holder.tvHarga.setText(produk.getHarga().toString());
        holder.ivGambar.setImageBitmap(ImageConverter.toImage(produk.getPhoto()));

    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    public Produk getProdukAt(int position) {
        return listProduk.get(position);
    }

    // holder awal

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        ImageView ivGambar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvHarga = itemView.findViewById(R.id.tv_item_harga);
            ivGambar = itemView.findViewById(R.id.iv_gambar_produk);



            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                        listenerProduk.onClickProduk(listProduk.get(position));
                }
            }));

        }

    }

    public interface OnClickListenerProduk {
        void onClickProduk(Produk produk);
    }

    public  void setOnClickListenerProduk(OnClickListenerProduk listenerProduk) {
        this.listenerProduk = listenerProduk;
    }
}




