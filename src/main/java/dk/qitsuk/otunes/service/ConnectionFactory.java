package dk.qitsuk.otunes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    static final String URL = "jdbc:sqlite:src/main/resources/Chinook_Sqlite.sqlite";

    static public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
}}
