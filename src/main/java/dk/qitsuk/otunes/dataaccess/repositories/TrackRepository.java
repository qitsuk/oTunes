package dk.qitsuk.otunes.dataaccess.repositories;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackRepository {
    private ArrayList<Track> trackList;
    private Connection conn;

    public ArrayList<Track> get5RandomTracks() {
        trackList = new ArrayList<>();
        String sql = "SELECT * FROM Track ORDER BY RANDOM() LIMIT 5";

        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trackList.add(new Track(
                        rs.getString("Name"),
                        rs.getString("Composer"),
                        0, 0
                ));
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
        return trackList;
    }

    public Track findTrackByName(String search) {
        Track track = null;
        String sql = "SELECT * FROM Track WHERE Name LIKE ?";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, search);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                track = new Track(
                        rs.getString("Name"),
                        rs.getString("Composer"),
                        rs.getInt("AlbumId"),
                        rs.getInt("GenreId")
                );
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
        return track;
    }
}
