package com.pocStore.demoStore.DataService;

import com.pocStore.demoStore.Entity.Product;
import com.pocStore.demoStore.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductDataService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void addProducts(List<Product> product){
        productRepository.saveAll(product);
    }

}
