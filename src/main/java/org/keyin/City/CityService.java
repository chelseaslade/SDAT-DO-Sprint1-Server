package org.keyin.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public ArrayList<City> getAllCities() {
        return (ArrayList<City>) cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

}
