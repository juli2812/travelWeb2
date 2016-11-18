<%-- 
    Document   : login
    Created on : 03-nov-2016, 12:03:44
    Author     : BEC.CA2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            int idOferta2=0;
            if(null!=request.getParameter("idOferta")&&!("").equals(request.getParameter("idOferta"))){
            idOferta2=Integer.parseInt(request.getParameter("idOferta"));}
            int placesRes2=0;
            if(null!=request.getParameter("placesReserva")&&!("").equals(request.getParameter("placesReserva"))){
            placesRes2=Integer.parseInt(request.getParameter("placesReserva"));}
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
                        <font class="text_arial_blanc"><h2>Login</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
                    <%-- El login comprova que la relació pass & user sigui la correcta, 
                    sino ens torna a demanar login mostrant missatge d'error--%>
        <br><br>
        <form method="post" action="controller.do"> 
        <%if(!("").equals(request.getParameter("idOferta"))&&idOferta2!=0){%>
        <input type="hidden" name="idOferta3" value="<%=idOferta2%>"/>
        <input type="hidden" name="placesRes3" value="<%=placesRes2%>"/>
        <input type="hidden" name="form_action" value="logintooffer"/>
        <%}else{%>
        <input type="hidden" name="form_action" value="login"/>
        <%}%>
            <table id="taula_login">
                <tr>
                    <td class="text_esquerra"><b>Usuari:</b></td>
                    <td class="content_dreta">
                        <input type="text" size="20" name="alias" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Contrasenya:</b></td>
                    <td class="content_dreta">
                        <input    type="password" size="20" name="pass">
                    </td>
                </tr>
                <tr>   
                    <td class="error" colspan="2"><b>
                        <%
                            if((request.getParameter("dadesErronees")!=null) && request.getParameter("dadesErronees").equals("true")){
                                 out.println("Dades èrronees");
                        }
                            %></b>
                    </td>
                </tr>
                <tr >
                    <td colspan="2" class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Login"></td>         
                    
                </tr>
                <tr>
                    <td colspan="2" class="contingut_centre"><a class="text_arial_href_blau" href="register.jsp"><b>Registrar nou usuari</b></a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
