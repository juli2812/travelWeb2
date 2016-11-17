<%-- 
    Document   : registre_confirmat
    Created on : 07-nov-2016, 12:50:51
    Author     : BEC.CA2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
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
        </div><div id="menu_inicial2" >
            <table class="totample">
                <tr>
                    <td id="barra_inici2">
                        <font class="text_arial_blanc"><h2>Registre confirmat</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <br>
            <table class="totample">
                <tr>
                    <td class="borde_gris"><font class="text_arial_blanc"><img src="images/tick_verde.jpg" alt="Smiley face" height="170px" width="170px" align="right">
                        <jsp:getProperty name="user" property="regconfirmat"/><br>
                        Benvingut a SafeTravel, esperem que tingui unes vacances espectaculars i qualsevol cosa
                        <br>no dubti en contacar amb dubtes@safetravel.com.
                    </font></td>
                </tr>
            </table>
    </body>
</html>
