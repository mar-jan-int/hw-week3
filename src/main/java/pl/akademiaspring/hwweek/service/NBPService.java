package pl.akademiaspring.hwweek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek.client.CurrencyNBPClient;
import pl.akademiaspring.hwweek.model.Rate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NBPService {
    private CurrencyNBPClient currencyNBPClient;

    @Autowired
    NBPService(CurrencyNBPClient currencyNBPClient){
        this.currencyNBPClient = currencyNBPClient;
    }

    public String getRandomCurrencyCode(){
        Random random =new Random();
        int currencyAmount = getCurrencyCodeList().size();
        String currencyCode = getCurrencyCodeList().get(random.nextInt(currencyAmount));
        return currencyCode;
    }

    public List<String> getCurrencyCodeList() {
        List<String> codes = new ArrayList<>();
        for (Rate rate : getCurrencyAndRateList()) {
            codes.add(rate.getCode());
        }
        return codes;
    }

    public BigDecimal getRateByCode(String code) {
        MathContext mathContext = new MathContext(3);
        for (Rate rate : getCurrencyAndRateList()) {
            if(rate.getCode().equalsIgnoreCase(code)){
                return new BigDecimal(rate.getMid(), mathContext);
            }
        }
        return new BigDecimal(0);
    }

    public List<Rate> getCurrencyAndRateList() {
        List<Rate> currencies = currencyNBPClient.getCurrencyTable();
        return currencies;
    }

    public ResponseEntity<String> checkRateValue(@RequestHeader("rate") BigDecimal rate) {
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public int compareCurrencyRateAndUserRate(String currencyCode, String rate){
        BigDecimal rateByCode = getRateByCode(currencyCode);
        return rateByCode.compareTo(new BigDecimal(rate));
    }
}
