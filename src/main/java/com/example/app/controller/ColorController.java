package com.example.app.controller;

import com.example.app.model.Color;
import com.example.app.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/colors")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @PostMapping
    public ResponseEntity<Color> createColor(@RequestBody Color color) {
        Color savedColor = colorRepository.save(color);
        return ResponseEntity.ok(savedColor);
    }

    @GetMapping
    public ResponseEntity<List<Color>> getAllColors() {
        return ResponseEntity.ok(colorRepository.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Color> getColorByName(@PathVariable String name) {
        Optional<Color> color = colorRepository.findByName(name);
        return color.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable Long id, @RequestBody Color newColor) {
        if (Objects.equals(newColor.getId(), id)) {
            return colorRepository.findById(id)
                    .map(color -> {
                        color.setName(newColor.getName());
                        color.setHex(newColor.getHex());
                        return ResponseEntity.ok(colorRepository.save(color));
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        if (colorRepository.existsById(id)) {
            colorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
