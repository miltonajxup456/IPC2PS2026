/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jgranados.jsp.app.mvc.controller.eventos.ajax;

import com.jgranados.jsp.app.backend.eventos.ConsultaEventos;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "EventosAjaxControllerServlet", urlPatterns = {"/mvc/eventos/ajax/eventos-servlet"})
public class EventosAjaxControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultaEventos consultaEventos = new ConsultaEventos();

        request.setAttribute("eventos", consultaEventos.obtenerTodosLosEventos());
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/mvc/eventos/ajax/data-eventos.jsp");
        dispatcher.forward(request, response);
    }

}
