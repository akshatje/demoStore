package com.pocStore.demoStore.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
    private String token;
    private String user;
}
