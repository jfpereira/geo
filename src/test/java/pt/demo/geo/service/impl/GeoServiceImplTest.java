package pt.demo.geo.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import pt.demo.geo.dto.GeoCountry;
import pt.demo.geo.dto.GeoResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeoServiceImplTest {

    @InjectMocks
    private GeoServiceImpl geoService;

    @Mock
    private RestTemplate restTemplate;


    @Test
    void getCountryInfoSuccess() {
        GeoResponse response = new GeoResponse();
        List<GeoCountry> geoCountryList = new ArrayList<>();
        GeoCountry country = new GeoCountry();
        country.setCountryName("Portugal");
        country.setAreaInSqKm("AREA");
        country.setCurrencyCode("CODE");
        country.setContinentName("EUROPE");
        country.setEast("EAST");
        geoCountryList.add(country);
        response.setGeoCountries(geoCountryList);

        when(restTemplate.getForObject(anyString(), any())).thenReturn(response);

        GeoCountry result = geoService.getCountryInfoByCountryCode("PT");

        assertNotNull(result);
        assertEquals(result.getCountryName(), country.getCountryName());
    }


    @Test
    void getCountryInfoError() {
        GeoResponse response = new GeoResponse();

        when(restTemplate.getForObject(anyString(), any())).thenReturn(response);

        GeoCountry result = geoService.getCountryInfoByCountryCode("PT");

        assertNull(result);
    }
}
