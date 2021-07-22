package pt.demo.geo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pt.demo.geo.dto.GeoCountry;
import pt.demo.geo.dto.GeoResponse;
import pt.demo.geo.service.GeoService;


/**
 * GeoService implementation
 */
@Service
public class GeoServiceImpl implements GeoService {

    private static final Logger log = LoggerFactory.getLogger(GeoService.class);

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://api.geonames.org/countryInfo?";


    /**
     * @param countryCode {@link String}
     * @return {@link GeoCountry} when webService return results or null when result is empty
     */
    @Override
    public GeoCountry getCountryInfoByCountryCode(String countryCode) {

        GeoCountry result;
        GeoResponse response;

        StringBuilder stringBuilder = new StringBuilder(URL);

        stringBuilder.append("country=").append(countryCode).append("&username=jfvpereira");

        try {
            response = restTemplate.getForObject(stringBuilder.toString(), GeoResponse.class);
            result = response.getGeoCountries().stream().findFirst().get();
        } catch (Exception e) {
            log.error("Error -> " + e.getMessage());
            return null;
        }

        log.info("Return data for countryCode {} with success!", countryCode);
        return result;
    }

/////******** No used code****////////////
//        WebService.setUserName("jfvpereira");
//
//        ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
//        searchCriteria.getFeatureCodes();
////        searchCriteria.setCountryCode(request.getCountryName());
//        searchCriteria.setQ(request.getCountryName());
//        ToponymSearchResult searchResult = WebService.search(searchCriteria);
//        for (Toponym toponym : searchResult.getToponyms()) {
//            System.out.println(toponym.getName()+" "+ toponym.getCountryName());
//        }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
