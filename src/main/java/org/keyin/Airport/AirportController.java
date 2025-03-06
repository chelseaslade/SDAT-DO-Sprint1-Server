package org.keyin.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public ArrayList<Airport> getAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirport(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport savedAirport = airportRepository.save(airport);
        return new ResponseEntity<>(savedAirport, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return new ResponseEntity<>("Airport deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Airport not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport updatedAirport) {
        return airportRepository.findById(id)
                .map(existingAirport -> {
                    existingAirport.setName(updatedAirport.getName());
                    existingAirport.setCity(updatedAirport.getCity());
                    existingAirport.setAirportCode(updatedAirport.getAirportCode());
                    Airport savedAirport = airportRepository.save(existingAirport);
                    return new ResponseEntity<>(savedAirport, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}