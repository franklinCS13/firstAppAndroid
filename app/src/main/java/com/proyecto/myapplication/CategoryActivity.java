package com.proyecto.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.proyecto.myapplication.model.Chiste;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private static String TAG = CategoryActivity.class.getSimpleName();
    public static String IDCATEGORY = TAG + "IDCATEGORY";

    private List<Chiste> listarChistes;
    private AdapterChistes adapter;
    RecyclerView recyclerView;

    private int idCategory = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView = findViewById(R.id.rvCategories);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null){
            idCategory = mBundle.getInt(IDCATEGORY);
        }
        this.loadData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterChistes(this.filterChistes(idCategory));
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(onItemClickListener);
        recyclerView.setAdapter(adapter);

    }

    private AdapterChistes.OnItemClickListener onItemClickListener = (this::goToDetail);

    void goToDetail(Chiste chiste) {
        Intent intent = new Intent(getApplicationContext(), DetalleChistes.class);
        intent.putExtra(DetalleChistes.TITULO, chiste.getNombre());
        intent.putExtra(DetalleChistes.FOTO, chiste.getFoto());
        startActivity(intent);
    }

    private void loadData() {
        listarChistes = new ArrayList<>();
        listarChistes.add(new Chiste(1, "Jaimito y los borrachos", R.drawable.galle, 1));
        listarChistes.add(new Chiste(2, "Borrachos sdsadas", R.drawable.borra, 1));
        listarChistes.add(new Chiste(3, "Jaimito Chaturri", R.drawable.jaimito, 2));
        listarChistes.add(new Chiste(4, "Gallego Inaqui", R.drawable.pro, 2));
        listarChistes.add(new Chiste(5, "Jaimito Venereo", R.drawable.galle, 3));
        listarChistes.add(new Chiste(6, "Borrachos sustis", R.drawable.borra, 3));
        listarChistes.add(new Chiste(7, "Jaimito Goles", R.drawable.jaimito, 4));
        listarChistes.add(new Chiste(8, "Jaimito Pepas", R.drawable.pro, 4));
        listarChistes.add(new Chiste(9, "Naturaleza", R.drawable.galle, 5));
        listarChistes.add(new Chiste(10, "Ecologia", R.drawable.borra, 5));
        listarChistes.add(new Chiste(11, "Motocross", R.drawable.jaimito, 6));
        listarChistes.add(new Chiste(12, "Dubai Motero", R.drawable.pro, 6));
    }

    private List<Chiste> filterChistes(int idCategory) {
        List<Chiste> chistesFiltrados = new ArrayList<>();
        for (int i=0; i<listarChistes.size();i++){
            if (idCategory == listarChistes.get(i).getIdCategoria()){
                chistesFiltrados.add(listarChistes.get(i));
            }
        }
        return chistesFiltrados;
    }

}
