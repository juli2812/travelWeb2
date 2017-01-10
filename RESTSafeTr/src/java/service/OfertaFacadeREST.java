/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.Oferta;
import api.Usuari;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

/**
 *
 * @author realm
 */
@Stateless
@Path("/rest/api/v1/promos")
public class OfertaFacadeREST extends AbstractFacade<Oferta> {

    @PersistenceContext(unitName = "RESTSafeTrPU")
    private EntityManager em;

    public OfertaFacadeREST() {
        super(Oferta.class);
    }
    
    @GET
    @Produces("application/json")
       public String getOffers() throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        String resultado = "";
        List<Oferta> offerList = new ArrayList<Oferta>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM OFERTA";
            ps = con.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            Oferta offer;
            while(resultSet.next()) {     //if is correct go to main
                offer = new Oferta();
                offer.setOfertaId(resultSet.getInt(1));
                offer.setTitolOferta(resultSet.getString(2));
                offer.setDescripcio(resultSet.getString(3));
                offer.setPlacesDisp(resultSet.getInt(4));
                offer.setPreuPers(resultSet.getDouble(5));
                offer.setDesti(resultSet.getString(6));
                SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
                offer.setDataSortida(curFormater.parse(resultSet.getString(7)));
                offer.setDataTornada(curFormater.parse(resultSet.getString(8)));
                offer.setDiesEstada(resultSet.getInt(9));
                offer.setDescripcioGran(resultSet.getString(10));
                offerList.add(offer);
            }
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(offerList);
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
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
       public String getOffer(@PathParam("id") String id) throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        String resultado = "";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM OFERTA WHERE OFERTA_ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            Oferta offer=new Oferta();
            if(resultSet.next()) {     //if is correct go to main
                offer = new Oferta();
                offer.setOfertaId(resultSet.getInt(1));
                offer.setTitolOferta(resultSet.getString(2));
                offer.setDescripcio(resultSet.getString(3));
                offer.setPlacesDisp(resultSet.getInt(4));
                offer.setPreuPers(resultSet.getDouble(5));
                offer.setDesti(resultSet.getString(6));
                SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
                offer.setDataSortida(curFormater.parse(resultSet.getString(7)));
                offer.setDataTornada(curFormater.parse(resultSet.getString(8)));
                offer.setDiesEstada(resultSet.getInt(9));
                offer.setDescripcioGran(resultSet.getString(10));
            }
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(offer);
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
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Oferta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Oferta entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    /*@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Oferta find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Oferta> findAll() {
        return super.findAll();
    }*/

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Oferta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
