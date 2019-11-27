package com.proyecto.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyecto.myapplication.model.Categoria;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Categoria> listarCategoria;
    private OnItemClickListener onItemClickListener;

    public Adaptador(List<Categoria> listarCategoria) {
        this.listarCategoria = listarCategoria;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_imagen, viewGroup, false);
        ViewHolder vh = new ViewHolder(vista);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder viewHolder, int i) {
        final Categoria item = listarCategoria.get(i);
        viewHolder.imgbut.setImageResource(item.getImage());
        viewHolder.itemView.setOnClickListener(view -> {
            if (Adaptador.this.onItemClickListener != null) {
                Adaptador.this.onItemClickListener.onChisteItemClick(item);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listarCategoria.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imgbut;
        private TextView titu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titu = (TextView) itemView.findViewById(R.id.txtTitu);
            imgbut = (ImageView) itemView.findViewById(R.id.imgBut);
        }
    }

    public interface OnItemClickListener {
        void onChisteItemClick(Categoria categoria);
    }
}
