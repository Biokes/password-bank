package africa.semoicolon.service;

import africa.semoicolon.Exception.InvalidFieldException;
import africa.semoicolon.Exception.SiteNotFoundException;
import africa.semoicolon.dto.CreateWebDetailsRequest;
import africa.semoicolon.dto.DeleteWebDetails;
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
        webDetails.setSiteName("www.google.com");
        websiteDetailsService.saveDetails(webDetails);
        assertEquals(1, websiteDetailsService.countByUsername("name"));
    }
    @Test
    public void createWebsiteDatailsWithInvalidDetails_testExceptionIsThrown(){
        CreateWebDetailsRequest webDetails= new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteUsername("username");
        assertThrows(InvalidFieldException.class,
                ()->websiteDetailsService.saveDetails(webDetails));

    }
    @Test
    public void deleteWebsiteDetails_testwebsiteDetailsIsDeleted(){
        DeleteWebDetails deleteDetails = new DeleteWebDetails();
        deleteDetails.setUsername("username");
        deleteDetails.setPassword("password");
        deleteDetails.setSiteName("www.google.com");
        assertThrows(SiteNotFoundException.class,
                ()->websiteDetailsService.deleteSite(deleteDetails));
        CreateWebDetailsRequest webDetails= new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteUsername("username");
        webDetails.setSitePassword("123456789");
        webDetails.setSiteName("www.google.com");
        websiteDetailsService.saveDetails(webDetails);
        deleteDetails.setUsername("name");
        deleteDetails.setPassword("123456789");
        deleteDetails.setSiteName("www.google.com");
        websiteDetailsService.deleteSite(deleteDetails);
        assertEquals(0, websiteDetailsService.countByUsername("name"));
    }
    @Test
    public void viewAllPasswordDetails_testAllPasswordsAreSeen(){

    }
}
