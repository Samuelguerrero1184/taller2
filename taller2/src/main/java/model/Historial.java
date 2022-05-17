package model;

import java.util.ArrayList;

public class Historial {

    private String identificaciones;
    private ArrayList<Order> orders;

    public Historial(String identificaciones, ArrayList<Order> orders){
        this.identificaciones = identificaciones;
        this.orders = orders;
    }

    public String getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(String identificaciones) {
        this.identificaciones = identificaciones;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}