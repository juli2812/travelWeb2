/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.Comanda;
import api.Oferta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import api.Usuari;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.QueryParam;

/**
 *
 * @author realm
 */
@Stateless
@Path("/rest/api/v1/users")
public class UsuariFacadeREST extends AbstractFacade<Usuari> {

    
    @PersistenceContext(unitName = "RESTSafeTrPU")
    private EntityManager em;

    public UsuariFacadeREST() {
        super(Usuari.class);
    }
    
    @GET
    @Produces("application/json")
       public String getUsers() throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        String resultado = "";
        List<Usuari> userList = new ArrayList<Usuari>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM USUARI";
            ps = con.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            Usuari user2;
            while(resultSet.next()) {     //if is correct go to main
                user2 = new Usuari();
                user2.setNom(resultSet.getString(3));
                user2.setCognom1(resultSet.getString(4));
                user2.setCognom2(resultSet.getString(5));
                user2.setEmail(resultSet.getString(8));
                user2.setTelefon(resultSet.getString(7));
                user2.setAlias(resultSet.getString(1));
                user2.setAdreça(resultSet.getString(6));
                SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
                Date dateObj = curFormater.parse(resultSet.getString(9)); 
                user2.setDataNaix(dateObj);
                user2.setSexe(resultSet.getString(10));
                user2.setContrasenya(resultSet.getString(2));
                userList.add(user2);
            }
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(userList);
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
            }
        }
        return resultado;
    }
       
    @Path("/{id}")
    @GET
    @Produces("application/json")
       public String getUser(@PathParam("id") String id) throws ParseException, ClassNotFoundException {
        PreparedStatement ps = null;
        Connection con;
        String resultado = "";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM USUARI WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            Usuari user2=new Usuari();
            if(resultSet.next()) {     //if is correct go to main
                user2.setNom(resultSet.getString(3));
                user2.setCognom1(resultSet.getString(4));
                user2.setCognom2(resultSet.getString(5));
                user2.setEmail(resultSet.getString(8));
                user2.setTelefon(resultSet.getString(7));
                user2.setAlias(resultSet.getString(1));
                user2.setAdreça(resultSet.getString(6));
                SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
                Date dateObj = curFormater.parse(resultSet.getString(9)); 
                user2.setDataNaix(dateObj);
                user2.setSexe(resultSet.getString(10));
                user2.setContrasenya(resultSet.getString(2));
            }
            List<Comanda> listaComanda= new ArrayList<Comanda>();
            Comanda comanda;
            query = "SELECT ID_OFERTA, PERSONAS, PREU_TOTAL FROM COMANDA WHERE COMANDA.ID_USUARI=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                comanda=new Comanda();
                //comanda.setIdOferta(resultSet.getObject(1, Oferta.class)); # esto de momento falla
                comanda.setPersonas(resultSet.getInt(2));
                comanda.setPreuTotal(resultSet.getDouble(3));
                listaComanda.add(comanda);
            }
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(user2).concat(gs2.toJson(listaComanda));
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
            }
        }
        return resultado;
    }
    
    @PUT   
    @Path("/{id}")
    @Consumes("application/json")
       public void updateUser(@PathParam("id") String id, String data) throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        try {
            Gson gs =new Gson();
            Usuari usuari=gs.fromJson(data, Usuari.class);
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "UPDATE USUARI SET CONTRASENYA = ?,NOM = ?,COGNOM1=?,COGNOM2=?,ADREÇA=?,TELEFON=?,EMAIL=?,DATA_NAIX=?,SEXE=? WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, usuari.getContrasenya());
            ps.setString(2, usuari.getNom());
            ps.setString(3, usuari.getCognom1());
            ps.setString(4, usuari.getCognom2());
            ps.setString(5, usuari.getAdreça());
            ps.setString(6, usuari.getTelefon());
            ps.setString(7, usuari.getEmail());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(8, df.format(usuari.getDataNaix()));
            ps.setString(9, usuari.getSexe());
            ps.setString(10, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
            }
            
        }
    }
    
    @POST
    @Consumes("application/json")
       public void addUser(String data) throws ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        Gson gs =new Gson();
        Usuari u=gs.fromJson(data, Usuari.class);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "INSERT INTO USUARI(ALIAS,CONTRASENYA,NOM,COGNOM1,COGNOM2,ADREÇA,TELEFON,EMAIL,DATA_NAIX,SEXE) VALUES(?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, u.getAlias());
            ps.setString(2, u.getContrasenya());
            ps.setString(3, u.getNom());
            ps.setString(4, u.getCognom1());
            ps.setString(5, u.getCognom2());
            ps.setString(6, u.getAdreça());
            ps.setString(7, u.getTelefon());
            ps.setString(8, u.getEmail());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(9, df.format(u.getDataNaix()));
            ps.setString(10, u.getSexe());
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
             }
        }
    }
    
    /********************************/   
    /* OPCIONAL: Elimina un usuari. */
    /********************************/
    @DELETE
    @Path("/{id}")
       public void delUser(@PathParam("id") String id) throws ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "DELETE FROM USUARI WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
             }
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
