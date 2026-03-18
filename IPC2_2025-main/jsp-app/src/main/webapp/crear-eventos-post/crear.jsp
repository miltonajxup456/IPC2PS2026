<%-- 
    Document   : crear
    Created on : Aug 26, 2025, 4:48:11 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>
            <div class="container">

                <div class="row">
                    <% if (request.getParameter("codigo") == null
                                || request.getParameter("codigo").isBlank()
                                || request.getParameter("nombre") == null
                                || request.getParameter("limite") == null) {
                    %>
                    <div class="bd-callout bd-callout-danger">
                        <p>Es obligatorio el codigo y el nombre y el limete</p> 
                    </div>
                    <%
                    } else {
                    %>
                    <h1>Evento creado: Codigo: ${param.codigo} , Nombre: ${param.nombre}, Limite: ${param.limite}</h1>
                    <%
                        }
                    %>
                </div>
            </div>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
