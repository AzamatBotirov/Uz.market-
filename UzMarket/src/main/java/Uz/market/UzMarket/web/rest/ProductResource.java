package Uz.market.UzMarket.web.rest;

import Uz.market.UzMarket.domain.Product;
import Uz.market.UzMarket.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Long id) {
        Product product = productService.findOne(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Product> product = productService.finAll(pageable);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/product/code")
    public ResponseEntity getByCode(@RequestParam String code) {
         Product product = productService.findByCode(code);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
