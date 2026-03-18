<%-- 
    Document   : data-eventos
    Created on : Sep 5, 2025, 4:55:47 PM
    Author     : jose
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Codigo</th>
            <th scope="col">Nombre</th>
            <th scope="col">Tipo</th>
            <th scope="col">Limite</th>
            <th scope="col">Opciones</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${eventos}" var="evento">
            <tr>
                <th scope="row">${evento.codigo}</th>
                <td>${evento.nombre}</td>
                <td>${evento.tipo}</td>
                <td>${evento.limite}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/mvc/eventos/eventos-servlet?codigo=${evento.codigo}" class="btn btn-primary">
                        <i class="bi bi-pencil-square"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>

