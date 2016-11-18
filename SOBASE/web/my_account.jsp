<%-- 
    Document   : my_account
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            User usuari;
            usuari = (User) session.getAttribute("dadesUsuari");
            ArrayList<Order> listaComandes = (ArrayList<Order>) session.getAttribute("dadesComandes");
            Order comanda = null;
            %>
        <title>SafeTravel</title>
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
                    <div id="menu_inicial2" >
            <table class="totample">
                <tr>
                    <td id="barra_inici2">
                        <font class="text_arial_blanc"><h2>El meu compte</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <br>
        <%-- Mosta la informació de l'usuari i les seves comandes fins al moment--%>
            <table>
                <tr>
                    <td class="borde_gris"><img src="images/usuari.jpg" alt="Smiley face" height="120px" width="120px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2>Dades usuari</h2><br>
                    <%=usuari.getInfoaccount()%></font>
                    </td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                        <h1>Comandes:</h1>
                        <%for(int j=0; j<listaComandes.size();j++){%>
                    <%comanda=listaComandes.get(j);%>
                    <%=comanda.getComandaInfo()%><br><%}%></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button onclick="history.back()">Enrere</button>
                    </td>
                <tr>
            </table>
    </body>
</html>