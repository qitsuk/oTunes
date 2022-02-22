package dk.qitsuk.otunes.dataaccess.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDBConnector {

    private final static String URL = "jdbc:sqlite:src/main/resources/Chinook_Sqlite.sqlite";
    private static SQLiteDBConnector instance;
    private static Connection connection;
    public static SQLiteDBConnector getInstance() {
        if (instance == null) {
            instance = new SQLiteDBConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        try  {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        }
        return connection;
    }
}
