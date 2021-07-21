package pt.demo.geo.service;

import pt.demo.geo.dto.GeoCountry;

public interface GeoService {
    GeoCountry getCountryInfoByCountryCode(String countryCode);
}
