package com.pocStore.demoStore.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    Long id;
    @OneToMany
    private List<Product> productList;
    @OneToOne(mappedBy = "user_cart")
    private User cartuser;
}
