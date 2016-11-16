/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.dao.DAOuser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author BEC.CA2
 */
public class LoginToOfferCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            String alias = request.getParameter("alias");   //get user ans password
            String pass = request.getParameter("pass");
            String idOfertaST = request.getParameter("idOferta3");
            int idOferta = Integer.parseInt(idOfertaST);
            String placesResST = request.getParameter("placesRes3");
            int placesReserva = Integer.parseInt(placesResST);
            HttpSession session = request.getSession(true);
            // 1. process the request
            
            DAOuser n= new DAOuser();
            String a="";
        try {
            a = n.getLogin(alias, pass);
        } catch (SQLException ex) {
            Logger.getLogger(LoginToOfferCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = request.getSession().getServletContext();
        if((alias!=null)&&(!("").equals(alias))){
            if (a.equals(alias)) {     //if is correct go to main
                session.setAttribute("aliasLogin", a);
                context.getRequestDispatcher("/oferta.jsp?id_oferta="+idOferta+"&placesReserva="+placesReserva).forward(request, response);
            }
            else{
                context.getRequestDispatcher("/login.jsp?dadesErronees=true&idOferta="+idOferta+"&placesReserva="+placesReserva).forward(request, response);}
        }
        else context.getRequestDispatcher("/login.jsp?dadesErronees=true&idOferta="+idOferta+"&placesReserva="+placesReserva).forward(request, response);
    }
}
