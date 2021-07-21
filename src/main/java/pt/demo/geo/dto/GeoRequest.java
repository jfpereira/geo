package pt.demo.geo.dto;


import com.sun.istack.internal.NotNull;

public class GeoRequest {

    @NotNull
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
