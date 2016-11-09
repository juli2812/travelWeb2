<%-- 
    Document   : register
    Created on : 03-nov-2016, 12:22:09
    Author     : BEC.CA2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="cat.urv.deim.sob.User" scope="request" />
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <title>Viajar te da alas</title>
    </head>
    <body>
        <div id="menu_inicial">
            <table class="totample">
                <tr>
                    <td id="barra_inici">
                        <a class="text_arial_href" href="login.jsp"><b>Iniciar Sessió</b></a> <font class="text_arial_href"><b>|</b></font> <a class="text_arial_href" href="register.jsp"><b>Registrar-se</b></a>
                    </td>
                </tr>
            </table>
        </div>
        <div id="menu_inicial2" >
            <table class="totample">
            </table>
        </div>
        <font class="text_arial"><h1>Registrar-se</h1><font>
        <form action="controller.do" method="post">
        <input type="hidden" name="form_action" value="register"/>
            <table id="taula_login">
                <tr>
                    <td class="text_esquerra"><b>Usuari:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="20" name="alias" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Contrasenya:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input    type="password" size="20" name="pass">
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Nom:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="20" name="first_name" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Primer cognom:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="12" name="last_name" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Segon cognom:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="12" name="last_name2" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Data naixement (AAAA-MM-DD):</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="20" name="data_naix" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Adreça:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="50" name="address" autofocus/>
                    </td>
                </tr><tr>
                    <td class="text_esquerra"><b>Telèfon:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="9" name="phone" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>E-mail:</b></td>
                    <td class="text_esquerra">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="50" name="email" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="error" colspan="2"><b>
                        <%
                            if((request.getParameter("totCorrecte")!=null) && request.getParameter("totCorrecte").equals("false")){
                                 out.println("Dades èrronees");
                        }
                            %></b>
                        <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("1")){
                                 out.println("<br>Camp usuari obligatori, amb mida de 8 a 10 caràcters.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("2")){
                                 out.println("<br>Camp contrasenya obligatori, amb mida de 8 a 10 caràcters.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("3")){
                                 out.println("<br>Camp nom obligatori, limitació a 20 caràcters.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("4")){
                                 out.println("<br>Camp primer cognom obligatori, limitació de 12 caràcters");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("5")){
                                 out.println("<br>Camp data naixement obligatori, respecta el format.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("6")){
                                 out.println("<br>Camp adreça obligatoria, limitació de 50 caràcters, utilitza abreviacions.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("7")){
                                 out.println("<br>Camp telèfon si l'introdueixes ha de tenir 9 dígits.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("8")){
                                 out.println("<br>Camp email obligatori, limitació de 50 caràcters");
                        }
                            %>
                    </td>
                </tr>
                <tr >
                    <td colspan="2" class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Confirmar"></td>         
                    
                </tr>
                <tr>
                    <td colspan="2" class="contingut_centre"><a class="text_arial_href_blau" href="login.jsp"><b>Ja tinc usuari</b></a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
