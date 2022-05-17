package model;

public class Article {

    private int cantidad;
    private int id;
    private int tag;

    public Article(){}

    public Article(int cantidad, int ID, int tag) {
        this.cantidad = cantidad;
        this.id = id;
        this.tag = tag;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}