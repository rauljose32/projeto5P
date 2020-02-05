package com.marcos.primeiroprojeto.listaDinamica;

import android.widget.ImageView;

public class ItemListaPedidos {
    private int id;
    private String data;
    private double valor;
    private int idImage;

    public ItemListaPedidos(int id, String data, double valor, int idImage) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


}
