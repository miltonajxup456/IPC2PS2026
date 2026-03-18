/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jgranados.jsp.app.mvc.controller.eventos;

import com.jgranados.jsp.app.backend.eventos.ActualizadorEventos;
import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import com.jgranados.jsp.app.backend.eventos.CreadorEventos;
import com.jgranados.jsp.app.backend.eventos.Evento;
import com.jgranados.jsp.app.backend.exceptions.EntityAlreadyExistsException;
import com.jgranados.jsp.app.backend.exceptions.EntityNotFoundException;
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
@WebServlet(name = "ActualizarEventoControllerServlet", urlPatterns = {"/mvc/eventos/actualizar-eventos-servlet"})
public class ActualizarEventoControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActualizadorEventos actualizadorEventos = new ActualizadorEventos();
        try {
            Evento eventoActualizado = actualizadorEventos.actualizar(request);

            request.setAttribute("eventoActualizado", eventoActualizado);
        } catch (UserDataInvalidException | EntityNotFoundException e) {
            request.setAttribute("error", e.getMessage());
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/mvc/eventos/evento-actualizado.jsp");
        dispatcher.forward(request, response);

    }
}
