package pt.demo.geo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.demo.geo.dto.GeoCountry;
import pt.demo.geo.dto.GeoRequest;
import pt.demo.geo.service.GeoService;
import pt.demo.geo.utils.CustomError;

import javax.validation.Valid;

/**
 * RootController
 */
@RestController
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private GeoService geoService;

    /**
     * Get country information for given country code
     *
     * @param request {@link GeoRequest}
     *
     * @return {@link ResponseEntity} with Http Status Code 200 (OK) if get result, or Code 400 when not get any result
     */
    @PostMapping("/info")
    public ResponseEntity<Object> getInfoCountry(@RequestBody GeoRequest request) {

        log.info("Get country information - Begin");
        GeoCountry response = geoService.getCountryInfoByCountryCode(request.getCountryName());

        if(null == response) {
            log.info("Get country information with error - End");
            CustomError error = new CustomError(400, "No data");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        log.info("Get country information with success - End");
        return ResponseEntity.ok(response);
    }
}
