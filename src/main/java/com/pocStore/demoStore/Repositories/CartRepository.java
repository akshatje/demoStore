package com.pocStore.demoStore.Repositories;

import com.pocStore.demoStore.Entity.Cart;
import com.pocStore.demoStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findBycartuser (User user);
}
