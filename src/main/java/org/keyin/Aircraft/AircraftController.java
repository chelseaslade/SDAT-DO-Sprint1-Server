package org.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public ArrayList<Aircraft> getAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraft(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

}