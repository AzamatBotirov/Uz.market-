package Uz.market.UzMarket.web.rest;

import Uz.market.UzMarket.domain.PaymentList;
import Uz.market.UzMarket.service.PaymentListService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentListResource {

    private final PaymentListService paymentListService;

    public PaymentListResource(PaymentListService paymentListService) {
        this.paymentListService = paymentListService;
    }

    @PostMapping("/payment_list")
    public ResponseEntity create(@RequestBody PaymentList paymentList) {
        PaymentList nawPaymentList = paymentListService.save(paymentList);
        return ResponseEntity.ok(nawPaymentList);
    }

    @PutMapping("/payment_list")
    public ResponseEntity update(@RequestBody PaymentList paymentList) {
        PaymentList nawPaymentList = paymentListService.save(paymentList);
        return ResponseEntity.ok(nawPaymentList);
    }

    @GetMapping("/payment_list/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        PaymentList paymentList = paymentListService.finOne(id);
        return ResponseEntity.ok(paymentList);
    }

    @GetMapping("/payment_list")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<PaymentList> paymentList = paymentListService.findAll(pageable);
        return ResponseEntity.ok(paymentList);
    }

    @DeleteMapping("/payment_list/{id}")
    public void delete(@PathVariable Long id) {
        paymentListService.delete(id);
    }

}
