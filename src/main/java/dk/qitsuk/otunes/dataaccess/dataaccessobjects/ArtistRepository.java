package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistRepository {
    private ArrayList<Artist> artistList;
    private Connection conn;

    public ArrayList<Artist> get5RandomArtists() {
        artistList = new ArrayList<>();
        String sql = "SELECT * FROM Artist ORDER BY RANDOM() LIMIT 5";

        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                artistList.add(new Artist(rs.getString("Name")));
            }
        } catch(SQLException sqe) {
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
        return artistList;
    }

}
