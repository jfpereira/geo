package pt.demo.geo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pt.demo.geo.dto.GeoCountry;
import pt.demo.geo.dto.GeoRequest;
import pt.demo.geo.service.impl.GeoServiceImpl;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@ActiveProfiles("test")
@AutoConfigureMockMvc()
@WithMockUser
public class RootControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeoServiceImpl geoService;

    private GeoRequest request;
    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        request = new GeoRequest();
        request.setCountryName("PT");

        objectMapper = new ObjectMapper();
    }


    @Test
    void getMockInfoSuccess() throws Exception {


        GeoCountry geoCountry = new GeoCountry();
        geoCountry.setCountryName("Portugal");
        geoCountry.setCapital("Lisboa");

        when(geoService.getCountryInfoByCountryCode(anyString())).thenReturn(geoCountry);

        this.mockMvc.perform(post("/info")
        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

    }

    @Test
    void getMockInfoError() throws Exception {

        when(geoService.getCountryInfoByCountryCode(anyString())).thenReturn(null);

        this.mockMvc.perform(post("/info")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
