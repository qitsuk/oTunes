package dk.qitsuk.otunes.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Profile("production")
public class ProdConnectionFactory implements DatabaseConnectionFactory {
    static final String URL = "jdbc:sqlite::resources:Chinook_Sqlite.sqlite";
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
