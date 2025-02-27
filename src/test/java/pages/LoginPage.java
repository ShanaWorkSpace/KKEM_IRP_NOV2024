package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorsReader;

public class LoginPage extends LocatorsReader{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) throws IOException {
		
		this.driver=driver;
	}
	
	 
	public boolean isCaptchaPresent() {
		 WebElement cap = driver.findElement(By.xpath(propi.getProperty("loginPage.captcha")));
		 System.out.println(cap.getText());
		return true;
	 }
	
	
	
	public void enterCaptchaManually() {
        System.out.println("CAPTCHA detected! Please solve it manually.");
        try {
            Thread.sleep(15000); // Wait for manual input (Adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
  
}
	
	public void searchEntity (String need) {
		WebElement search = driver.findElement(By.xpath(propi.getProperty("loginPage.search")));
		search.sendKeys(need);
		WebElement searchb = driver.findElement(By.xpath(propi.getProperty("loginPage.searchbutton")));
		searchb.click();
		
	}
	
	public void ExploreItem() {
		WebElement item = driver.findElement(By.xpath(propi.getProperty("searchPage.Obj")));
		item.click();
	}
	public void Addtem() {
		WebElement add = driver.findElement(By.xpath(propi.getProperty("ProductPage.add")));
		add.click();
	}
	
}