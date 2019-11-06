package pl.akademiaspring.hwweek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiaspring.hwweek.client.CurrencyNBPClient;
import pl.akademiaspring.hwweek.model.Rate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/nbp")
public class NbpApi {
    private CurrencyNBPClient currencyNBPClient;

    @Autowired
    public NbpApi(CurrencyNBPClient currencyNBPClient) {
        this.currencyNBPClient = currencyNBPClient;
    }

    @GetMapping("/{code}")
    public Boolean getRateByCode(@PathVariable String code) {
        List<Rate> rates = getCurrancyAndRateList();

        return rates.stream()
                .findFirst()
                .get()
                .getCode()
                .equals(code);

    }

    @GetMapping
    public List<Rate> getCurrancyAndRateList() {
        List<Rate> currencies = currencyNBPClient.getCurrencyTable();
        return currencies;
    }

    @GetMapping("/codes")
    public List<String> getCurencyCodeList() {
        List<String> codes = new ArrayList<>();
        for (Rate rate : getCurrancyAndRateList()) {
            codes.add(rate.getCode());
        }
        return codes;
    }


}
