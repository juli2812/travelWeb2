<%-- 
    Document   : exemple
    Created on : 03-nov-2016, 10:32:22
    Author     : BEC.CA2
--%>

<%@page import="cat.urv.deim.dao.DAOorder"%>
<%@page import="cat.urv.deim.sob.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.User"%>
<%@page import="cat.urv.deim.dao.DAOuser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            User usuari;
            usuari = (User) session.getAttribute("dadesUsuari");
            ArrayList<Order> listaComandes = (ArrayList<Order>) session.getAttribute("dadesComandes");
            Order comanda = null;
            %>
        <title>Viajar te da alas</title>
    </head>
    <body>
        <div id="menu_inicial">
            <table class="totample">
                <tr>
                    <td>
                        <a class="text_arial_href" href="index.jsp"><b>SafeTravel</b></a>
                    </td>
                    <td id="barra_inici">
                        <%if(userLogin!=null){%>
                        
                        <a class="text_arial_href" href="controller.do?form_action=infoaccount"><b>Benvingut <%=userLogin%>! </b></a><font class="text_arial_href"><b>|</b></font> <a class="text_arial_href" href="controller.do?form_action=logout"><b>Tancar sessió</b></a>
                        
                        <%}else{%>
                        
                        <a class="text_arial_href" href="login.jsp"><b>Iniciar Sessió </b></a> <font class="text_arial_href"><b>|</b></font> <a class="text_arial_href" href="register.jsp"><b>Registrar-se</b></a>
                        
                        <%}%>
                    </td>
                </tr>
            </table>
        </div>
        <div id="menu_inicial2">
            <table class="totample">
            </table>
        </div>
        <br>
        <br>
            <table>
                <tr>
                    <td class="borde_gris"><img src="css/playa.jpeg" alt="Smiley face" height="480px" width="640px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2>Dades usuari</h2><br>
                    <%=usuari.getInfoaccount()%></font>
                    <%comanda=listaComandes.get(0);%>
                    <%=comanda.getUser_id()%></td>
                </tr>
            </table>
    </body>
</html>
