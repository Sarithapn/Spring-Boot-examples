package com.saritha.security.spring.controller;


import com.saritha.security.spring.model.AuthenticationRequest;
import com.saritha.security.spring.model.AuthenticationResponse;
import com.saritha.security.spring.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {




//


    @GetMapping("/")
    public String home() {
        System.out.println("Home endpoint called");
        return "Home";
    }

    @GetMapping("/user")
    public String user() {
        System.out.println("User endpoint called");
        return "User";
    }

    @GetMapping("/admin")
    public String admin() {
        System.out.println("Admin endpoint called");
        return "Admin";
    }
}