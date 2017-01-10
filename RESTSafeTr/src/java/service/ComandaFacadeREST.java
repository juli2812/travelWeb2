/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.Comanda;
import api.Oferta;
import api.Usuari;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author realm
 */
@Stateless
@Path("/rest/api/v1/promos/{id}/booking")
public class ComandaFacadeREST extends AbstractFacade<Comanda> {

    @PersistenceContext(unitName = "RESTSafeTrPU")
    private EntityManager em;

    public ComandaFacadeREST() {
        super(Comanda.class);
    }
    
    @GET
    @Produces("application/json")
       public String getComanda(@PathParam("id") String id) throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        String resultado = "";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM COMANDA WHERE id_comanda = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            Comanda comanda=new Comanda();
            if(resultSet.next()) {     //if is correct go to main
                comanda = new Comanda();
                comanda.setIdComanda(resultSet.getInt(1));
                //comanda.setIdUsuari((Usuari) resultSet.getObject(2));
                //comanda.setIdOferta((Oferta) resultSet.getObject(3));
                comanda.setPreuTotal(resultSet.getDouble(4));
                comanda.setPersonas(resultSet.getInt(5));
                SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat curFormater2 = new SimpleDateFormat("HH:mm:ss");
                comanda.setData(curFormater.parse(resultSet.getString(6)));
                comanda.setHora(curFormater2.parse(resultSet.getString(7)));
            }
            con.close();
            Gson gs2 =new Gson();
            resultado = gs2.toJson(comanda);
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
    @Consumes("application/json")
       public void updateOffer(@PathParam("id") String id, @QueryParam("userName") String userName, String data) throws ParseException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        try {
            Gson gs =new Gson();
            Comanda comanda=gs.fromJson(data, Comanda.class);
            Class.forName("org.apache.derby.jdbc.ClientDriver");    //database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM USUARI WHERE ALIAS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
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
            String query4 = "SELECT * FROM OFERTA WHERE OFERTA_ID = ?";
            ps = con.prepareStatement(query4);
            ps.setString(1, id);
            resultSet = ps.executeQuery();
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
            String query2 = "INSERT INTO COMANDA(id_usuari,id_oferta,preu_total,personas,data,hora) VALUES (?,?,?,?,?,?)";
            ps = con.prepareStatement(query2);
            ps.setString(1, user2.getAlias());
            ps.setInt(2, offer.getOfertaId());
            ps.setDouble(3, comanda.getPreuTotal());
            ps.setInt(4, comanda.getPersonas());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(5, df.format(comanda.getData()));
            DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
            ps.setString(6, df2.format(comanda.getHora()));
            ps.executeUpdate();
            //String query3 = "UPDATE OFERTA SET titol_oferta=?,descripcio=?,places_disp=?,preu_pers=?,desti=?,data_sortida=?,data_tornada=?,dies_estada=?,descripcio_gran=? where oferta_id=?";
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
    /*@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Comanda entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Comanda entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Comanda find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Comanda> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Comanda> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }*/

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
