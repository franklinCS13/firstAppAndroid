package com.proyecto.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.proyecto.myapplication.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv_chistes;
    private Adaptador adap;


    public List<Categoria> obtenerchistes() {
        List<Categoria> ch = new ArrayList<>();
        ch.add(new Categoria(1, R.drawable.jaimito, "Chiste de JAIMITO"));
        ch.add(new Categoria(2, R.drawable.galle, "Chiste de GALLEGOS"));
        ch.add(new Categoria(3, R.drawable.sue, "Chiste de SUEGRAS"));
        ch.add(new Categoria(4, R.drawable.borra, "Chiste de BORRACHOS"));
        ch.add(new Categoria(5, R.drawable.jaimito, "Chiste de JAIMITO"));
        ch.add(new Categoria(6, R.drawable.galle, "Chiste de GALLEGOS"));
        return ch;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_chistes = (RecyclerView) findViewById(R.id.rvfigura);
        rv_chistes.setLayoutManager(new LinearLayoutManager(this));

        adap = new Adaptador(obtenerchistes());


        rv_chistes.setAdapter(adap);
        adap.setOnItemClickListener(chistes);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //METODO DEL BOTON COMPARTIR
    /*public void shareText(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBodyText = "Your shearing message goes here";
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
        startActivity(Intent.createChooser(intent, "Choose sharing method"));
    }*/
    //

    //METODO PARA LISTAR LOS CHISTES
    private Adaptador.OnItemClickListener chistes = (this::goToOtherView);

    void goToOtherView(Categoria categoria) {
        Toast.makeText(getApplicationContext(), categoria.getNombre(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
        i.putExtra(CategoryActivity.IDCATEGORY, categoria.getId());
        i.putExtra("KEY_NOMBRE", categoria.getNombre());
        i.putExtra("KEY_FOTO", categoria.getImage());
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Share) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.start) {
            // Handle the camera action
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}