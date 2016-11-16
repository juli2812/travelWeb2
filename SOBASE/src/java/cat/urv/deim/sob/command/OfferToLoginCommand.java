/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BEC.CA2
 */
public class OfferToLoginCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            String idOferta = request.getParameter("idOferta");
            String placesReserva = request.getParameter("placesReserva");
            HttpSession session = request.getSession(true);
            // 1. process the request
                ServletContext context = request.getSession().getServletContext();
                int idOfertaint=Integer.parseInt(idOferta);
                int placesReservaint=Integer.parseInt(placesReserva);
                context.getRequestDispatcher("/login.jsp?idOferta="+idOfertaint+"&placesReserva="+placesReserva).forward(request, response);
    }
}
