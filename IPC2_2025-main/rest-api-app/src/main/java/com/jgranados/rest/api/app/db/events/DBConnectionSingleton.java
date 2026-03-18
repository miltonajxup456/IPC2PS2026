/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.db.events;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 *
 * @author jose
 */
public class DBConnectionSingleton {

    private static final String IP = "localhost";
    private static final int PUERTO = 3306;
    private static final String SCHEMA = "eventsdb";
    private static final String USER_NAME = "admindba";
    private static final String PASSWORD = "12345";
    private static final String URL = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + SCHEMA;

    private static DBConnectionSingleton instance;
    
    private DataSource datasource;

    private DBConnectionSingleton() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            PoolProperties p = new PoolProperties();
            //Define a que DB se conecta
            p.setUrl(URL);
            p.setDriverClassName("com.mysql.cj.jdbc.Driver");
            p.setUsername(USER_NAME);
            p.setPassword(PASSWORD);
            
            //Permite monitorear el pool como ver las conexiones
            p.setJmxEnabled(true);
            
            //Prueba conexiones inactivas
            p.setTestWhileIdle(false);
            //Verifica la conexion antes de devolverla
            p.setTestOnBorrow(true);
            //Query simple para probar conexion
            p.setValidationQuery("SELECT 1");
            //Prueba  al devolver la conexion
            p.setTestOnReturn(false);
            //No valida cada vez si lo hizo recientemente
            p.setValidationInterval(30000);
            p.setTimeBetweenEvictionRunsMillis(30000);
            //Tamaño de la pool
            p.setMaxActive(100);
            //Conexiones iniciales
            p.setInitialSize(10);
            //Minimo de conexiones en espera 
            p.setMinIdle(10);
            
            //Si no hay conexiones disponibles, espera 10 seg y luego lanza error
            p.setMaxWait(10000);
            
            //Cierra conexiones que no se esten usando en el tiempo definido
            p.setMinEvictableIdleTimeMillis(30000);
            
            //Elimina una conexion si se abandonó
            p.setLogAbandoned(true);
            p.setRemoveAbandonedTimeout(60);
            p.setRemoveAbandoned(true);
            
            //ConnectionState: optimiza estado interno
            //StatementFinalizer: cierra statements olvidados
            p.setJdbcInterceptors(
                    "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                    + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
            datasource = new DataSource(p);
            datasource.setPoolProperties(p);
            
            /*
            Configuracion minima recomendada
            
            p.setUrl(URL);
            p.setUsername(USER_NAME);
            p.setPassword(PASSWORD);

            p.setMaxActive(20);
            p.setMinIdle(5);
            p.setInitialSize(5);

            p.setTestOnBorrow(true);
            p.setValidationQuery("SELECT 1");
            */
        } catch (ClassNotFoundException ex) {
            System.getLogger(DBConnectionSingleton.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Connection getConnection() {
        try {
            return datasource.getConnection();
        } catch (SQLException ex) {
            System.getLogger(DBConnectionSingleton.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public static DBConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DBConnectionSingleton();
        }
        return instance;
    }

}
