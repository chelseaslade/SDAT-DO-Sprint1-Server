package org.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping
    public ArrayList<Aircraft> getAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraft(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        Aircraft savedAircraft = aircraftRepository.save(aircraft);
        return new ResponseEntity<>(savedAircraft, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAircraft(@PathVariable Long id) {
        if (aircraftRepository.existsById(id)) {
            aircraftRepository.deleteById(id);
            return new ResponseEntity<>("Aircraft deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Aircraft not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft updatedAircraft) {
        return aircraftRepository.findById(id)
                .map(existingAircraft -> {
                    existingAircraft.setName(updatedAircraft.getName());
                    Aircraft savedAircraft = aircraftRepository.save(existingAircraft);
                    return new ResponseEntity<>(savedAircraft, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}