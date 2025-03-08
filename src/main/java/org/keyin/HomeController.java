package org.keyin;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome! Access points at /api/cities, /api/passengers, /api/airports and /api/aircraft.";
    }
}
