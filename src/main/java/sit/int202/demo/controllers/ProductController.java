package sit.int202.demo.controllers;


import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sit.int202.demo.entities.Product;
import sit.int202.demo.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){
        this.service = service;
    }
    @GetMapping("")
    public String getProduct(Model model ){
        model.addAttribute("products",service.findAll());
        return "product_list";
    }
@GetMapping("/search-product")
    public String searchProductByText(@RequestParam String searchParam ,Model model){
        model.addAttribute("products",service.findByText(searchParam));
        return "product_list";
}
    @GetMapping("/searchPrice-product")
    public String searchProductByPrice(@RequestParam(defaultValue = "0") double min,@RequestParam(defaultValue = "999") double max ,Model model){
        model.addAttribute("products",service.findByPrice(min,max));
        return "product_list";
    }
 @GetMapping("/paging")
    public String getProductsPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size, ModelMap model){
        model.addAttribute("page",service.findAll(PageRequest.of(page,size)));
        return "product_list_paging";
 }
}
