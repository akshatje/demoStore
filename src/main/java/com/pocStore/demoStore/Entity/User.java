package com.pocStore.demoStore.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String name;
    @OneToOne
    Cart user_cart;
}
