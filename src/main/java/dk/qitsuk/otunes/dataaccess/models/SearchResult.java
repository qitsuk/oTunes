package dk.qitsuk.otunes.dataaccess.models;

import nonapi.io.github.classgraph.json.Id;

public class SearchResult {
    @Id
    private String trackName;
    private String album;
    private String artist;
    private String genre;


    public SearchResult (String trackName) {
        this.trackName = trackName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
