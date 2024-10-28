package sit.int202.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String productCode;

    @Column(name = "productName", nullable = false, length = 70)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productLine", nullable = false)
    private sit.int202.demo.entities.ProductLine productLine;

    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;

    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;

    @Column(name = "productDescription", nullable = false, length = 1000)
    private String productDescription;

    @Column(name = "quantityInStock", nullable = false)
    private Integer quantityInStock;

    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @Column(name = "msrp", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;

}