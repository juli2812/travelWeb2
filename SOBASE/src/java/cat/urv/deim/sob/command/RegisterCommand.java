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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BEC.CA2
 */
public class RegisterCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PreparedStatement ps;
            Connection con;
            // 1. process the request
            
            boolean totCorrecte=true;
            int codiError=0;
            if((request.getParameter("alias").equals("")||(request.getParameter("alias").length()<8)||(request.getParameter("alias").length()>10))&&codiError==0){
                codiError=1;
                totCorrecte=false;
            }
            if((request.getParameter("pass").equals("")||(request.getParameter("pass").length()<8)||(request.getParameter("pass").length()>10))&&codiError==0){
                codiError=2;
                totCorrecte=false;
            }
            if((request.getParameter("first_name").equals("")||(request.getParameter("first_name").length()>20))&&codiError==0){
                codiError=3;
                totCorrecte=false;
            }
            if((request.getParameter("last_name").equals("")||(request.getParameter("last_name").length()>12))&&codiError==0){
                codiError=4;
                totCorrecte=false;
            }
            if((request.getParameter("data_naix").equals("")||(request.getParameter("data_naix").length()!=10))&&codiError==0){
                codiError=5;
                totCorrecte=false;
            }
            if((request.getParameter("address").equals("")||(request.getParameter("address").length()>50))&&codiError==0){
                codiError=6;
                totCorrecte=false;
            }
            if(((!request.getParameter("phone").equals(""))&&request.getParameter("phone").length()!=9)&&codiError==0){
                codiError=7;
                totCorrecte=false;
            }
            if((request.getParameter("email").equals("")||(request.getParameter("email").length()>50))&&codiError==0){
                codiError=8;
                totCorrecte=false;
            }
            if(totCorrecte){
            User user = new User();
            user.setFirstName(request.getParameter("first_name"));
            user.setLastName(request.getParameter("last_name"));
            user.setEmail(request.getParameter("email"));
            user.setPhone(request.getParameter("phone"));
            user.setAlias(request.getParameter("alias"));
            user.setLastName2(request.getParameter("last_name2"));
            SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
            Date dateObj = curFormater.parse(request.getParameter("data_naix")); 
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObj);
            user.setData_naix(calendar);
            user.setPass(request.getParameter("pass"));
            user.setSexe(request.getParameter("sexe"));
            user.setAddress(request.getParameter("address"));
            request.setAttribute("user", user);}
            if(totCorrecte){
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String sentenciaSQL = "INSERT INTO demodb.usuari(alias,contrasenya,nom,cognom1,cognom2,adreça,telefon,email,data_naix) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sentenciaSQL);
                    ps.setString(1, request.getParameter("alias"));
                    ps.setString(2, request.getParameter("pass"));
                    ps.setString(3, request.getParameter("first_name"));
                    ps.setString(4, request.getParameter("last_name"));
                    ps.setString(5, request.getParameter("last_name2"));
                    ps.setString(6, request.getParameter("address"));
                    ps.setString(7, request.getParameter("phone"));
                    ps.setString(8, request.getParameter("email"));
                    ps.setString(9, request.getParameter("data_naix"));
            ps.executeUpdate();}
            // 2. produce the view with the web result
            ServletContext context = request.getSession().getServletContext();
            if(totCorrecte){
            context.getRequestDispatcher("/registre_confirmat.jsp").forward(request, response);
            }else if(codiError==1){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=1").forward(request, response);
            }else if(codiError==2){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=2").forward(request, response);
            }else if(codiError==3){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=3").forward(request, response);
            }else if(codiError==4){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=4").forward(request, response);
            }else if(codiError==5){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=5").forward(request, response);
            }else if(codiError==6){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=6").forward(request, response);
            }else if(codiError==7){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=7").forward(request, response);
            }else if(codiError==8){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=8").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}