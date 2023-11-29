package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Color {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hex;

    public Color() {
    }

    public Color(String name, String hex) {
        this.name = name;
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public String getHex() {
        return hex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
