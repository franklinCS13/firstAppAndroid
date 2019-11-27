package com.proyecto.myapplication.model;

import java.io.Serializable;

public class Chiste implements Serializable {

    private int id;
    private String Nombre;
    private int foto;
    private int idCategoria;

    public Chiste() {
    }

    public Chiste(int id, String nombre, int foto, int idcat) {
        this.id = id;
        Nombre = nombre;
        this.foto = foto;
        this.idCategoria = idcat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
