package pl.akademiaspring.hwweek.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspring.hwweek.model.Rate;
import pl.akademiaspring.hwweek.service.NBPService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/nbp")

public class NbpApi {
    private NBPService nbpService;
    private int count = 0;


    @Autowired
    public NbpApi(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @RequestMapping
    public String getGame(Model model) {
        model.addAttribute("currency", nbpService.getRandomCurrencyCode());
        return "game";
    }

    @GetMapping("/randoms")
    public String getRandomCurrencyCode() {
        return nbpService.getRandomCurrencyCode();
    }

    @GetMapping("/codes")
    public List<String> getCurrencyCodeList() {
//        model.addAttribute("codes", nbpService.getCurrencyCodeList());
        return nbpService.getCurrencyCodeList();
    }

    @GetMapping("/rates")
    public List<Rate> getCurrencyAndRateList() {
        return nbpService.getCurrencyAndRateList();
    }


    @GetMapping("/checks")
    public ResponseEntity<String> checkValue(@RequestHeader("currencyCode") String currencyCode, @RequestHeader("rate") String rate) {
        count++;
        int compare = nbpService.compareCurrencyRateAndUserRate(currencyCode, rate.replaceAll(",", "."));

        if (compare == 0) {
            return new ResponseEntity<String>("Trafiony za " + count + " razem!", HttpStatus.OK);
        } else if (compare > 0) {
            return new ResponseEntity<String>("Za mało", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Za dużo", HttpStatus.OK);
    }
}
