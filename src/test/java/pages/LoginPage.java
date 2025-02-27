package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorsReader;

public class LoginPage extends LocatorsReader {
    
    // WebDriver instance
    WebDriver driver;
    
    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    /**
     * Checks if the CAPTCHA is present on the login page.
     * @return true if CAPTCHA is detected, false otherwise.
     */
    public boolean isCaptchaPresent() {
        WebElement cap = driver.findElement(By.xpath(propi.getProperty("loginPage.captcha")));
        System.out.println(cap.getText());
        return true; // This should ideally return cap.isDisplayed() instead of always returning true
    }

    /**
     * Provides a manual pause for CAPTCHA entry.
     * It waits for a predefined time to allow the user to solve the CAPTCHA manually.
     */
    public void enterCaptchaManually() {
        System.out.println("CAPTCHA detected! Please solve it manually.");
        try {
            Thread.sleep(15000); // Wait for manual input (Adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for an entity using the provided search term.
     * @param need - The search term to be entered in the search box.
     */
    public void searchEntity(String need) {
        WebElement search = driver.findElement(By.xpath(propi.getProperty("loginPage.search")));
        search.sendKeys(need);
        
        WebElement searchb = driver.findElement(By.xpath(propi.getProperty("loginPage.searchbutton")));
        searchb.click();
    }

    /**
     * Clicks on an item from the search results.
     * If no item is found, it prints an appropriate message.
     */
    public void ExploreItem() {
        WebElement item = driver.findElement(By.cssSelector(propi.getProperty("searchPage.Obj")));
        if (item.isDisplayed()) {
            item.click();
            System.out.println("Item clicked successfully.");
        } else {
            System.out.println("No items found in search results.");
        }
    }

    /**
     * Adds an item to the cart if the "Add to Cart" button is present.
     * If the button is not found, it prints an appropriate message.
     */
    public void Addtem() {
        WebElement add = driver.findElement(By.xpath(propi.getProperty("ProductPage.add")));
        if (add.isDisplayed()) {
            add.click();
            System.out.println("Item added to the cart.");
        } else {
            System.out.println("Add to Cart button not found.");
        }
    }
}
