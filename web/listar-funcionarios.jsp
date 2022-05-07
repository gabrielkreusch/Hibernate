<%-- 
    Document   : listar.jsp
    Created on : Mar 18, 2022, 5:32:43 AM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="model.Funcionario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listagem de funcionarios</h1>
        <%
            
        // goncalves2007, pg 420
        ArrayList<Funcionario> registros = (ArrayList<Funcionario>) request.getAttribute("registros");
                 
        for (Funcionario i : registros) {
        
        %>

        <%= i.getNome() %>, <%= i.getCargo() %>, <%= i.getSalario() %> <br>

        <%
            }
        %>

        Fim da listagem

    </body>
</html>
