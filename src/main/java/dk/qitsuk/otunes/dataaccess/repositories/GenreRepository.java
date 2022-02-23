package dk.qitsuk.otunes.dataaccess.repositories;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreRepository {
    private ArrayList<Genre> genreList;
    private Connection conn;

    public ArrayList<Genre> get5RandomGenres() {
        genreList = new ArrayList<>();
        String sql = "SELECT * FROM Genre ORDER BY RANDOM() LIMIT 5";

        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                genreList.add(new Genre(rs.getString("Name")));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return genreList;
    }
}