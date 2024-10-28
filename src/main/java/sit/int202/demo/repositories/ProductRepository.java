package sit.int202.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int202.demo.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
  List<Product> findProductsByProductNameContainingOrProductVendorContainingOrProductLine_ProductLine(String productNameString ,String vendor,String productLine);
  @Query("""
    Select p from Product p where p.productName like ?1 
    or p.productVendor like ?2 or p.productLine.productLine like ?3
            """)
  List<Product> findProductByKeyword(String productNameString ,String vendor,String productLine);
  List<Product> findProductByBuyPriceBetween(BigDecimal min, BigDecimal max);
}