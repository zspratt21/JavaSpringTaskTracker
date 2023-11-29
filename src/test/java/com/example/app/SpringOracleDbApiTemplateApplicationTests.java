package com.example.app;

import com.example.app.model.Color;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringOracleDbApiTemplateApplicationTests {

    static {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testColorGettersAndSetters() {
        String name = "Red";
        String hex = "#FF0000";

        Color color = new Color();
        color.setName(name);
        color.setHex(hex);

        assertEquals(name, color.getName());
        assertEquals(hex, color.getHex());
    }

    @Test
    void testColorConstructor() {
        String name = "Blue";
        String hex = "#0000FF";

        Color color = new Color(name, hex);

        assertEquals(name, color.getName());
        assertEquals(hex, color.getHex());
    }
}
