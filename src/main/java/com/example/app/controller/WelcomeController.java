package com.example.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to my Spring Oracle DB CRUD API Template. What will you build with it?";
    }
}