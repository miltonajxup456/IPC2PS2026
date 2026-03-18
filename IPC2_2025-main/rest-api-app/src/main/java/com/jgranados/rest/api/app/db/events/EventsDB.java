/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.db.events;

import com.jgranados.rest.api.app.models.events.Event;
import com.jgranados.rest.api.app.models.events.EventTypeEnum;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class EventsDB {

    private static final String CREAR_EVENTO_QUERY = "insert into evento (codigo, nombre, tipo, limite, fecha_inicio, precio) values (?,?,?,?,?,?)";
    private static final String ENCONTRAR_EVENTO_POR_CODIGO_QUERY = "select * from evento where codigo = ?";
    private static final String TODOS_LOS_EVENTOS_QUERY = "select * from evento";
    private static final String ACTUALIZAR_EVENTO_QUERY = "update evento set nombre = ?, tipo = ?, limite = ?, fecha_inicio = ?, precio = ? where codigo = ?";
    private static final String ELIMINAR_EVENTO_POR_CODIGO_QUERY = "delete from evento where codigo = ?";
    
    private static final Map<String, Event> DB;

    static {
        DB = new HashMap<>();
        DB.put("EVT-123", new Event("EVT-123", "event 123", EventTypeEnum.DEBATE, 15, LocalDate.of(2025, Month.MARCH, 20), 75.0));
        DB.put("EVT-456", new Event("EVT-456", "event 456", EventTypeEnum.CONGRESO, 150, LocalDate.of(2025, Month.JUNE, 21), 350.0));
        DB.put("EVT-789", new Event("EVT-789", "event 789", EventTypeEnum.TALLER, 20, LocalDate.of(2025, Month.OCTOBER, 15), 100.0));
        DB.put("EVT-ABC", new Event("EVT-ABC", "event ABC", EventTypeEnum.CONGRESO, 100, LocalDate.of(2025, Month.NOVEMBER, 5), 375.0));
        DB.put("EVT-DEF", new Event("EVT-DEF", "event DEF", EventTypeEnum.CONGRESO, 200, LocalDate.of(2025, Month.DECEMBER, 1), 400.0));
    }

    public Event createEvent(Event newEvent) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(CREAR_EVENTO_QUERY);) {
            insert.setString(1, newEvent.getCode());
            insert.setString(2, newEvent.getName());
            insert.setString(3, newEvent.getEventType().toString());
            insert.setInt(4, newEvent.getLimit());
            insert.setDate(5, Date.valueOf(newEvent.getStartDate()));
            insert.setDouble(6, newEvent.getPrice());
            insert.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }

        return newEvent;
    }

    public boolean existsEvent(String code) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(ENCONTRAR_EVENTO_POR_CODIGO_QUERY);) {
            query.setString(1, code);
            ResultSet result = query.executeQuery();
            return result.next();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return false;
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(TODOS_LOS_EVENTOS_QUERY);) {
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                Event event = new Event(resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        EventTypeEnum.valueOf(resultSet.getString("tipo")),
                        resultSet.getInt("limite"),
                        resultSet.getDate("fecha_inicio").toLocalDate(),
                        resultSet.getDouble("precio")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return events;
    }

    public Optional<Event> getByCode(String code) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(ENCONTRAR_EVENTO_POR_CODIGO_QUERY);) {
            query.setString(1, code);
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                Event event = new Event(resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        EventTypeEnum.valueOf(resultSet.getString("tipo")),
                        resultSet.getInt("limite"),
                        resultSet.getDate("fecha_inicio").toLocalDate(),
                        resultSet.getDouble("precio")
                );

                return Optional.of(event);
            }
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Event updateEvent(String code, Event eventToUpdate) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(ACTUALIZAR_EVENTO_QUERY);) {

            insert.setString(1, eventToUpdate.getName());
            insert.setString(2, eventToUpdate.getEventType().toString());
            insert.setInt(3, eventToUpdate.getLimit());
            insert.setDate(4, Date.valueOf(eventToUpdate.getStartDate()));
            insert.setDouble(5, eventToUpdate.getPrice());
            insert.setString(6, code);
            insert.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return eventToUpdate;
    }

    public void deleteByCode(String code) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement deleteStatement = connection.prepareStatement(ELIMINAR_EVENTO_POR_CODIGO_QUERY);) {

            deleteStatement.setString(1, code);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
    }
}
