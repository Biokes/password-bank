package africa.semoicolon.service;

import africa.semoicolon.Exception.InvalidFieldException;
import africa.semoicolon.dto.CreateWebDetailsRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class WebsiteDetailsTest{
    @Autowired
    private WebsiteDetailsService websiteDetailsService;
    @BeforeEach
    void wipe(){
        websiteDetailsService.deleteAll();
    }
    @Test
    public void createWebsiteDetails_testWebsiteDetailsIsCreated(){
        CreateWebDetailsRequest webDetails= new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteUsername("username");
        webDetails.setSitePassword("123456789");
        websiteDetailsService.saveDetails(webDetails);
        assertEquals(1,websiteDetailsService.countByUsername("name"));
    }
    @Test
    public void createWebsiteDatailsWithInvalidDetails_testExceptionIsThrown(){
        CreateWebDetailsRequest webDetails= new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteUsername("username");
        assertThrows(InvalidFieldException.class,()->websiteDetailsService.saveDetails(webDetails);
    }
}
