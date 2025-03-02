package org.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;

    public ArrayList<Aircraft> getAllAircrafts() {
        return (ArrayList<Aircraft>) aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

}
