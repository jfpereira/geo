package pt.demo.geo.service;

import pt.demo.geo.dto.GeoCountry;

/**
 * Interface GeoService
 */
public interface GeoService {
    /**
     * @param countryCode
     * @return
     */
    GeoCountry getCountryInfoByCountryCode(String countryCode);
}
