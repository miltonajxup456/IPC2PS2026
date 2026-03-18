<%-- 
    Document   : listado
    Created on : Sep 3, 2025, 3:24:09 PM
    Author     : jose
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/includes/resources.jsp"/>
        <script src="${pageContext.servletContext.contextPath}/resources/js/eventos-ajax.js"></script>
    </head>
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>

            <div class="container text-center">
                <button type="button" class="btn btn-primary" onclick="cargarAjaxData('${pageContext.servletContext.contextPath}')">
                    <i class="bi bi-search"></i>
                    Buscar Eventos
                </button>
            </div>

            <div id="listado" class="container">

                aqui se carga la data usando ajax



            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
