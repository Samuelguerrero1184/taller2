package model;

import java.util.ArrayList;

public class Report {

    private ArrayList<Product> products;
    private ArrayList<Article> articles;
    private int amount;
    private int totalprice;

    public Report(ArrayList<Product> products, ArrayList<Article> articles){
        this.products = products;
        this.articles = articles;
        this.amount = products.size();
        totalprice = 0;
        for(int i = 0; i<articles.size(); i++){
            totalprice += products.get(i).getPrecio()*articles.get(i).getCantidad();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}