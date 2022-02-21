package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.ArtistDAO;
import dk.qitsuk.otunes.dataaccess.dataaccessobjects.GenreDAO;
import dk.qitsuk.otunes.dataaccess.dataaccessobjects.TrackDAO;
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

    @RequestMapping("/")
    public String home(Model model) {
        trackDAO = new TrackDAO();
        genreDAO = new GenreDAO();


        ArrayList<Track> trackList = trackDAO.get5RandomTracks();
        model.addAttribute("tracks", trackList);
        ArrayList<Genre> genreList = genreDAO.get5RandomGenres();
        model.addAttribute("genres", genreList);
        return "landing_page";
    }
}
