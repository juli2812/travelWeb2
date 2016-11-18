/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.dao;

import cat.urv.deim.sob.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author BEC.CA2
 */
public class DAOuser {
    public User getUsuari(String alias) throws SQLException, ParseException {
        Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM DEMODB.USUARI where alias = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alias);
            ResultSet resultSet=ps.executeQuery();
            User user=null;
            if (resultSet.next()) {
            SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
            Date dateObj = curFormater.parse(resultSet.getString(9)); 
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObj);
            user=new User(resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(8),resultSet.getString(7),resultSet.getString(1),resultSet.getString(6),calendar,resultSet.getString(10),"oculta");
            }
        return user;
    }
    public String existeix(String alias) throws SQLException, ParseException {
        Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM DEMODB.USUARI where alias = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alias);
            ResultSet resultSet=ps.executeQuery();
            if (resultSet.next()) {
            return resultSet.getString(1);
            }
        return "";
    }
    public void registrar (String alias, String pass,String first_name, String last_name, String last_name2, String address, String phone, String email, String data_naix, String sexe) throws SQLException{
        Connection con;
        PreparedStatement ps;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String sentenciaSQL = "INSERT INTO demodb.usuari(alias,contrasenya,nom,cognom1,cognom2,adreça,telefon,email,data_naix,sexe) VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sentenciaSQL);
                    ps.setString(1, alias);
                    ps.setString(2, DigestUtils.sha1Hex(pass));
                    ps.setString(3, first_name);
                    ps.setString(4, last_name);
                    ps.setString(5, last_name2);
                    ps.setString(6, address);
                    ps.setString(7, phone);
                    ps.setString(8, email);
                    ps.setString(9, data_naix);
                    ps.setString(10, sexe);
            ps.executeUpdate();
    }
    public String getLogin (String alias, String pass) throws SQLException{
        Connection con;
        PreparedStatement ps;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.usuari WHERE alias=? AND contrasenya=?";
            ps = con.prepareStatement(query);
                    ps.setString(1, alias);
                    ps.setString(2, DigestUtils.sha1Hex(pass));
            
            ResultSet resultSet=ps.executeQuery();
            if (resultSet.next()) {
            return alias;
            }
            else return "";
    }
}
