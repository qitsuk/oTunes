package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.ArtistDAO;
import dk.qitsuk.otunes.dataaccess.dataaccessobjects.GenreDAO;
import dk.qitsuk.otunes.dataaccess.dataaccessobjects.TrackDAO;
import dk.qitsuk.otunes.dataaccess.models.Artist;
import dk.qitsuk.otunes.dataaccess.models.Genre;
import dk.qitsuk.otunes.dataaccess.models.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    private TrackDAO trackDAO;
    private GenreDAO genreDAO;
    private ArtistDAO artistDAO;

    @RequestMapping("/")
    public String home(Model model) {
        trackDAO = new TrackDAO();
        genreDAO = new GenreDAO();
        artistDAO = new ArtistDAO();


        ArrayList<Track> trackList = trackDAO.get5RandomTracks();
        ArrayList<Genre> genreList = genreDAO.get5RandomGenres();
        ArrayList<Artist> artistList = artistDAO.get5RandomArtists();
        model.addAttribute("tracks", trackList);
        model.addAttribute("genres", genreList);
        model.addAttribute("artists", artistList);
        return "landing_page";
    }
}
