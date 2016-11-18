<%-- 
    Document   : index
    Created on : 03-nov-2016, 9:00:04
    Author     : BEC.CA2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.Offer"%>
<%@page import="cat.urv.deim.dao.DAOofertes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            DAOofertes listaOfertes = new DAOofertes();
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
                        <font class="text_arial_blanc"><h2>Llistat d'ofertes</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
        <%-- En aquesta jsp mostrem totes les ofertes disponibles, i també les que s'han esgotat, 
        si està disponible podrem accedir a la oferta, si està esgotada no ens ho permet--%>
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
                            <img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="480px" width="640px" align="left">
                        </a>
                        <%}else{%>
                        <img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="480px" width="640px" align="left">
                        <font class="no_disp"><b>NO DISPONIBLE, Places esgotades</b><br></font>
                        <%}%>
                        <font class="text_arial_blanc">
                        <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>">
                        <font class="text_arial_href">
                        <b><%=oferta.getOffer_title() %></b>
                        </font>
                        </a><br><br>
                        <b>Dies d'estada: </b><%=oferta.getStay_days() %><br>
                        <b>Dia sortida: </b><%=oferta.getDeparture_dateString() %><br>
                        <b>Dia tornada: </b><%=oferta.getArrival_dateString() %><br>
                        <b>Places lliures: </b><%=oferta.getAvailable_sits() %><br>
                        <b>Preu per persona: </b><%=oferta.getPrice_pperson() %> euros <br>
                        <b>Destinació: </b><%=oferta.getDestination() %><br>
                        <b>Descripció: </b><%=oferta.getDescription() %><br></font></td>
                </tr>
                        <%int tamany=ofertes.size();
                        int i=1;%>
                        <%while(true){%><tr><td class="borde_gris_invertido">
                                <%oferta=ofertes.get(i);%>
                                <%if(oferta.getAvailable_sits()!=0){%>
                                <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>">
                                    <img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                                </a>
                                <%}else{%>
                                <img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                                <font class="no_disp"><b>NO DISPONIBLE, Places esgotades</b><br></font>
                                <%}%>
                                <font class="text_arial_blanc">
                                <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>"><font class="text_arial_href"><b><%=oferta.getOffer_title() %></b></font></a><br>
                        <b>Dies d'estada: </b><%=oferta.getStay_days() %><br>
                        <b>Dia sortida: </b><%=oferta.getDeparture_dateString() %><br>
                        <b>Dia tornada: </b><%=oferta.getArrival_dateString() %><br>
                        <b>Places lliures: </b><%=oferta.getAvailable_sits() %><br>
                        <b>Preu per persona: </b><%=oferta.getPrice_pperson() %> euros <br>
                        <b>Destinació: </b><%=oferta.getDestination() %><br>
                        <b>Descripció: </b><%=oferta.getDescription() %><br>
                        </font>
                            </td>
                            <%if(i==tamany-1){%>
                        </tr>
                        <%break;}else i=i+1;%>
                        <td class="borde_gris_invertido">
                            <%oferta=ofertes.get(i);%>
                            <%if(oferta.getAvailable_sits()!=0){%>
                            <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>">
                                <img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                            </a>
                            <%}else{%>
                            <img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="240px" width="240px" align="left">
                            <font class="no_disp"><b>NO DISPONIBLE, Places esgotades</b><br></font>
                            <%}%>
                            <font class="text_arial_blanc">
                            <a  href="oferta.jsp?id_oferta=<%=oferta.getOffer_id()%>"><font class="text_arial_href"><b><%=oferta.getOffer_title() %></b></font></a><br>
                        <b>Dies d'estada: </b><%=oferta.getStay_days() %><br>
                        <b>Dia sortida: </b><%=oferta.getDeparture_dateString() %><br>
                        <b>Dia tornada: </b><%=oferta.getArrival_dateString() %><br>
                        <b>Places lliures: </b><%=oferta.getAvailable_sits() %><br>
                        <b>Preu per persona: </b><%=oferta.getPrice_pperson() %> euros <br>
                        <b>Destinació: </b><%=oferta.getDestination() %><br>
                        <b>Descripció: </b><%=oferta.getDescription() %><br>
                        </font>
                        </td>
            </tr>
            <%if(i==tamany-1)break;else i=i+1;}%>
                        </table>
    </body>
</html>
