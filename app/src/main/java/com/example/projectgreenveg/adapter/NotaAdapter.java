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
import com.example.projectgreenveg.model.Nota;
import com.example.projectgreenveg.model.Produk;

import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private List<Nota> listNota;

    private OnClickListenerNota listenerNota;


    public NotaAdapter(List<Nota> listNota) {
        this.listNota = listNota;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_transaksi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.ViewHolder holder, int position) {
        Nota nota = listNota.get(position);

//        holder.tvNama.setText(nota.getNama());
//        holder.tvHarga.setText(nota.getHarga().toString());
//        holder.ivGambar.setImageBitmap(ImageConverter.toImage(produk.getPhoto()));

    }

    @Override
    public int getItemCount() {
        return listNota.size();
    }

    public Nota getNotaAt(int position) {
        return listNota.get(position);
    }

    // holder awal

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        ImageView ivGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvNama = itemView.findViewById(R.id.tv_item_nama_barang);
//            tvHarga = itemView.findViewById(R.id.tv_item_harga_barang);
//            ivGambar = itemView.findViewById(R.id.iv_gambar_barang);



            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                        listenerNota.onClickNota(listNota.get(position));
                }
            }));

        }

    }

    public interface OnClickListenerNota {
        void onClickNota(Nota nota);
    }

    public void setOnClickListenerNota(OnClickListenerNota listenerNota) {
        this.listenerNota = listenerNota;
    }
}




