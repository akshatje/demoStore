package com.pocStore.demoStore.Controllers;

import com.pocStore.demoStore.DataService.UserDataService;
import com.pocStore.demoStore.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "home/users")
public class UserController {
    @Autowired
    private UserDataService userDataService;
    @PostMapping(value = "/add")
    public ResponseEntity<String> addUser (@RequestBody User user){
        userDataService.saveUser(user);
        return new ResponseEntity<>("ok",HttpStatus.ACCEPTED);
    }
}
