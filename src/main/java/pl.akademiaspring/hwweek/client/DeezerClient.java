package pl.akademiaspring.hwweek.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.hwweek.model.Artist;


import java.util.stream.Stream;

@Controller
public class DeezerClient {
    private RestTemplate restTemplate;
//    @Value("${x-rapidapi-key}")
//    private String deezerKey;
//    @Value("${x-rapidapi-host}")
//    private String deezerHost;

    public DeezerClient() {
        this.restTemplate = new RestTemplate();
    }

    private void getArtist() {
        HttpEntity httpEntity = new HttpEntity(null);

        ResponseEntity<Artist[]> exchange = restTemplate.exchange("https://api.deezer.com/search/artist?q=eminem",
                HttpMethod.GET,
                httpEntity,
                Artist[].class);

    }
}
