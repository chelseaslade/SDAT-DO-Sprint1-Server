package org.keyin.Passenger;

import org.keyin.City.City;
import org.keyin.City.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public ArrayList<Passenger> getPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        if (passenger.getCity() == null || passenger.getCity().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<City> cityOptional = cityRepository.findById(passenger.getCity().getId());
        if (cityOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // City does not exist
        }

        passenger.setCity(cityOptional.get());
        Passenger savedPassenger = passengerRepository.save(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return new ResponseEntity<>("Passenger deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Passenger not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger updatedPassenger) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);

        if (optionalPassenger.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Passenger existingPassenger = optionalPassenger.get();
        existingPassenger.setName(updatedPassenger.getName());

        if (updatedPassenger.getCity() != null && updatedPassenger.getCity().getId() != null) {
            Optional<City> cityOptional = cityRepository.findById(updatedPassenger.getCity().getId());
            if (cityOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid city ID
            }
            existingPassenger.setCity(cityOptional.get()); // Assign existing City
        }

        Passenger savedPassenger = passengerRepository.save(existingPassenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.OK);
    }
}
