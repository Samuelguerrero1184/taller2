package providers;

import db.DBConnection;
import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleProvider {
    public void createArticle(Article article) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO A00365567-Articulos(cantidad,id,tag)VALUES ($CANTIDAD,$ID,$TAG)";
        sql = sql.replace("$CANTIDAD",""+article.getCantidad());
        sql = sql.replace("$ID",""+article.getId());
        sql = sql.replace("$TAG",""+article.getTag());
        con.getData(sql);
        con.disconnect();
    }

    public void deleteArticle(int order, int product, int amount) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM A00365567-Articulos"
                +" WHERE id = $ORDER AND tag = $PRODUCT";

        sql = sql.replace("$ORDER",""+order);
        sql = sql.replace("$PRODUCT",""+product);

        ResultSet result = con.getData(sql);

        result.next();
        int orders = result.getInt("id");
        int products = result.getInt("tag");
        int amounts = result.getInt("cantidad");

        amounts -= amount;

        if(amounts > 0){
            sql = "UPDATE A00365567-Articulos SET cantidad = $CANTIDAD"
                    + " WHERE id = $ID AND tag = $TAG";
            sql = sql.replace("$CANTIDAD",""+amounts);
            sql = sql.replace("$ID",""+orders);
            sql = sql.replace("$TAG",""+products);
        }else{
            sql = "DELETE FROM articlesA00368822"
                    + " WHERE id = $ID AND tag = $TAG";
            sql = sql.replace("$ID",""+orders);
            sql = sql.replace("$TAG",""+products);
        }

        con.getData(sql);

        con.disconnect();
    }

}
