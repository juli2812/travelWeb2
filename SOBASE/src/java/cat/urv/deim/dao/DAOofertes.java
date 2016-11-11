/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.dao;

import cat.urv.deim.sob.Offer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BEC.CA2
 */
public class DAOofertes {
    public ArrayList<Offer> getOfertes() throws SQLException {
        ArrayList<Offer> ofertes = new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.oferta";
            PreparedStatement ps = con.prepareStatement(query);
            Offer oferta;
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                oferta=new Offer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getFloat(5),resultSet.getString(6),resultSet.getInt(9));
                ofertes.add(oferta);
        }
        return ofertes;
    }
}
