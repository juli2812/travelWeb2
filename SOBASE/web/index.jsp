<%-- 
    Document   : index
    Created on : 03-nov-2016, 9:00:04
    Author     : BEC.CA2
--%>
<%@page import="cat.urv.deim.sob.Offer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.dao.DAOofertes"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            DAOofertes listaOfertes = new DAOofertes();
        %>
        <title>Viajar te da alas</title>
    </head>
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
                        <font class="text_arial_blanc">Escull continent:
                        </font>
                    </td>
                </tr>
            </table>
        </div>
        <font class="text_arial" align="center">
        <h1>Viajar te da alas</h1>
        </font>
        
        <br>
        <% Offer oferta;
        ArrayList<Offer> ofertes = listaOfertes.getOfertes();
        oferta=ofertes.get(0);
                        %>
            <table class="totample">
                <tr>
                    <td class="borde_gris" colspan="2">
                        <%if(oferta.getAvailable_sits()!=0){%>
                        <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>">
                            <img src="css/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="480px" width="640px" align="left">
                        </a>
                        <%}else{%>
                        <img src="css/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="480px" width="640px" align="left">
                        <b>NO DISPONIBLE, Places esgotades</b><br>
                        <%}%>
                        <font class="text_arial_blanc">
                        <b><%=oferta.getOffer_title() %></b><br><br>
                        Dies d'estada <%=oferta.getStay_days() %><br>
                        Dia sortida: <br>
                        Dia tornada: <br>
                        Places lliures: <%=oferta.getAvailable_sits() %><br>
                        Preu per persona: <%=oferta.getPrice_pperson() %> euros <br>
                        Destinació: <%=oferta.getDestination() %><br>
                        Descripció: <%=oferta.getDescription() %><br></font></td>
                </tr>
                        <%int tamany=ofertes.size();
                        int i=1;%>
                        <%while(true){%><tr><td class="borde_gris_invertido">
                                <%oferta=ofertes.get(i);%>
                                <%if(oferta.getAvailable_sits()!=0){%>
                                <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>">
                                    <img src="css/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                                </a>
                                <%}else{%>
                                <img src="css/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                                <b>NO DISPONIBLE, Places esgotades</b><br>
                                <%}%>
                                <font class="text_arial_blanc">
                        <b><%=oferta.getOffer_title() %></b><br>
                        Dies d'estada <%=oferta.getStay_days() %><br>
                        Dia sortida: <br>
                        Dia tornada: <br>
                        Places lliures: <%=oferta.getAvailable_sits() %><br>
                        Preu per persona: <%=oferta.getPrice_pperson() %> euros <br>
                        Destinació: <%=oferta.getDestination() %><br>
                        Descripció: <%=oferta.getDescription() %><br>
                        </font>
                            </td>
                            <%if(i==tamany-1){%>
                        </tr>
                        <%break;}else i=i+1;%>
                        <td class="borde_gris_invertido">
                            <%oferta=ofertes.get(i);%>
                            <%if(oferta.getAvailable_sits()!=0){%>
                            <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>">
                                <img src="css/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                            </a>
                            <%}else{%>
                            <img src="css/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                            <b>NO DISPONIBLE, Places esgotades</b><br>
                            <%}%>
                            <font class="text_arial_blanc">
                        <b><%=oferta.getOffer_title() %></b><br>
                        Dies d'estada <%=oferta.getStay_days() %><br>
                        Dia sortida: <br>
                        Dia tornada: <br>
                        Places lliures: <%=oferta.getAvailable_sits() %><br>
                        Preu per persona: <%=oferta.getPrice_pperson() %> euros <br>
                        Destinació: <%=oferta.getDestination() %><br>
                        Descripció: <%=oferta.getDescription() %><br>
                        </font>
                        </td>
            </tr>
            <%if(i==tamany-1)break;else i=i+1;}%>
                        </table>
    </body>
</html>
