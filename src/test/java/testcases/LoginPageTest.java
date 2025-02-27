package testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import constants.AutomationConstants;
import pages.LoginPage;

public class LoginPageTest extends TestBase{
		
		LoginPage log;
		
		@BeforeClass
		public void page_init() throws IOException {
			log = new LoginPage(driver);
			// Check if CAPTCHA is present
	        if (log.isCaptchaPresent()) {
	            log.enterCaptchaManually();
	        }
		}
		
		@Test(priority = 1)
		public void testURL() {
			String currentUrl=driver.getCurrentUrl();
		    Assert.assertEquals(currentUrl, AutomationConstants.loginURL);
		    System.out.println("Test:URL Verification passed");
		    }
		
		@Test(priority=2)
		public void search() {
			log.searchEntity(prop.getProperty("Need"));			
	        String currentUrl=driver.getCurrentUrl();
//		    Assert.assertTrue();
		    System.out.println("Test:First Search Verification passed");
		    }
		
		@Test(priority=3)
		public void explore() {
			log.ExploreItem();			
	        String currentUrl=driver.getCurrentUrl();
//		    Assert.assertEquals
		    System.out.println("Test:Item Search Verification passed");
		    }
		
		@Test(priority=3)
		public void explore() {
			log.addtoCart();			
	        String currentUrl=driver.getCurrentUrl();
//		    Assert.assertEquals
		    System.out.println("Test:Item Search Verification passed");
		    }
				}
