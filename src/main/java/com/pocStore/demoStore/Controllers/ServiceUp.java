package com.pocStore.demoStore.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class ServiceUp {
    @GetMapping()
    public String pong(){
        return "pong";
    }
}
