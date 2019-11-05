package pl.akademiaspring.hwweek.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.hwweek.model.Currency;

import java.util.stream.Stream;

@Controller
public class CurrencyNBPClient {
    private RestTemplate restTemplate;

    public CurrencyNBPClient() {
        this.restTemplate = new RestTemplate();
        getCurrency();
    }

    private void getCurrency(){
//        Currency currency = restTemplate.getForObject(
//                "https://api.exchangeratesapi.io/latest?base=USD&symbols=PLN", Currency.class);
        HttpEntity httpEntity = new HttpEntity(null);

        ResponseEntity<Currency[]> exchange = restTemplate.exchange("http://api.nbp.pl/api/exchangerates/tables/A/",
                HttpMethod.GET,
                httpEntity.EMPTY,
                Currency[].class);

        System.out.println(exchange.toString());
    }
}
