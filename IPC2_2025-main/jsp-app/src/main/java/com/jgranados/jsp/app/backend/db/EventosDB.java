/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.db;

import com.jgranados.jsp.app.backend.eventos.Evento;
import com.jgranados.jsp.app.backend.eventos.TipoEventoEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class EventosDB {

    private static final String CREAR_EVENTO_QUERY = "insert into evento (codigo, nombre, tipo, limite) values (?,?,?,?)";
    private static final String ENCONTRAR_EVENTO_POR_CODIGO_QUERY = "select * from evento where codigo = ?";
    private static final String TODOS_LOS_EVENTOS_QUERY = "select * from evento";
    private static final String ACTUALIZAR_EVENTO_QUERY = "update evento set nombre = ?, tipo = ?, limite = ? where codigo = ?";

    public void crearEvento(Evento evento) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(CREAR_EVENTO_QUERY);) {
            insert.setString(1, evento.getCodigo());
            insert.setString(2, evento.getNombre());
            insert.setString(3, evento.getTipo().toString());
            insert.setInt(4, evento.getLimite());
            insert.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
    }

    public boolean exiteEvento(String codigo) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(ENCONTRAR_EVENTO_POR_CODIGO_QUERY);) {
            query.setString(1, codigo);
            ResultSet result = query.executeQuery();
            return result.next();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return false;
    }

    public List<Evento> obtenerTodosLosEventos() {
        List<Evento> eventos = new ArrayList<>();
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(TODOS_LOS_EVENTOS_QUERY);) {
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                Evento evento = new Evento(resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        TipoEventoEnum.valueOf(resultSet.getString("tipo")),
                        resultSet.getInt("limite")
                );
                eventos.add(evento);
            }
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return eventos;
    }

    public Optional<Evento> obtenerEventoPorCodigo(String codigo) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(ENCONTRAR_EVENTO_POR_CODIGO_QUERY);) {
            query.setString(1, codigo);
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                Evento evento = new Evento(resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        TipoEventoEnum.valueOf(resultSet.getString("tipo")),
                        resultSet.getInt("limite")
                );

                return Optional.of(evento);
            }
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void actualizarEvento(Evento evento) {
        Connection connection = DBConnectionSingleton.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(ACTUALIZAR_EVENTO_QUERY);) {

            insert.setString(1, evento.getNombre());
            insert.setString(2, evento.getTipo().toString());
            insert.setInt(3, evento.getLimite());
            insert.setString(4, evento.getCodigo());
            insert.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
    }
}
