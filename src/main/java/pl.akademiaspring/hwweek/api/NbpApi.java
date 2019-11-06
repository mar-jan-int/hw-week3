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

@RestController
@RequestMapping("/nbp")
public class NbpApi {
    private CurrencyNBPClient currencyNBPClient;

    @Autowired
    public NbpApi(CurrencyNBPClient currencyNBPClient) {
        this.currencyNBPClient = currencyNBPClient;
    }

    @GetMapping
    public List<Rate> getCurrancyList() {

        List<Rate> currencies = currencyNBPClient.getCurrencyTable();
        return currencies;
    }

    @GetMapping("/{currency}")
    public BigDecimal getRateByCurrency(@PathVariable String currency) {
    return null;
    }
}
