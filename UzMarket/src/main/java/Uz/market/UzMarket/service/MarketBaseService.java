package Uz.market.UzMarket.service;

import Uz.market.UzMarket.domain.MarketBase;
import Uz.market.UzMarket.repository.MarketBaseRepository;
import Uz.market.UzMarket.service.dto.PaymentParamResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MarketBaseService {

    private final MarketBaseRepository marketBaseRepository;

    public MarketBaseService(MarketBaseRepository marketBaseRepository) {
        this.marketBaseRepository = marketBaseRepository;
    }


    public MarketBase save(MarketBase marketBase) {
        if (marketBase.getId() == null) {
            marketBase.setCreateDate(ZonedDateTime.now());
        }
        return marketBaseRepository.save(marketBase);
    }

    @Transactional(readOnly = true)
    public MarketBase findOne(Long id) {
        Optional<MarketBase> optional = marketBaseRepository.findById(id);
        if (optional.isPresent()) {
            MarketBase marketBase = optional.get();
            return marketBase;
        }
        return null;
    }

    public List<MarketBase> saveList(List<MarketBase> marketBase) {
        List<MarketBase> marketBaseList = marketBaseRepository.saveAll(marketBase);
        return marketBaseList;
    }

    @Transactional(readOnly = true)
    public Page<MarketBase> findAll(Pageable pageable) {
        Page<MarketBase> page = marketBaseRepository.findAll(pageable);
        return page;
    }

    @Transactional(readOnly = true)
    public MarketBase findByProductCode(String code){
        return marketBaseRepository.findTopByProductCode(code);
    }

    @Transactional(readOnly = true)
    public PaymentParamResult findByProductCode(String code, Integer quantity){
        PaymentParamResult paramResult = marketBaseRepository.findByProductCode(code);
        paramResult.setSum(paramResult.getSum().multiply(new BigDecimal("" + quantity)));
        paramResult.setQuantity(quantity);
        return paramResult;
    }

    public void delete(Long id) {
        marketBaseRepository.deleteById(id);
    }


}
