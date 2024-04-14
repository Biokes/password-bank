package africa.semoicolon.service;

import africa.semoicolon.Exception.InvalidFieldException;
import africa.semoicolon.Exception.SiteNotFoundException;
import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import africa.semoicolon.dto.request.DeleteWebDetails;
import africa.semoicolon.dto.request.UpdatePasswordRequest;
import africa.semoicolon.dto.request.ViewAllRequest;
import africa.semoicolon.dto.response.ViewAllResponse;
import africa.semoicolon.service.interFace.WebsiteDetailsService;
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
        ViewAllRequest request = new ViewAllRequest();
        request.setUsername("name");
        request.setPassword("123456789");
        assertEquals("no password saved yet",
                websiteDetailsService.viewAllSiteDetails(request).getBody());
        CreateWebDetailsRequest webDetails= new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteUsername("username");
        webDetails.setSitePassword("123456789");
        webDetails.setSiteName("www.google.com");
        websiteDetailsService.saveDetails(webDetails);
        ViewAllResponse response = websiteDetailsService.viewAllSiteDetails(request);
        assertEquals("Site : www.google.com\nSite username : username\n Website Password : 123456789\n",
                response.getBody());
    }
    @Test
    public void updatePasswordDetails_testWebsiteDetailsIsUpdated(){
        UpdatePasswordRequest updateRequest = new UpdatePasswordRequest();
        updateRequest.setSitename("www.google.com");
        updateRequest.setPassword("123456789");
        updateRequest.setUsername("name");
        updateRequest.setSiteUsername("username");
        updateRequest.setSitePassword("pass");
        assertThrows(SiteNotFoundException.class, ()->websiteDetailsService.updateWebsiteDetails(updateRequest));
        CreateWebDetailsRequest webDetails= new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteUsername("username");
        webDetails.setSitePassword("123456789");
        webDetails.setSiteName("www.google.com");
        websiteDetailsService.saveDetails(webDetails);
        websiteDetailsService.updateWebsiteDetails(updateRequest);
        ViewAllRequest request = new ViewAllRequest();
        request.setUsername("name");
        request.setPassword("123456789");
        ViewAllResponse response = websiteDetailsService.viewAllSiteDetails(request);
        assertEquals("""
                Site : www.google.com
                Site username : username
                 Website Password : pass
                """, response.getBody());

    }
}
