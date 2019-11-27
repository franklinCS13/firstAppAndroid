package com.proyecto.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.proyecto.myapplication.model.Chiste;
import java.util.List;

public class AdapterChistes extends RecyclerView.Adapter<AdapterChistes.ViewHolder> {

    private List<Chiste> chistes;
    private OnItemClickListener onItemClickListener;

    AdapterChistes(List<Chiste> listaChistes) {
        this.chistes = listaChistes;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);
        ViewHolder vh = new ViewHolder(vista);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final Chiste item = chistes.get(i);
        holder.imgChiste.setImageResource(item.getFoto());
        holder.txtTitulo.setText(item.getNombre());
        holder.itemView.setOnClickListener(view -> {
            if (AdapterChistes.this.onItemClickListener != null) {
                AdapterChistes.this.onItemClickListener.onChisteItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chistes != null ? chistes.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgChiste;
        TextView txtTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChiste = (ImageView) itemView.findViewById(R.id.imgChiste);
            txtTitulo = (TextView) itemView.findViewById(R.id.txtTitulo);
        }
    }

    public interface OnItemClickListener {
        void onChisteItemClick(Chiste chiste); //metodo
    }
}
