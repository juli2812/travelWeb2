/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author realm
 */
@Stateless
@Path("/deuda")
public class Alumno {
    
    @GET
    public String getDeuda(@QueryParam("codigo") String codigo){
        
        return "El alumno "+codigo+".";
    }
}
