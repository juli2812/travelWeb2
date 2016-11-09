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
        <font class="text_arial"><h1>Iniciar sessió</h1><font>
        <form method="post" action="controller.do"> 
        <input type="hidden" name="form_action" value="login"/>
            <table id="taula_login">
                <tr>
                    <td class="text_esquerra"><b>Usuari:</b></td>
                    <td class="content_dreta">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
                        <input type="text" size="20" name="alias" autofocus/>
                    </td>
                </tr>
                <tr>
                    <td class="text_esquerra"><b>Contrasenya:</b></td>
                    <td class="content_dreta">
                        <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                        associated with the onkeyup event -->
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
