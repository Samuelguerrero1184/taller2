package providers;

import db.DBConnection;
import model.Article;

import java.sql.SQLException;

public class ArticleProvider {
    public void createArticle(Article article) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO A00365567_Articulos(cantidad,id,tag)VALUES ($CANTIDAD,$ID,$TAG)";
        sql = sql.replace("$CANTIDAD",""+article.getCantidad());
        sql = sql.replace("$ID",""+article.getId());
        sql = sql.replace("$TAG",""+article.getTag());
        con.getData(sql);
        con.disconnect();
    }
}
