package com.proyecto.myapplication.model;

import java.io.Serializable;

public class Categoria implements Serializable {

    private int id;
    private int image;
    private String nombre;

    public Categoria(int id, int image, String nombre) {
        this.id = id;
        this.image = image;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
