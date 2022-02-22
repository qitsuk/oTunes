package dk.qitsuk.otunes.controllers;

import dk.qitsuk.otunes.dataaccess.dataaccessobjects.ArtistRepository;
import dk.qitsuk.otunes.dataaccess.dataaccessobjects.GenreRepository;
import dk.qitsuk.otunes.dataaccess.dataaccessobjects.TrackRepository;
import dk.qitsuk.otunes.dataaccess.models.Artist;
import dk.qitsuk.otunes.dataaccess.models.Genre;
import dk.qitsuk.otunes.dataaccess.models.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    private TrackRepository trackRepository;
    private GenreRepository genreRepository;
    private ArtistRepository artistRepository;

    @RequestMapping("/")
    public String home(Model model) {
        trackRepository = new TrackRepository();
        genreRepository = new GenreRepository();
        artistRepository = new ArtistRepository();


        ArrayList<Track> trackList = trackRepository.get5RandomTracks();
        ArrayList<Genre> genreList = genreRepository.get5RandomGenres();
        ArrayList<Artist> artistList = artistRepository.get5RandomArtists();
        model.addAttribute("tracks", trackList);
        model.addAttribute("genres", genreList);
        model.addAttribute("artists", artistList);
        return "landing_page";
    }

    @PostMapping("/search")
    public String searchDB(@ModelAttribute("searchForm") Track formData, Model model){
        Track track =
    }
}
