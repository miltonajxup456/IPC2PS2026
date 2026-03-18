/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.eventos;

import com.jgranados.jsp.app.backend.db.EventosDB;
import com.jgranados.jsp.app.backend.exceptions.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class ConsultaEventos {

    public List<Evento> obtenerTodosLosEventos() {
        EventosDB eventosDb = new EventosDB();

        return eventosDb.obtenerTodosLosEventos();
    }

    public Evento obtenerEventoPorCodigo(String codigo) throws EntityNotFoundException {
        EventosDB eventosDB = new EventosDB();
        Optional<Evento> eventoOpt = eventosDB.obtenerEventoPorCodigo(codigo);
        if (eventoOpt.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("El evento con codigo %s no existe", codigo)
            );
        }

        return eventoOpt.get();
    }
}
