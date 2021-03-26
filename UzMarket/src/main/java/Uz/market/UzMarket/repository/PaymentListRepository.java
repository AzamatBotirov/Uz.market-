package Uz.market.UzMarket.repository;

import Uz.market.UzMarket.domain.PaymentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList, Long> {
}
