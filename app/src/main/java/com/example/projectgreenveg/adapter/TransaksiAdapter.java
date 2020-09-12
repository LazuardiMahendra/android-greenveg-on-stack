package com.example.projectgreenveg.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectgreenveg.Helper.ImageConverter;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.model.Produk;

import java.util.List;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.ViewHolder> {
    private List<Produk> listTransaksi;

    private OnClickListenerTransaksi listenerTransaksi;


    public TransaksiAdapter(List<Produk> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_transaksi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiAdapter.ViewHolder holder, int position) {
        Produk produk = listTransaksi.get(position);

        holder.tvNama.setText(produk.getNama());
        holder.tvHarga.setText(produk.getHarga().toString());
        holder.ivGambar.setImageBitmap(ImageConverter.toImage(produk.getPhoto()));

    }

    @Override
    public int getItemCount() {
        return listTransaksi.size();
    }

    public Produk getTransaksiAt(int position) {
        return listTransaksi.get(position);
    }

    // holder awal

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        ImageView ivGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama_barang);
            tvHarga = itemView.findViewById(R.id.tv_item_harga_barang);
            ivGambar = itemView.findViewById(R.id.iv_gambar_barang);



            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                        listenerTransaksi.onClickTransaksi(listTransaksi.get(position));
                }
            }));

        }

    }

    public interface OnClickListenerTransaksi {
        void onClickTransaksi(Produk produk);
    }

    public void setOnClickListenerTransaksi(OnClickListenerTransaksi listenerTransaksi) {
        this.listenerTransaksi = listenerTransaksi;
    }
}




