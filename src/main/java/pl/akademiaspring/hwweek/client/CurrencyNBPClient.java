package pl.akademiaspring.hwweek.client;

import pl.akademiaspring.hwweek.model.Currency;
import pl.akademiaspring.hwweek.model.Rate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Controller
public class CurrencyNBPClient {
    private RestTemplate restTemplate;

    public CurrencyNBPClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<Rate> getCurrencyTable(){
        HttpEntity httpEntity = new HttpEntity(null);

        ResponseEntity<Currency[]> exchange = restTemplate.exchange("http://api.nbp.pl/api/exchangerates/tables/A/",
                HttpMethod.GET,
                httpEntity.EMPTY,
                Currency[].class);

        List<Rate> rates = new ArrayList<>();
        rates = exchange.getBody()[0].getRates();
        return rates;
    }
}
