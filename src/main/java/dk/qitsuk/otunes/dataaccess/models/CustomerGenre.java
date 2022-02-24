package dk.qitsuk.otunes.dataaccess.models;

public class CustomerGenre {
    private int MostPopular;
    private String genreName;

    public CustomerGenre(String genreName, int MostPopular) {
        this.genreName = genreName;
        this.MostPopular = MostPopular;
    }

    public String getGenreName() {
        return genreName;
    }


    public int getCount() {
        return MostPopular;
    }

    public void setMostPopular(int mostPopular) {
        this.MostPopular = mostPopular;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;


        }
    }
