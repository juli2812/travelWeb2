<%@ page language="java" isErrorPage="true" import="java.io.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <title>Error page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1>Error page</h1>
        <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
        <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
        <% if (response.getStatus() == 500) { %>
        <p><b>Cause:</b> <%=exception.getMessage()%></p>
        <p><b>Cause:</b><br /><%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%></p><%}%><br />
        <button onclick="history.back()">Go back</button>
        
    </body>
</html>