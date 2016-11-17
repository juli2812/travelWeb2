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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author BEC.CA2
 */
public class DAOofertes {
    public ArrayList<Offer> getOfertes() throws SQLException, ParseException {
        ArrayList<Offer> ofertes = new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.oferta";
            PreparedStatement ps = con.prepareStatement(query);
            Offer oferta;
            ResultSet resultSet = ps.executeQuery();
            SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj, dateObj2;
            Calendar calendar, calendar2;
            while (resultSet.next()) {
                dateObj = curFormater.parse(resultSet.getString(7));
                dateObj2 = curFormater.parse(resultSet.getString(8)); 
                calendar = Calendar.getInstance();
                calendar2 = Calendar.getInstance();
                calendar.setTime(dateObj);
                calendar2.setTime(dateObj2);
                oferta=new Offer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getFloat(5),resultSet.getString(6),resultSet.getInt(9),calendar,calendar2);
                ofertes.add(oferta);
        }
        return ofertes;
    }
    
    public Offer getOferta(int id_oferta) throws SQLException, ParseException {
        Offer oferta = null;
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.oferta where oferta_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_oferta);
            ResultSet resultSet = ps.executeQuery();
            SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj, dateObj2;
            Calendar calendar, calendar2;
            if (resultSet.next()) {
                dateObj = curFormater.parse(resultSet.getString(7));
                dateObj2 = curFormater.parse(resultSet.getString(8)); 
                calendar = Calendar.getInstance();
                calendar2 = Calendar.getInstance();
                calendar.setTime(dateObj);
                calendar2.setTime(dateObj2);
                oferta=new Offer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getFloat(5),resultSet.getString(6),resultSet.getInt(9),calendar,calendar2);
        }
        return oferta;
    }
    public void modificaOferta(int places_disp, int id_oferta) throws SQLException {
        Offer oferta = null;
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "UPDATE DEMODB.OFERTA SET places_disp=? WHERE oferta_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, places_disp);
            ps.setInt(2, id_oferta);
            ps.execute();
    }
}