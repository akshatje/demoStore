package com.pocStore.demoStore.DataService;

import com.pocStore.demoStore.Entity.Cart;
import com.pocStore.demoStore.Entity.Product;
import com.pocStore.demoStore.Entity.User;
import com.pocStore.demoStore.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartDataService {
    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getCartByUser(User user){
        return cartRepository.findBycartuser(user);
    }
    public void addProductsToCart(List<Product> product , Cart cart){
       List<Product> products = cart.getProductList();
       products.addAll(product);
       cart.setProductList(products);
       cartRepository.save(cart);
    }
    public Optional<Cart> getById(Long id){
        return  cartRepository.findById(id);
    }

    public void addCartforUser(Cart cart){
        cartRepository.saveAndFlush(cart);
    }

    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }
}
