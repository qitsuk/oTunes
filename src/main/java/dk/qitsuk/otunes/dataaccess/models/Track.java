package dk.qitsuk.otunes.dataaccess.models;

public class Track {
    private String name;
    private String composer;
    private int albumId;
    private int genreId;

    public Track(String name, String composer, int albumId, int genreId) {
        this.name = name;
        this.albumId = albumId;
        this.genreId = genreId;
        if (composer == null) {
            this.composer = "No composer info found.";
        } else {
            this.composer = composer;
        }
    }


    // Region Getters And Setters
    public String getName() {
        return name;
    }

    public String getComposer() {
        return composer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    // endregion
}
