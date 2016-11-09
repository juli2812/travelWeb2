/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

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
        try {
            PreparedStatement ps;
            Connection con;
            String alias = request.getParameter("alias");   //get user ans password
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession(true);
            // 1. process the request
           
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.usuari WHERE alias=? AND contrasenya=?";
            ps = con.prepareStatement(query);
                    ps.setString(1, request.getParameter("alias"));
                    ps.setString(2, request.getParameter("pass"));
            
            ResultSet resultSet=ps.executeQuery();
            if (resultSet.next()) {     //if is correct go to main
                session.setAttribute("aliasLogin", alias);
                ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else{ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/login.jsp?dadesErronees=true").forward(request, response);}
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
