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
    </head>
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>


            <div class="container text-center">
                <a href="${pageContext.servletContext.contextPath}/mvc/eventos/crear-form.jsp" class="btn btn-primary">
                    <i class="bi bi-file-earmark-plus"></i>
                    Crear Evento
                </a>
            </div>
            <div class="container">

                <c:forEach items="${eventos}" var="evento">
                    <div class="card">
                        <div class="card-header">
                            ${evento.codigo}
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${evento.nombre}</h5>
                            <p class="card-text">Tipo de evento: ${evento.tipo} - Limite: ${evento.limite}</p>
                            <a href="${pageContext.servletContext.contextPath}/mvc/eventos/eventos-servlet?codigo=${evento.codigo}" class="btn btn-primary">Editar evento</a>
                        </div>
                    </div>
                </c:forEach>



            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
