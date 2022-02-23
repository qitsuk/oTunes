package dk.qitsuk.otunes.dataaccess.repositories;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.SearchResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchRepository {
    private ArrayList<SearchResult> searchResults;
    private Connection conn;

    public ArrayList<SearchResult> getSearchResults(String searchFor) {
        SearchResult searchResult = null;
        searchResults = new ArrayList<>();
        // We know there is a vulnerability here, however, we could not get PreparedStatement to accept
        // the parameter here. We couldn't figure out why. The sql statement joins 4 different tables
        // in order to display what the user searched for. The method returns an ArrayList, because
        // of the wildcard search, which can result in multiple results.
        String sql = """
                SELECT track.Name As TrackName, album.Title AS Album,
                artist.Name AS Artist, genre.Name AS Genre FROM Track AS track
                INNER JOIN Album AS album ON track.AlbumId = album.AlbumId
                INNER JOIN Genre AS genre ON track.GenreId = genre.GenreId
                INNER JOIN Artist artist ON album.ArtistId = artist.ArtistId
                WHERE track.Name LIKE """ + "'%" + searchFor + "%' ORDER BY genre.GenreId ASC";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                searchResults.add(searchResult = new SearchResult(
                        rs.getString("TrackName")
                ));
                searchResult.setAlbum(rs.getString("Album"));
                searchResult.setArtist(rs.getString("Artist"));
                searchResult.setGenre(rs.getString("Genre"));
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
        return searchResults;
    }
}
