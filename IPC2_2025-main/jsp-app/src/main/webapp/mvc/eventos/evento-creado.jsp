<%-- 
    Document   : evento-creado
    Created on : Aug 28, 2025, 3:57:16 PM
    Author     : jose
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.jgranados.jsp.app.backend.eventos.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

    /**
     * no usar session para pasar valores de algun request // extraeyendo del
     * session Evento evento = (Evento) session.getAttribute("eventoCreado");
     */

%>
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

                    <c:if test="${eventoCreado != null}">
                        <div class="card">
                            <div class="card-header">
                                ${eventoCreado.codigo}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${eventoCreado.nombre}</h5>
                                <p class="card-text">Tipo de evento: ${eventoCreado.tipo} - Limite: ${eventoCreado.limite}</p>
                                <a href="#" class="btn btn-primary">Listado de eventos</a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${eventoCreado == null}">
                        <div class="alert alert-danger d-flex align-items-center">
                            <i class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2"></i>
                            <div>
                                ${error}!!!
                            </div> 
                        </div>
                    </c:if>

                </div>


            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>