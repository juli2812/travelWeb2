<%-- 
    Document   : reserva_confirmada
    Created on : 03-nov-2016, 13:00:10
    Author     : BEC.CA2
--%>
<jsp:useBean id="user" class="cat.urv.deim.sob.User" scope="session" />
<%@page import="cat.urv.deim.sob.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            Order comanda = (Order) session.getAttribute("comanda");
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
                        <font class="text_arial_blanc"><h2>Reserva confirmada</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
        
        <br>
        <br>
            <table>
                <tr>
                    <td class="borde_gris"><img src="images/reserva.jpg" alt="Smiley face" height="240px" width="400px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2>Reserva confirmada</h2>
                    <br><%=comanda.getComandaReserva()%>
                    </font></td>
                </tr>
            </table>
                                <%session.setAttribute("first", "0");%>
                    <button onclick="document.location.href='index.jsp'">Torna a l'inici</button>
    </body>
</html>