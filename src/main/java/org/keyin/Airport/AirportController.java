package org.keyin.Airport;

import org.keyin.City.City;
import org.keyin.City.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        if (airport.getCity() == null || airport.getCity().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<City> cityOptional = cityRepository.findById(airport.getCity().getId());
        if (cityOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        airport.setCity(cityOptional.get());
        Airport savedAirport = airportRepository.save(airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAirport);
    }

    @GetMapping
    public ArrayList<Airport> getAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirport(@PathVariable Long id) {
        return airportService.getAirportById(id);
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
        Optional<Airport> optionalAirport = airportRepository.findById(id);

        if (optionalAirport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Airport existingAirport = optionalAirport.get();
        existingAirport.setName(updatedAirport.getName());
        existingAirport.setAirportCode(updatedAirport.getAirportCode());

        if (updatedAirport.getCity() != null && updatedAirport.getCity().getId() != null) {
            Optional<City> cityOptional = cityRepository.findById(updatedAirport.getCity().getId());
            if (cityOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid city ID
            }
            existingAirport.setCity(cityOptional.get()); // Assign existing City
        }

        Airport savedAirport = airportRepository.save(existingAirport);
        return ResponseEntity.ok(savedAirport);
    }

}
