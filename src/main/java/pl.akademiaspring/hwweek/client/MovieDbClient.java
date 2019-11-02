package pl.akademiaspring.hwweek.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.hwweek.model.MovieDb;
import pl.akademiaspring.hwweek.model.ResultsItem;

import java.util.stream.Stream;

@Controller
public class MovieDbClient {
    private RestTemplate restTemplate;
    @Value("${api_key}")
    private String api_key;
    private String year = "2018";

    public MovieDbClient() {
        this.restTemplate = new RestTemplate();
        getMovie();
    }

    private void getMovie() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("api_key", api_key);
        headers.add("primary_release_year", year);
        headers.add("sort_by", "vote_average.desc");
        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<ResultsItem[]> exchange = restTemplate.exchange("https://api.themoviedb.org/3/discover/movie",
                HttpMethod.GET,
                httpEntity,
                ResultsItem[].class);

        Stream.of(exchange.getBody()).forEach(System.out::println);

    }
}
