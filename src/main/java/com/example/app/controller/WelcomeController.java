package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "welcome";
    }
}