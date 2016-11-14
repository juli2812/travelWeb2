<%-- 
    Document   : reserva_confirmada
    Created on : 03-nov-2016, 13:00:10
    Author     : BEC.CA2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/><%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
        %>
        <title>Viajar te da alas</title>
    </head>
    <body>
        <div id="menu_inicial">
            <table class="totample">
                <tr>
                    <td>
                        <a class="text_arial_href" href="index_ofertes.jsp"><b>SafeTravel</b></a>
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
                    <td class="borde_gris"><img src="css/Dubai.jpg.jpeg" alt="Smiley face" height="240px" width="400px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2>Reserva confirmada</h2>
                    <b>#0104324 núm. de reserva</b><br><br>
                    Hora: 20:35:12 Día: 28/10/2016<br><br>
                    Destí: Brasil<br><br>
                    Temps d'estada: 7 dies<br><br>
                    Preu: 3288,78 euros<br><br>
                    Dia sortida: 27 d'abril de 2017<br><br>
                    Dia tornada: 4 de maig de 2017<br><br>
                    Places disponibles: 17<br><br>
                    Companyia d'avió: Luftansa<br><br><br>
                    L'estada a Brasil inclou 4 dies en l'Hotel Rio de Janeiro de 5 estrelles amb vistes a la platja, i després 3 dies d'estada en l'Hotel Sao Paulo de 4 estrelles.<br>
                   </font></td>
                </tr>
            </table>
    </body>
</html>