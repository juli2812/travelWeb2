package cat.urv.deim.sob.command;

import cat.urv.deim.dao.DAOofertes;
import cat.urv.deim.dao.DAOorder;
import cat.urv.deim.sob.Offer;
import cat.urv.deim.sob.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class ReservarCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession(true);
            // 1. process the request
            int idOferta =  (int) session.getAttribute("idOferta");
            DAOofertes oferta_=new DAOofertes();
            int placesDisp = 0;
        try {
            Offer oferta=oferta_.getOferta(idOferta);
            placesDisp = oferta.getAvailable_sits();
        } catch (SQLException ex) {
            Logger.getLogger(ReservarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
            String first = (String) session.getAttribute("first");
            String placesReservaST = request.getParameter("placesReserva");
            int placesReserva =Integer.parseInt(placesReservaST);
            System.out.print(placesReserva);
            float preuPers = (float) session.getAttribute("preuPers");
            String userLogin = (String) session.getAttribute("aliasLogin");
            DAOofertes ofertaActualitzar=new DAOofertes();
            DAOorder comanda=new DAOorder();
            Order order=new Order();
            int placesAct = placesDisp - placesReserva;
            ServletContext context = request.getSession().getServletContext();
            if(first.equals("1")){
            if(placesAct>=0){
        try {
            ofertaActualitzar.modificaOferta(placesAct, idOferta);
        } catch (SQLException ex) {
            Logger.getLogger(ReservarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            float preuTotal = preuPers * placesReserva;
            order = comanda.novaComanda(userLogin, idOferta, preuTotal, placesReserva);
        } catch (SQLException ex) {
            Logger.getLogger(ReservarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
                session.setAttribute("comanda", order);
                context.getRequestDispatcher("/reserva_confirmada.jsp").forward(request, response);}
            else context.getRequestDispatcher("/oferta.jsp?id_oferta="+idOferta+"&placesReserva="+placesReserva+"&error=true").forward(request, response);
    }else context.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
