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
public class LoginCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            String alias = request.getParameter("alias");   //get user ans password
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession(true);
            // 1. process the request
            
            DAOuser n= new DAOuser();
            String a="";
        try {
            a = n.getLogin(alias, pass);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        ServletContext context = request.getSession().getServletContext();
        if((alias!=null)&&(!("").equals(alias))){
            if (a.equals(alias)) {     //if is correct go to main
                session.setAttribute("aliasLogin", a);
                context.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else{
                context.getRequestDispatcher("/login.jsp?dadesErronees=true").forward(request, response);}
    }else context.getRequestDispatcher("/login.jsp?dadesErronees=true").forward(request, response);
    }
}
