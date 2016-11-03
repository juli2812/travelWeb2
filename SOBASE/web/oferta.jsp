<%-- 
    Document   : exemple
    Created on : 03-nov-2016, 10:32:22
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
                    <td class="borde_gris"><img src="css/playa.jpeg" alt="Smiley face" height="480px" width="640px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2>Estada a Brasil</h2>
                    Destí: Brasil<br><br>
                    Temps d'estada: 7 dies<br><br>
                    Preu: 3288,78 euros<br><br>
                    Dia sortida: 27 d'abril de 2017<br><br>
                    Dia tornada: 4 de maig de 2017<br><br>
                    Places disponibles: 17<br><br>
                    Companyia d'avió: Luftansa<br><br><br>
                    L'estada a Brasil inclou 4 dies en l'Hotel Rio de Janeiro de 5 estrelles amb vistes a la platja, i després 3 dies d'estada en l'Hotel Sao Paulo de 4 estrelles.<br>
                    <form name="updateAccount" action="controller.do" method="post">
                        <table id="taula_login">
                            <tr>
                                <td class="text_esquerra"><b>Places a reservar:</b></td>
                                <td class="content_dreta">
                                    <!-- Input form field whose id is set as "userid" and "validateUserId()" function is
                                    associated with the onkeyup event -->
                                    <input type="text" size="3" name="idUser" autofocus/>
                                </td>
                            </tr>
                            <tr >
                                <td class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Reservar"></td>         

                            </tr>
                        </table>
                    </form></font></td>
                </tr>
                <tr><td class="borde_gris" colspan="2"><font class="text_arial_blanc">
                        L'estada a Brasil inclou 4 dies en l'Hotel Rio de Janeiro de 5 estrelles amb vistes a la platja, i després 3 dies d'estada en l'Hotel Sao Paulo de 4 estrelles.</font></td>
                </tr>
            </table>
    </body>
</html>
