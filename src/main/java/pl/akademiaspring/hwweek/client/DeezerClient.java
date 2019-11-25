package pl.akademiaspring.hwweek.client;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek.model.Artist;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.hwweek.model.Datum;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeezerClient {
    private RestTemplate restTemplate;

    public DeezerClient() {
        this.restTemplate = new RestTemplate();
    }

//    public Artist getArtist() {
//        HttpEntity httpEntity = new HttpEntity(null);
//        Artist[] artists = restTemplate.getForObject("https://api.deezer.com/search/artist?q=eminem", Artist[].class);
//        return artists != null ? artists[0] : null;
//    }

//    public Datum[] getDatum() {
//        HttpEntity httpEntity = new HttpEntity(null);
//        Datum[] datums = restTemplate.getForObject("https://api.deezer.com/search/artist?q=eminem", Datum[].class);
//        return datums;
//    }


    public List<Datum> getDatum(String artist) {
        List<Datum> datums = new ArrayList<>();
        HttpEntity httpEntity = new HttpEntity(null);

        ResponseEntity<Artist> exchange = restTemplate.exchange("https://api.deezer.com/search/artist?q=" + artist,
                HttpMethod.GET,
                httpEntity.EMPTY,
                Artist.class);
        datums = exchange.getBody().getData();
        return datums;
    }
}
