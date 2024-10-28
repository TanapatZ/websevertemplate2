package sit.int202.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import sit.int202.demo.entities.Product;
import sit.int202.demo.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ProductService {
    private ProductRepository repository;
    private ProductService(ProductRepository repository){
        this.repository =  repository;
    }
    public List<Product> findAll(){
        return repository.findAll();
    }
    public Product findById(String productCode){
        return repository.findById(productCode).orElse(null);
    }

    public List<Product> findByText(String searchParam) {
        String keyword = "%"+ searchParam + "%";
        return repository.findProductByKeyword(keyword,keyword,keyword);

    }
    public List<Product> findByPrice(double min ,double max) {
        return repository.findProductByBuyPriceBetween(BigDecimal.valueOf(min),BigDecimal.valueOf(max));
    }

    public Page<Product> findAll(Pageable pageAble) {
        return repository.findAll(pageAble);
    }
}
