package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackDAO {
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
                        rs.getString("Composer")
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
}
