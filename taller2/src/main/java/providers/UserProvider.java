package providers;

import db.DBConnection;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProvider {

    public void create(User user) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO A00365567-Usuarios(identificacion, nombre) VALUES ('$IDENTIFICACION','$NOMBRE')";
        sql = sql.replace("$IDENTIFICACION",user.getIdentificacion());
        sql = sql.replace("$NOMBRE",user.getNombre());
        System.out.println(sql);
        con.getData(sql);
        con.disconnect();
    }

    public Historial getInfo(String user) throws SQLException, ClassNotFoundException {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM A00365567-Orders"
                +" WHERE identificacion = '$USER'";
        sql = sql.replace("$USER",user);

        ResultSet results = con.getData(sql);
        ArrayList<Order> orders = new ArrayList<>();

        while(results.next()){
            int id = results.getInt("id");
            long fecha = results.getLong("fecha");
            boolean pago = results.getBoolean("pago");
            long fecha_pago = results.getLong("fecha_pago");
            String identificacion = results.getString("identificacion");
            orders.add(new Order(id,fecha,pago,fecha_pago,identificacion));
        }

        con.disconnect();

        return new Historial(user,orders);
    }
}