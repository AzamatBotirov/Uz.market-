package Uz.market.UzMarket.service;

import Uz.market.UzMarket.domain.PaymentList;
import Uz.market.UzMarket.repository.PaymentListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentListService {

    private final PaymentListRepository paymentListRepository;

    public PaymentListService(PaymentListRepository paymentListRepository) {
        this.paymentListRepository = paymentListRepository;
    }

    public PaymentList save(PaymentList paymentList) {
        return paymentListRepository.save(paymentList);
    }

    public PaymentList finOne(Long id) {
        Optional<PaymentList> optional = paymentListRepository.findById(id);
        if (optional.isPresent()) {
            PaymentList paymentList = optional.get();
            return paymentList;
        }
        return null;
    }

    public Page<PaymentList> findAll(Pageable pageable) {
        Page<PaymentList> page = paymentListRepository.findAll(pageable);
        return page;
    }

    public void delete(Long id) {
        paymentListRepository.deleteById(id);
    }
}
