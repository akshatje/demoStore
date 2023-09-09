package com.pocStore.demoStore.Repositories;

import com.pocStore.demoStore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
