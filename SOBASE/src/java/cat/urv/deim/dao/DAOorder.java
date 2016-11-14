/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.dao;

import cat.urv.deim.sob.Offer;
import cat.urv.deim.sob.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author realm
 */
public class DAOorder {
    public ArrayList<Order> getComandes(String alias) throws SQLException, ParseException {
        ArrayList<Order> comandes = new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.comanda where id_usuari=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alias);
            Order comanda;
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
                Date dateObj = curFormater.parse(resultSet.getString(3)); 
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateObj);
                comanda=new Order(resultSet.getInt(4),resultSet.getInt(1),calendar,resultSet.getTime(7),resultSet.getString(3),resultSet.getInt(5),resultSet.getString(2));
                comandes.add(comanda);
        }
        return comandes;
    }
}
