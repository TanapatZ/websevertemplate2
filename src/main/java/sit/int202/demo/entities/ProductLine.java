package sit.int202.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productLines")
public class ProductLine {
    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;

    @Column(name = "textDescription", length = 4000)
    private String textDescription;

    @Column(name = "htmlDescription", length = 500)
    private String htmlDescription;

    @Column(name = "image", length = 500)
    private String image;

}