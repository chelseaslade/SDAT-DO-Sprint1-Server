package org.keyin.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public ArrayList<Passenger> getAllPassengers() {
        return (ArrayList<Passenger>) passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

}
