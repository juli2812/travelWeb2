/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;
import cat.urv.deim.dao.DAOuser;
import cat.urv.deim.sob.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BEC.CA2
 */
public class InfoAccountCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String userLogin = (String) session.getAttribute("aliasLogin");
        DAOuser d=new DAOuser();
        try {
            session.setAttribute("dadesUsuari", d.getOfertes(userLogin));
        } catch (SQLException ex) {
            Logger.getLogger(InfoAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(InfoAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/my_account.jsp").forward(request, response);}
}
