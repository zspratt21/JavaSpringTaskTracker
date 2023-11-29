package com.example.app;

import com.example.app.model.Task;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavaSpringTaskTrackerTests {

    static {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testTaskGettersAndSetters() {
        String name = "test 1";
        String Description = "this is the first test";

        Task Task = new Task();
        Task.setName(name);
        Task.setDescription(Description);

        assertEquals(name, Task.getName());
        assertEquals(Description, Task.getDescription());
    }

    @Test
    void testTaskConstructor() {
        String name = "Test 2";
        String Description = "this is the second test";
        boolean isCompleted = true;

        Task Task = new Task(name, Description, isCompleted);

        assertEquals(name, Task.getName());
        assertEquals(Description, Task.getDescription());
    }
}
