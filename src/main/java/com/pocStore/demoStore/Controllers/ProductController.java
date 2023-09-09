package com.pocStore.demoStore.Controllers;

import com.pocStore.demoStore.DataService.ProductDataService;
import com.pocStore.demoStore.Entity.Product;
import com.pocStore.demoStore.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home/products")
public class ProductController {

    @Autowired
    private ProductDataService productDataService;
    @GetMapping(value = "/fetchAll")
    public ResponseEntity<List<Product>> fetchAllProducts(){
        List<Product> productList = productDataService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addProducts")
    public ResponseEntity<String> addProducts (@RequestBody List<Product> products)
    {
        productDataService.addProducts(products);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
