package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import constants.AutomationConstants;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    
    // Instance variable for LoginPage
    LoginPage log;
    
    @BeforeClass
    public void page_init() throws IOException {
        // Initialize the LoginPage object
        log = new LoginPage(driver);
        
        // Check if CAPTCHA is present and handle it manually
        if (log.isCaptchaPresent()) {
            log.enterCaptchaManually();
        }
    }
    
    @Test(priority = 1)
    public void testURL() {
        // Get the current URL and verify if it matches the expected URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, AutomationConstants.loginURL);
        System.out.println("Test: URL Verification passed");
    }
    
    @Test(priority = 2)
    public void search() {
        // Perform a search operation using the "Need" property from configuration
        log.searchEntity(prop.getProperty("Need"));
        System.out.println("Test: First Search Verification passed");
    }
    
    @Test(priority = 3)
    public void explore() {
        // Explore an item on the page
        log.ExploreItem();
        System.out.println("Test: Item Search Verification passed");
    }
    
    @Test(priority = 3)
    public void add() {
        // Add an item
        log.Addtem();
        System.out.println("Test: Item Add Verification passed");
    }
}
