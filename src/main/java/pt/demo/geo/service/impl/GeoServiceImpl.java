package pt.demo.geo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pt.demo.geo.dto.GeoCountry;
import pt.demo.geo.dto.GeoResponse;
import pt.demo.geo.service.GeoService;

import java.util.Optional;

@Service
public class GeoServiceImpl implements GeoService {

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://api.geonames.org/countryInfo?";


    @Override
    public GeoCountry getCountryInfoByCountryCode(String countryCode) {

        GeoCountry result;

        StringBuilder stringBuilder = new StringBuilder(URL);

        stringBuilder.append("country=").append(countryCode).append("&username=jfvpereira");

        GeoResponse response;
        ObjectMapper objectMapper = new ObjectMapper();

        response = restTemplate.getForObject(stringBuilder.toString(), GeoResponse.class);

        result = response.getGeoCountries().stream().findFirst().get();

        return result;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
