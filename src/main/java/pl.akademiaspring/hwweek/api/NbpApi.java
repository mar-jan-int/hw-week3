package pl.akademiaspring.hwweek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspring.hwweek.client.CurrencyNBPClient;
import pl.akademiaspring.hwweek.model.Rate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@RestController
@RequestMapping("/nbp")
public class NbpApi {
    private CurrencyNBPClient currencyNBPClient;
    private BigDecimal rateCurrency;

    @Autowired
    public NbpApi(CurrencyNBPClient currencyNBPClient) {
        this.currencyNBPClient = currencyNBPClient;
    }

    @GetMapping("/randoms")
    public String getRandomCurrencyCode(){
        Random random =new Random();
        int currencyAmount = getCurrencyCodeList().size();
        String currencyCode = getCurrencyCodeList().get(random.nextInt(currencyAmount));
        return currencyCode;
    }

    @GetMapping("/codes")
    public List<String> getCurrencyCodeList() {
        List<String> codes = new ArrayList<>();
        for (Rate rate : getCurrancyAndRateList()) {
            codes.add(rate.getCode());
        }
        return codes;
    }

    @GetMapping("/{code}")
    public BigDecimal getRateByCode(@PathVariable String code) {
        MathContext mathContext = new MathContext(5);
          for (Rate rate : getCurrancyAndRateList()) {
            if(rate.getCode().equalsIgnoreCase(code)){
                rateCurrency = new BigDecimal(rate.getMid(), mathContext);
            }
        }
        return rateCurrency;
    }

    @GetMapping
    public List<Rate> getCurrancyAndRateList() {
        List<Rate> currencies = currencyNBPClient.getCurrencyTable();
        return currencies;
    }
}
