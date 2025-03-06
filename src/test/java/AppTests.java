import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.keyin.City.City;
import org.keyin.City.CityRepository;
import org.keyin.City.CityService;
import org.keyin.SpringBootApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringBootApp.class)
@ExtendWith(MockitoExtension.class)
public class AppTests {

    @Autowired(required = false)
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Test
    public void testGetAllCities() {
        if (cityService == null) {
            throw new RuntimeException("CityService bean is not being injected!");
        }

        List<City> cities = new ArrayList<>();
        cities.add(new City(1L, "Halifax", "Canada"));

        when(cityRepository.findAll()).thenReturn(cities);

        List<City> result = cityService.getAllCities();
        assertEquals(1, result.size());
        assertEquals("Halifax", result.get(0).getName());
    }
}

