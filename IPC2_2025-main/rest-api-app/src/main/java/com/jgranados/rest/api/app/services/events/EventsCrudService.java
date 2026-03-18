/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.services.events;

import com.jgranados.jsp.app.backend.exceptions.EntityNotFoundException;
import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import com.jgranados.rest.api.app.db.events.EventsDB;
import com.jgranados.rest.api.app.dtos.events.UpdateEventRequest;
import com.jgranados.rest.api.app.models.events.Event;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class EventsCrudService {
    
    public List<Event> getAllEvents() {
        EventsDB eventsDb = new EventsDB();

        return eventsDb.getAllEvents();
    }

    public Event getEventByCode(String code) throws EntityNotFoundException {
        EventsDB eventsDb = new EventsDB();
        Optional<Event> eventoOpt = eventsDb.getByCode(code);
        if (eventoOpt.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("El evento con codigo %s no existe", code)
            );
        }

        return eventoOpt.get();
    }
    
    public Event updateEvent(String code, UpdateEventRequest updateEventRequest) throws UserDataInvalidException,
            EntityNotFoundException {
        EventsDB eventsDb = new EventsDB();
        
        Event event = getEventByCode(code);
        
        event.setEventType(updateEventRequest.getEventType());
        event.setLimit(updateEventRequest.getLimit());
        event.setName(updateEventRequest.getName());
        event.setPrice(updateEventRequest.getPrice());
        event.setStartDate(updateEventRequest.getStartDate());
        
        if (!event.isValid()) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }

        eventsDb.updateEvent(code, event);
        
        return event;
    }
    
    public void deleteEventByCode(String code) throws EntityNotFoundException {
        EventsDB eventsDb = new EventsDB();
        Optional<Event> eventoOpt = eventsDb.getByCode(code);
        if (eventoOpt.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("El evento con codigo %s no existe", code)
            );
        }

        eventsDb.deleteByCode(code);
    }
}
