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
        <div id="menu_inicial2">
            <table class="totample">
            </table>
        </div>
        <br>
        <br>
            <table>
                <tr>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <pre>
                    <jsp:getProperty name="user" property="regconfirmat" />
                    </pre>
                    </font></td>
                </tr>
            </table>
    </body>
</html>
