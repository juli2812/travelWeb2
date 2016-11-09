package cat.urv.deim.sob.command;

import cat.urv.deim.sob.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class InitCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PreparedStatement ps;
            Connection con;
            HttpSession session = request.getSession(true);
            // 1. process the request
           
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.oferta";
            ps = con.prepareStatement(query);            
            ResultSet resultSet=ps.executeQuery();
            /*int i=0;
            boolean a=true;
            List<String> titols = new ArrayList<String>();
            String b="";
            while (a) {     //if is correct go to main
                b=resultSet.getString("titol_oferta");
                titols.add(b);
                i++;
                if(resultSet.next()==false){
                    a=false;}
            }
            
            session.setAttribute("titol_oferta", titols);
            session.setAttribute("numElem", i);*/
            
                ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/index_ofertes.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
