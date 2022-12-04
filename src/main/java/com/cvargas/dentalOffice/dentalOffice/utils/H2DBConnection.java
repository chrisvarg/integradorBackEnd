package com.cvargas.dentalOffice.dentalOffice.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class H2DBConnection {

    // TODO: Hacer logica para traer las credenciales (user, password) de la DB por JSON...

    public static final Logger logger = Logger.getLogger(H2DBConnection.class);
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:~/dental_office";
    public static final String CREATE_QUERY_PATH = "createSQL/dentalOffice.sql";
    public static final String USER = "dev";
    public static final String PASSWORD = "";

    public static Connection getConnection(){

        Connection conn = null;
        try {
            // Registrar el driver
            Class.forName(JDBC_DRIVER);

            // Abrir la conexión
            logger.info("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // atrapa los errores de la DB
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Error al conectar a la base de datos.", e );
        }
        return conn;

    }

    // TODO: Hacer test de la clase .....
    public static boolean createH2DB() throws SQLException {
        boolean result = false;
        String createQuery = String.format("%s;INIT=RUNSCRIPT FROM '%s'", DB_URL, CREATE_QUERY_PATH);
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);

            // se conecta a la base de datos y crea las tablas del sistema.
            conn = DriverManager.getConnection(createQuery, USER, PASSWORD);

        }catch (Exception e) {
            logger.error("La base de datos no pudo crear.", e);

        } finally {
            try {
                conn.close();
                logger.info("La base de datos ha sido creada...");
                result = true;
            } catch (NullPointerException np){
                logger.error("No se logro conecto la base de datos.", np);
            }
        }
        return result;
    }


}
