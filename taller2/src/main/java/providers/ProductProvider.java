package providers;

import db.DBConnection;
import model.Product;

import java.sql.SQLException;

public class ProductProvider {

    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO A00365567-Productos(id,nombre,tamano,precio)"
                + "VALUES ($ID,'$NOMBRE','$TAMANO',$PRECIO)";
        sql = sql.replace("$ID",""+product.getId());
        sql = sql.replace("$NOMBRE", product.getNombre());
        sql = sql.replace("$TAMANO", product.getTamano());
        sql = sql.replace("$PRECIO",""+product.getPrecio());
        con.getData(sql);
        con.disconnect();
    }
}