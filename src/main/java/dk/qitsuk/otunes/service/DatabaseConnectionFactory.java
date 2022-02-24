package dk.qitsuk.otunes.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionFactory {
    Connection getConnection() throws SQLException;
}
