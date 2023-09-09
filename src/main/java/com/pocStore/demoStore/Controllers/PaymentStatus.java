package com.pocStore.demoStore.Controllers;

import com.pocStore.demoStore.DataService.CartDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping(value = "home/checkPayment")
public class PaymentStatus {

    @Autowired
    private CartDataService cartDataService;
    @GetMapping(value = "")
    public Boolean returnStatus(){
        return Math.random() > 0.5;
    }

    @GetMapping(value = "/{cartId}")
    public ResponseEntity<String> checkPaymentStatus(@PathVariable Long cartId){
        String url = "http://localhost:8080/checkPayment";
        RestTemplate restTemplate = new RestTemplate();
        Boolean status = restTemplate.getForObject(url,Boolean.class);
        if(!cartDataService.getById(cartId).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(status.equals(true))
        {
            cartDataService.deleteCart(cartId);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
    }
}
