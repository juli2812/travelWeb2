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
import java.io.StringReader;
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
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.QueryParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.codec.digest.DigestUtils;

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
    
    /**
     *
     * @return
     * @throws ParseException
     * @throws ClassNotFoundException
     */
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
     
    /**
     *
     * @return
     * @throws ParseException
     * @throws ClassNotFoundException
     */
    @GET
    @Produces("application/xml")
       public List<Usuari> getUsersXml() throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        List<Usuari> userList = new ArrayList<>();
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
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
            }
        }
        return userList;
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
       
    /**
     *
     * @param id
     * @param user
     * @param pass
     * @return
     * @throws ParseException
     * @throws ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Path("/{id}")
    @GET
    @Produces("application/json")
       public String getUser(@PathParam("id") String id,@QueryParam("user") String user,@QueryParam("pass") String pass) throws ParseException, ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        Connection con;
        String resultado = "";
        String alias = getLogin(user, pass);
        if(user.equals(alias)){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM USUARI WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            List<Object> listaObj = new ArrayList<>();
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
                listaObj.add(user2);
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
            
            listaObj.add(listaComanda);
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(listaObj);
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
            }
        }
        }
        return resultado;
    }
       
    /**
     *
     * @param id
     * @return
     * @throws ParseException
     * @throws ClassNotFoundException
     */
    @Path("/{id}")
    @GET
    @Produces("application/xml")
       public List<Object> getUserXml(@PathParam("id") String id) throws ParseException, ClassNotFoundException {
        PreparedStatement ps = null;
        Connection con;
        List<Object> listaObj = new ArrayList<>();
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
                listaObj.add(user2);
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
            
            listaObj.add(listaComanda);
            con.close();
        } catch (SQLException ex) {
            while(ex != null) {
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("SQLSTATE: " + ex.getSQLState());            
                System.out.println("Código de error SQL: " + ex.getErrorCode()); 
                ex=ex.getNextException();
            }
        }
        return listaObj;
    }
     
    /**
     *
     * @param id
     * @param data
     * @param user
     * @param pass
     * @throws ParseException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @PUT   
    @Path("/{id}")
    @Consumes("application/json")
       public void updateUser(@PathParam("id") String id, String data, @QueryParam("user") String user,@QueryParam("pass") String pass) throws ParseException, ClassNotFoundException, SQLException {
        PreparedStatement ps;
        Connection con;
        String alias = getLogin(user, pass);
        if(user.equals(alias)){
        try {
            Gson gs =new Gson();
            Usuari usuari=gs.fromJson(data, Usuari.class);
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "UPDATE USUARI SET CONTRASENYA = ?,NOM = ?,COGNOM1=?,COGNOM2=?,ADREÇA=?,TELEFON=?,EMAIL=?,DATA_NAIX=?,SEXE=? WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, DigestUtils.sha1Hex(usuari.getContrasenya()));
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
    }
     
    /**
     *
     * @param id
     * @param data
     * @param user
     * @param pass
     * @throws ParseException
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws JAXBException
     */
    @PUT   
    @Path("/{id}")
    @Consumes("application/xml")
       public void updateUserXml(@PathParam("id") String id, String data, @QueryParam("user") String user,@QueryParam("pass") String pass) throws ParseException, ClassNotFoundException, SQLException, JAXBException {
        PreparedStatement ps;
        Connection con;
        StringReader sr = new StringReader(data);
        JAXBContext jaxbContext = JAXBContext.newInstance(Usuari.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Usuari u = (Usuari) unmarshaller.unmarshal(sr);
        String alias = getLogin(user, pass);
        if(user.equals(alias)){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "UPDATE USUARI SET CONTRASENYA = ?,NOM = ?,COGNOM1=?,COGNOM2=?,ADREÇA=?,TELEFON=?,EMAIL=?,DATA_NAIX=?,SEXE=? WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, DigestUtils.sha1Hex(u.getContrasenya()));
            ps.setString(2, u.getNom());
            ps.setString(3, u.getCognom1());
            ps.setString(4, u.getCognom2());
            ps.setString(5, u.getAdreça());
            ps.setString(6, u.getTelefon());
            ps.setString(7, u.getEmail());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(8, df.format(u.getDataNaix()));
            ps.setString(9, u.getSexe());
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
    }

    /**
     *
     * @param data
     * @throws ClassNotFoundException
     * @throws JAXBException
     */
    @POST
    @Consumes("application/xml")
       public void addUserXml(String data) throws ClassNotFoundException, JAXBException {
        PreparedStatement ps;
        Connection con;
        StringReader sr = new StringReader(data);
        JAXBContext jaxbContext = JAXBContext.newInstance(Usuari.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Usuari u = (Usuari) unmarshaller.unmarshal(sr);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "INSERT INTO USUARI(ALIAS,CONTRASENYA,NOM,COGNOM1,COGNOM2,ADREÇA,TELEFON,EMAIL,DATA_NAIX,SEXE) VALUES(?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, u.getAlias());
            ps.setString(2, DigestUtils.sha1Hex(u.getContrasenya()));
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
            ps.setString(2, DigestUtils.sha1Hex(u.getContrasenya()));
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
       
    /**
     *
     * @param id
     * @param user
     * @param pass
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @DELETE
    @Path("/{id}")
       public void delUser(@PathParam("id") String id, @QueryParam("user") String user,@QueryParam("pass") String pass) throws ClassNotFoundException, SQLException {
        PreparedStatement ps;
        Connection con;
        
        String alias = getLogin(user, pass);
        if(user.equals(alias)){
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
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
