package dk.qitsuk.otunes.dataaccess.models;

public class Track {
    private String name;
    private String composer;

    public Track(String name, String composer) {
        this.name = name;
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
