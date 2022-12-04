package ru.gb.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;



    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "customer_products",
            joinColumns = { @JoinColumn(name = "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") })
    @LazyCollection(LazyCollectionOption.TRUE)

    private List<Product> products;
}
