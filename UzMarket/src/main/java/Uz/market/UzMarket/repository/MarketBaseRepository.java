package Uz.market.UzMarket.repository;

import Uz.market.UzMarket.domain.MarketBase;
import Uz.market.UzMarket.service.dto.PaymentParamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketBaseRepository extends JpaRepository<MarketBase, Long> {

    MarketBase findTopByProductCode(String code);

    @Query("select  new Uz.market.UzMarket.service.dto.PaymentParamResult(m)"+
    "from MarketBase m where m.product.code = :code")
    PaymentParamResult findByProductCode(@Param("code")String code);
}
