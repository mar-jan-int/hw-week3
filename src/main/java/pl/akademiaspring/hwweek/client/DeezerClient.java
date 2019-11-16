package pl.akademiaspring.hwweek.client;

import pl.akademiaspring.hwweek.model.Artist;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


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
                httpEntity.EMPTY,
                Artist[].class);

    }
}
