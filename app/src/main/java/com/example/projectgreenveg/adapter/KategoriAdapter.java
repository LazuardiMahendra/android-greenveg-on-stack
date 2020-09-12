package com.example.projectgreenveg.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.R;
import com.example.projectgreenveg.model.Kategori;
import com.example.projectgreenveg.model.Produk;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder>{
    private List<Kategori> listKategori;

    public KategoriAdapter(List<Kategori> list) {
        this.listKategori = list;
    }

    private OnClickListenerKat listenerKat;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_list_kategori, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Kategori kategori = listKategori.get(position);
        holder.tvId.setText(kategori.getId().toString());
        holder.tvNama.setText(kategori.getNama());
    }

    @Override
    public int getItemCount() {
        return listKategori.size();
    }

    public Kategori getKategoriAt(int position){
        return listKategori.get(position);
    }


    //Holder Awal

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_item_id);
            tvNama = itemView.findViewById(R.id.tv_item_nama);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listenerKat.onClickKat(listKategori.get(position));
                }
            });
        }
    }

    public  interface OnClickListenerKat{
        void onClickKat(Kategori kategori);
    }

    public void setOnClickListenerKat(OnClickListenerKat listenerKat) {
        this.listenerKat = listenerKat;
    }


}