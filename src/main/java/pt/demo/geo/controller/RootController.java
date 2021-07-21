package pt.demo.geo.controller;

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
    public ResponseEntity<Object> getInfoCountry(@Valid @RequestBody GeoRequest request) {

        GeoCountry response = geoService.getCountryInfoByCountryCode(request.getCountryName());

        if(null == response) {
            CustomError error = new CustomError(400, "No data");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }
}
