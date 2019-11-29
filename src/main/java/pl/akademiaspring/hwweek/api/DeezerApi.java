package pl.akademiaspring.hwweek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiaspring.hwweek.client.DeezerClient;
import pl.akademiaspring.hwweek.model.Datum;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/deezer")
public class DeezerApi {
    private DeezerClient deezerClient;

    @Autowired
    public DeezerApi(DeezerClient deezerClient) {
        this.deezerClient = deezerClient;
    }

    @GetMapping
    public String getArtist(Model model) {
        model.addAttribute("albums", deezerClient.getDatum(""));
        return "music";
    }

    @GetMapping("/{artist}")
    public String getListOfArtist(@PathVariable("artist") String artist, Model model) {
        model.addAttribute("albums", deezerClient.getDatum(artist));
        model.addAttribute("artist", artist);
        return "music";
    }
}
