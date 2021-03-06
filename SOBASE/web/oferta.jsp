<%-- 
    Document   : oferta
    Created on : 03-nov-2016, 10:32:22
    Author     : BEC.CA2
--%>

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
            int id_oferta = Integer.parseInt(request.getParameter("id_oferta"));
            DAOofertes d_offer= new DAOofertes();
            Offer oferta = d_offer.getOferta(id_oferta);
            int placesRes=0;
            if(null!=request.getParameter("placesReserva")&&!("").equals(request.getParameter("placesReserva"))){
            placesRes=Integer.parseInt(request.getParameter("placesReserva"));}
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
                        
                        <a class="text_arial_href" href="login.jsp?idOferta=<%=oferta.getOffer_id()%>"><b>Iniciar Sessió </b></a> <font class="text_arial_href"><b>|</b></font> <a class="text_arial_href" href="register.jsp"><b>Registrar-se</b></a>
                        
                        <%}%>
                    </td>
                </tr>
            </table>
        </div>
        <div id="menu_inicial2" >
            <table class="totample">
                <tr>
                    <td id="barra_inici2">
                        <font class="text_arial_blanc"><h2>Oferta</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
        <%-- En aquesta jsp mostrem la oferta que s'ha seleccionat però amb més detall, és a dir,
        una descripció més llarga--%>     
        <br>
            <table class="totample">
                <tr>
                    <td class="borde_gris"><img src="images/<%=oferta.getDestination()%>.jpg" alt="Smiley face" height="480px" width="640px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2><%=oferta.getOffer_title() %></h2>
                    <b>Dies d'estada: </b><%=oferta.getStay_days() %><br>
                    <b>Dia sortida: </b><%=oferta.getDeparture_dateString() %><br>
                    <b>Dia tornada: </b><%=oferta.getArrival_dateString() %><br>
                    <b>Places lliures: </b><%=oferta.getAvailable_sits() %><br>
                    <b>Preu per persona: </b><%=oferta.getPrice_pperson() %> euros <br>
                    <b>Destinació: </b><%=oferta.getDestination() %><br>
                    <b>Descripció: </b><%=oferta.getBig_description() %>
                    <form name="updateAccount" action="controller.do" method="post">
                        <table id="taula_login">
                            <tr>
                                <td class="text_esquerra"><br><b>Places a reservar:</b></td>
                                <td class="content_dreta"><br>
                                    <%if(placesRes!=0){%>
                                    <input type="number" size="3" name="placesReserva" min="1" value=<%=placesRes%> autofocus/>
                                    <%}else{%>
                                    <input type="number" size="3" name="placesReserva" min="1" autofocus/>
                                    <%}%>
                                </td>
                            </tr>
                            <tr>
                                <%if(userLogin!=null){%>
                            <input type="hidden" name="form_action" value="reservar"/>
                                <%session.setAttribute("preuPers", oferta.getPrice_pperson());%>
                                <%session.setAttribute("placesDisp", oferta.getAvailable_sits());%>
                                <%session.setAttribute("idOferta", oferta.getOffer_id());%>
                                <%String j="1"; session.setAttribute("first", j);%>
                                <%}else{%>
                                <input type="hidden" name="form_action" value="offertologin"/>
                                <input type="hidden" name="idOferta" value="<%=oferta.getOffer_id()%>"/>
                                <input type="hidden" name="first" value="1"/>
                                <%}%>
                                <td><button onclick="history.back()">Enrere</button></td>
                                <%if(userLogin!=null){%>
                                <td class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Reservar"></td>         
                                <%}else{%>
                                <td class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Login"></td>         
                                <%}%>
                            </tr>
                            <tr><td colspan="2">
                                    <font class="error">
                                        
                                    <%
                                        if(null!=request.getParameter("error")&&("true").equals(request.getParameter("error"))){
                                        out.println("<br><b>Error, no hi ha tantes places disponibles o has indroduït 0.</b>");}
                            %>
                                    </font></td></tr>
                        </table>
                    </form></font></td>
                </tr>
            </table>
    </body>
</html>
