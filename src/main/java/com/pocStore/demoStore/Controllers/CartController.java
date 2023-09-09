package com.pocStore.demoStore.Controllers;


import com.pocStore.demoStore.DataService.CartDataService;
import com.pocStore.demoStore.DataService.UserDataService;
import com.pocStore.demoStore.Entity.Cart;
import com.pocStore.demoStore.Entity.Product;
import com.pocStore.demoStore.Entity.User;
import com.pocStore.demoStore.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home/cart")
public class CartController {

    @Autowired
    private CartDataService cartDataService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping(value = "/getCart")
    public ResponseEntity<Cart> getCartIfNotExists(@RequestBody Long ids)
    {
        Optional<User> userData = userDataService.findbyID((ids));
        if(userData.isPresent())
        {
            Optional<Cart> cart = cartDataService.getCartByUser(userData.get());
            if(cart.isPresent())
                return new ResponseEntity<>(cart.get() , HttpStatus.ACCEPTED);
            else
            {
                Cart newCart = new Cart();
                newCart.setCartuser(userData.get());
                cartDataService.addCartforUser(newCart);
                return  new ResponseEntity<>(newCart , HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "addProducts/{cartId}")
    public ResponseEntity<Cart> addProducts(@RequestBody List<Product> products, @PathVariable Long cartId) {
        Optional<Cart> cartData = cartDataService.getById(cartId);
        if(cartData.isPresent())
        {
            cartDataService.addProductsToCart(products,cartData.get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
