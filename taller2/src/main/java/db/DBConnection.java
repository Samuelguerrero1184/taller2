package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private Connection con;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void connect() throws SQLException {
        con= DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
    }

    public void disconnect() throws SQLException {
        con.close();
    }

    public ResultSet getData(String sql) throws SQLException {
        ResultSet resultSet = con.createStatement().executeQuery(sql);
        return resultSet;
    }

    public void comandSQL(String sql) throws SQLException {
        con.createStatement().execute(sql);
    }
}
