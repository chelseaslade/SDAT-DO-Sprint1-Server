package org.keyin.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public ArrayList<Airport> getAllAirports() {
        return (ArrayList<Airport>) airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

}
