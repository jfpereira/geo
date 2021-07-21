package pt.demo.geo.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="geonames")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoResponse {

    @XmlElement(name="country")
    List<GeoCountry> geoCountries;

    public List<GeoCountry> getGeoCountries() {
        return geoCountries;
    }

    public void setGeoCountries(List<GeoCountry> geoCountries) {
        this.geoCountries = geoCountries;
    }
}