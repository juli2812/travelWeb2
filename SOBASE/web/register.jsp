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
        </div>
        <div id="menu_inicial2" >
            <table class="totample">
                <tr>
                    <td id="barra_inici2">
                        <font class="text_arial_blanc"><h2>Registrar-se</h2>
                        </font>
                    </td>
                </tr>
            </table>
        </div>
                    <br><br>
        <form action="controller.do" method="post">
        <input type="hidden" name="form_action" value="register" accept-charset="UTF-8"/>
        <table id="taula_login">
                <tr>
                    <td class="text_esquerra"><b>Usuari:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("alias")!=null){%>
                        <input type="text" size="20" name="alias"  value="<%=request.getParameter("alias")%>"autofocus/>
                        <%}else{%>
                        <input type="text" size="20" name="alias" autofocus/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Contrasenya:</b></td>
                    <td class="text_esquerra">
                        <input type="password" size="20" name="pass" value="">
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Nom:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("first_name")!=null){%>
                        <input type="text" size="20" name="first_name"  value="<%=request.getParameter("first_name")%>"/>
                        <%}else{%>
                        <input type="text" size="20" name="first_name"/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Primer cognom:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("last_name")!=null){%>
                        <input type="text" size="12" name="last_name"  value="<%=request.getParameter("last_name")%>"/>
                        <%}else{%>
                        <input type="text" size="12" name="last_name"/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Segon cognom:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("last_name2")!=null){%>
                        <input type="text" size="12" name="last_name2"  value="<%=request.getParameter("last_name2")%>"/>
                        <%}else{%>
                        <input type="text" size="12" name="last_name2"/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Data naixement (AAAA-MM-DD):</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("data_naix")!=null){%>
                        <input type="text" size="20" name="data_naix"  value="<%=request.getParameter("data_naix")%>"/>
                        <%}else{%>
                        <input type="text" size="20" name="data_naix"/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Sexe: </b></td>
                    <td><input type="radio" name="sexe" value="Home" checked>HOME<input type="radio" name="sexe" value="Dona">DONA</td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Adreça:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("address")!=null){%>
                        <input type="text" size="50" name="address"  value="<%=request.getParameter("address")%>"/>
                        <%}else{%>
                        <input type="text" size="50" name="address"/>
                        <%}%>
                    </td>
                </tr><tr>
                    <td class="text_esquerra"><b>Telèfon:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("phone")!=null){%>
                        <input type="text" size="9" name="phone"  value="<%=request.getParameter("phone")%>"/>
                        <%}else{%>
                        <input type="text" size="9" name="phone"/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>E-mail:</b></td>
                    <td class="text_esquerra">
                        <%if(request.getParameter("email")!=null){%>
                        <input type="text" size="50" name="email"  value="<%=request.getParameter("email")%>"/>
                        <%}else{%>
                        <input type="text" size="50" name="email"/>
                        <%}%>
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
                                 out.println("<br>Camp primer cognom obligatori, limitació de 12 caràcters.");
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
                                 out.println("<br>Camp email obligatori, limitació de 50 caràcters.");
                        }
                            %>
                            <%
                            if((request.getParameter("codiError")!=null) && request.getParameter("codiError").equals("9")){
                                 out.println("<br>Camp segon cognom obligatori, limitació de 12 caràcters.");
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
                    <table>
                        <tr>
                            <td><h2>Normes a seguir pel registre:</h2>
                                Camp usuari obligatori, amb mida de 8 a 10 caràcters.
                                <br>Camp contrasenya obligatori, amb mida de 8 a 10 caràcters.
                                <br>Camp nom obligatori, limitació a 20 caràcters.
                                <br>Camp primer cognom obligatori, limitació de 12 caràcters.
                                <br>Segon cognom no és obligatori però segueix la mateixa norma.
                                <br>Camp data naixement obligatori, respecta el format.
                                <br>Camp adreça obligatoria, limitació de 50 caràcters, utilitza abreviacions.
                                <br>Camp telèfon si l'introdueixes ha de tenir 9 dígits.
                                <br>Camp email obligatori, limitació de 50 caràcters.
                                <br>Moltes gràcies per respectar les normes.
                            </td>
                        </tr>
                    </table>
        </form>
    </body>
</html>
