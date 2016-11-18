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
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javax.servlet.http.HttpSession;

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
        /*Comprovem que totes les dades requerides estiguin correctes, no estiguin buides,
        i si l'usuari no existeix el crearem nou*/
        HttpSession sesion = request.getSession(true);
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
            if((request.getParameter("first_name").equals(""))&&codiError==0){
                codiError=3;
                totCorrecte=false;
            }
            if((request.getParameter("last_name").equals(""))&&codiError==0){
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
            ServletContext context = request.getSession().getServletContext();
            DAOuser u2=null;
            if(totCorrecte){
            User user = new User();
            u2 = new DAOuser();
            if(!("").equals(u2.existeix(request.getParameter("alias")))){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError=10&alias="+request.getParameter("alias")+"&first_name="+request.getParameter("first_name")
                        +"&last_name="+request.getParameter("last_name")+"&last_name2="+request.getParameter("last_name2")
                        +"&data_naix="+request.getParameter("data_naix")+"&address="+request.getParameter("address")+"&phone="
                        +request.getParameter("phone")+"&email="+request.getParameter("email")).forward(request, response);
            }
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
            request.setAttribute("user", user);}/* l'atribut user és el que mostrarà la confirmació del registre*/
            if(totCorrecte){
            u2.registrar(request.getParameter("alias"), request.getParameter("pass"), request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("last_name2"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("data_naix"), request.getParameter("sexe"));}
            // 2. produce the view with the web result
            if(totCorrecte){
            context.getRequestDispatcher("/registre_confirmat.jsp").forward(request, response);
            }
            if(codiError!=0){
                context.getRequestDispatcher("/register.jsp?totCorrecte=false&codiError="+codiError+
                        "&alias="+request.getParameter("alias")+"&first_name="+request.getParameter("first_name")
                        +"&last_name="+request.getParameter("last_name")+"&last_name2="+request.getParameter("last_name2")
                        +"&data_naix="+request.getParameter("data_naix")+"&address="+request.getParameter("address")+"&phone="
                        +request.getParameter("phone")+"&email="+request.getParameter("email")).forward(request, response);
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
