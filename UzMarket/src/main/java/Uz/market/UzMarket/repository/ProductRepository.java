package Uz.market.UzMarket.repository;

import Uz.market.UzMarket.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Product findByCode(String code);
}