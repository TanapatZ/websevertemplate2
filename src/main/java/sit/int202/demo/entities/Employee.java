package sit.int202.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employeenumber", nullable = false)
    private Integer id;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "officeCode", nullable = false)
    private Office officeCode;

    @Column(name = "jobtitle", nullable = false, length = 50)
    private String jobtitle;

    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    private Set<Customer> customers = new LinkedHashSet<>();

}