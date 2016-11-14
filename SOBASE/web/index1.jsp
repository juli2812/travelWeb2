<%-- 
    Document   : index
    Created on : 03-nov-2016, 9:00:04
    Author     : BEC.CA2
--%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
        %>
        <title>SafeTravel</title>
    </head>
    </head>
    <body>
        <input type="hidden" name="form_action" value="infoaccount"/>
        <font class="text_arial" align="center"><h1>SafeTravel</h1><font>
        <br>
            <table class="totample">
                <tr>
                    <td class="borde_gris" colspan="2"><img src="css/Dubai.jpg.jpeg" alt="Smiley face" height="800px" width="1000px" align="left"><font class="text_arial_blanc">Benvingut a <b>SafeTravel</b> en aquesta pàgina web trobaràs tot estil de viatjes, esperem que tinguis unes agradables vacances.<br><br><b><a href="controller.do">Entrar a SafeTravel</a></b></font></td>
            </table>
    </body>
</html>
