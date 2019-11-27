package com.proyecto.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleChistes extends AppCompatActivity {

    private static String TAG = DetalleChistes.class.getSimpleName();
    public static String TITULO = TAG + "TITULO";
    public static String FOTO = TAG + "FOTO";

    private TextView titulo, des;
    private ImageView chis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        titulo = findViewById(R.id.txtTitulo);
        des = findViewById(R.id.txtdes);
        chis = findViewById(R.id.imgChis);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null){
            titulo.setText(mBundle.getString(TITULO));
            //des.setText(mBundle.getString("KEY_DES"));
            chis.setImageResource(mBundle.getInt(FOTO));
        }
    }
//BOTON COMPARTIR
        /*public void shareText(View view) {
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBodyText = "Your shearing message goes here";
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(intent, "Choose sharing method"));
        }*/

    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*int id = item.getItemId();
        if (id == R.id.Share) {
            return true;*/
        switch (item.getItemId()){
            case R.id.Share:

                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                String shareBodyText = "Enviado correctamente";
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"imgs");
                i.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(i, "Compartir con: "));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //return super.onOptionsItemSelected(item);
    }
}
