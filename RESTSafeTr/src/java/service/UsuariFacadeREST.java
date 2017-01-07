/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import api.Usuari;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.ejb.EJB;

/**
 *
 * @author realm
 */
@Stateless
@Path("/rest/api/v1")
public class UsuariFacadeREST extends AbstractFacade<Usuari> {

    
    @PersistenceContext(unitName = "RESTSafeTrPU")
    private EntityManager em;

    public UsuariFacadeREST() {
        super(Usuari.class);
    }
    
    @GET
    @Path("/user")
    @Produces("application/json")
       public String getContact() throws ParseException, ClassNotFoundException {
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
                user2.setContrasenya("oculta");
                userList.add(user2);
            }
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(userList);
        } catch (SQLException ex) {
        }
        return resultado;
    }
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuari entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Usuari entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

       
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuari find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuari> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuari> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
