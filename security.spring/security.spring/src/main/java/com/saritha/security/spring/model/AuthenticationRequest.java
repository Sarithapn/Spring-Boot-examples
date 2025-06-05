package com.saritha.security.spring.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

}
