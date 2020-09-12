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
import com.example.projectgreenveg.model.Keranjang;
import com.example.projectgreenveg.model.Produk;

import java.util.List;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.ViewHolder>{
    private List<Keranjang> listKeranjang;

    private KeranjangAdapter.OnClickListenerKeranjang listenerKeranjang;

    public KeranjangAdapter(List<Keranjang> listKeranjang) {
        this.listKeranjang = listKeranjang;
    }


    @NonNull
    @Override
    public KeranjangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_transaksi, parent, false);
        return new KeranjangAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangAdapter.ViewHolder holder, int position) {
        Keranjang keranjang = listKeranjang.get(position);

        holder.tvNama.setText(keranjang.getNama_produk());
        holder.tvHarga.setText(keranjang.getHarga().toString());
        holder.ivGambar.setImageBitmap(ImageConverter.toImage(keranjang.getPhoto()));

    }

    @Override
    public int getItemCount() {
        return listKeranjang.size();
    }

    public Keranjang getKeranjangAt(int position) {
        return listKeranjang.get(position);
    }

    // holder awal

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga,tvJumlah;
        ImageView ivGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama_barang);
            tvHarga = itemView.findViewById(R.id.tv_item_harga_barang);
            ivGambar = itemView.findViewById(R.id.iv_gambar_barang);
            tvJumlah    = itemView.findViewById(R.id.iv_Cartgambar_barang);



            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listenerKeranjang.onClickKeranjang(listKeranjang.get(position));
                }
            }));

        }

    }

    public interface OnClickListenerKeranjang {
        void onClickKeranjang(Keranjang keranjang);
    }

    public void setOnClickListenerKeranjang(KeranjangAdapter.OnClickListenerKeranjang listenerKeranjang) {
        this.listenerKeranjang = listenerKeranjang;
    }
}
