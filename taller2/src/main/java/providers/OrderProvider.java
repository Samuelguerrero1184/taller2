package providers;

import db.DBConnection;
import model.Article;
import model.Order;
import model.Product;
import model.Report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderProvider {

    public void createOrder(Order order) throws SQLException {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO A00365567-OrderS(id,fecha,pago,fecha_pago,identificacion)"
                + "VALUES ($ID,$FECHA,$PAGO,$FECHA_PAGO,$IDENTIFICACION)";
        sql = sql.replace("$ID",""+order.getId());
        sql = sql.replace("$FECHA",""+order.getFecha());
        sql = sql.replace("$PAGO",""+order.isPago());
        if(order.isPago()){
            sql = sql.replace("$FECHA_PAGO",""+order.getFecha_pago());
        }else{
            sql = sql.replace("$FECHA_PAGO","null");
        }
        sql = sql.replace("$IDENTIFICACION",order.getIdentificacion());
        con.getData(sql);
        con.disconnect();
    }

    public void changeStatus(int order) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        long time = System.currentTimeMillis();
        String sql = "UPDATE A00365567-Orders SET pago = $PAGO, fecha_pago = $FECHA_PAGO"
                +" WHERE id = $ID";
        sql = sql.replace("$ID",""+order);
        sql = sql.replace("$PAGO",""+true);
        sql = sql.replace("$FECHA_PAGO",""+time);

        con.getData(sql);
        con.disconnect();
    }

    public Report getInfo(int order) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM A00365567-Articulos"
                +" WHERE id = $ORDER";
        sql = sql.replace("$ORDER",""+order);

        ResultSet articles_result = con.getData(sql);
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        while(articles_result.next()){
            int cantidad = articles_result.getInt("cantidad");
            int id = articles_result.getInt("id");
            int tag = articles_result.getInt("tag");
            articles.add(new Article(cantidad,id,tag));
        }

        for(int i = 0; i<articles.size(); i++){
            sql = "SELECT * FROM A00365567-Productos"
                    +" WHERE id = $ID";
            sql = sql.replace("$ID",""+articles.get(i).getTag());
            ResultSet product = con.getData(sql);
            product.next();
            int id = product.getInt("id");
            String nombre = product.getString("nombre");
            String tamano = product.getString("tamano");
            int precio = product.getInt("precio");
            products.add(new Product(id,nombre,tamano,precio));
        }

        con.disconnect();

        return new Report(products,articles);
    }
}
