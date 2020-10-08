package com.aleja.momento1movil.models;

public class NotaModel {

    private int _id;
    private String titulo;
    private String descripcion;

    public NotaModel() {
    }

    public NotaModel(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public NotaModel(int _id, String titulo, String descripcion) {
        this._id = _id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
