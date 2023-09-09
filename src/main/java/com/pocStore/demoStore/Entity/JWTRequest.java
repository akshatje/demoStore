package com.pocStore.demoStore.Entity;

import lombok.Data;

@Data
public class JWTRequest {
    private String username;
    private String password;
}
