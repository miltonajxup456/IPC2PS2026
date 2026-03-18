/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.eventos;

import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import com.jgranados.jsp.app.backend.db.EventosDB;
import com.jgranados.jsp.app.backend.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jose
 */
public class ActualizadorEventos {

    public Evento actualizar(HttpServletRequest request) throws UserDataInvalidException,
            EntityNotFoundException {
        EventosDB eventosDb = new EventosDB();
        
        Evento evento = extraer(request);
        
        if (!eventosDb.exiteEvento(evento.getCodigo())) {
            throw new EntityNotFoundException(
                    String.format("El evento con codigo %s no existe", evento.getCodigo()));
        }

        eventosDb.actualizarEvento(evento);
        
        return evento;
    }

    private Evento extraer(HttpServletRequest request) throws UserDataInvalidException {
        try {
            Evento evento = new Evento(
                request.getParameter("codigo"),
                request.getParameter("nombre"),
                TipoEventoEnum.valueOf(request.getParameter("tipo")),
                Integer.valueOf(request.getParameter("limite")));
            
            if (!evento.esValido()) {
                throw new UserDataInvalidException("Error en los datos enviados");
            }
            
            return evento;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
}
