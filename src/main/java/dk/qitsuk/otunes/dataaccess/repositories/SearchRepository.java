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
        String sql = """
                SELECT track.Name As TrackName, album.Title AS Album,
                artist.name AS Artist, genre.Name AS Genre FROM Track AS track
                INNER JOIN Album AS album ON track.AlbumId = album.AlbumId
                INNER JOIN Genre AS genre ON track.GenreId = genre.GenreId
                INNER JOIN Artist artist ON album.ArtistId = artist.ArtistId
                WHERE track.Name LIKE """ + "'%" + searchFor + "%'";
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
