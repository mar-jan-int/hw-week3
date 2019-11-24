package pl.akademiaspring.hwweek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

//    @GetMapping
//    public String getAlbums(Model model){
//        model.addAttribute("albums", deezerClient.getDatum());
//        return "music";
//    }

    @GetMapping
    public String getDatum(Model model) {
        model.addAttribute("albums", deezerClient.getDatum());
        return "music";
    }
//  @GetMapping
//    public List<String> getAlbumsOfArtist(){
//        List<String> albums = new ArrayList<>();
//        List<Datum> datumList = deezerClient.getArtist().getData();
//
//        for (Datum datum: datumList) {
//            albums.add(datum.getName());
//        }
//        return albums;
//    }

}
