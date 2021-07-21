package pt.demo.geo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.demo.geo.dto.GeoCountry;
import pt.demo.geo.dto.GeoRequest;
import pt.demo.geo.service.GeoService;

@RestController
public class RootController {

    @Autowired
    private GeoService geoService;

    @PostMapping("/cenas")
    public ResponseEntity<GeoCountry> getCenas(@RequestBody GeoRequest request) throws Exception {

        GeoCountry response = geoService.getCountryInfoByCountryCode(request.getCountryName());

        return new ResponseEntity<>(response, HttpStatus.OK);

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

    }


}
