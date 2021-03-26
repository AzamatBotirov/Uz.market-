package Uz.market.UzMarket.web.rest;

import Uz.market.UzMarket.domain.MarketBase;
import Uz.market.UzMarket.service.MarketBaseService;
import Uz.market.UzMarket.service.dto.PaymentParamResult;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketBaseResource {

    private final MarketBaseService marketBaseService;

    public MarketBaseResource(MarketBaseService marketBaseService) {
        this.marketBaseService = marketBaseService;
    }

    @PostMapping("/market-base")
    public ResponseEntity<?> create(@RequestBody MarketBase marketBase) {
        MarketBase newMarketBase = marketBaseService.save(marketBase);
        return ResponseEntity.ok(marketBase);

    }
    @PostMapping("/market-base/list")
    public ResponseEntity<?> createList(@RequestBody List<MarketBase> marketBase) {
        List<MarketBase> newMarketBase = marketBaseService.saveList(marketBase);
        return ResponseEntity.ok("Maxsulotlar ro`yhatga olnidi");
    }

    @PutMapping("/market-base")
    public ResponseEntity<?> update(@RequestBody MarketBase marketBase) {
        MarketBase newMarketBase = marketBaseService.save(marketBase);
        return ResponseEntity.ok(marketBase);
    }

    @GetMapping("/market-base/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        MarketBase marketBase = marketBaseService.findOne(id);
        return ResponseEntity.ok(marketBase);
    }

    @GetMapping("/market-base")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<MarketBase> marketBase = marketBaseService.findAll(pageable);
        return ResponseEntity.ok(marketBase);
    }

    @GetMapping("/market-base/get/product")
    public ResponseEntity<?> getAll(@RequestParam String code, @RequestParam Integer quantity){
        PaymentParamResult paramResult = marketBaseService.findByProductCode(code, quantity);
        return ResponseEntity.ok(paramResult);
    }


    @GetMapping("/market-base/code")
    public ResponseEntity<?> getAll(@RequestParam String code) {
        MarketBase marketBase = marketBaseService.findByProductCode(code);
        return ResponseEntity.ok(marketBase);
    }

    @DeleteMapping("/market-base/{id}")
    public void delete(@PathVariable Long id) {
        marketBaseService.delete(id);
    }

}
