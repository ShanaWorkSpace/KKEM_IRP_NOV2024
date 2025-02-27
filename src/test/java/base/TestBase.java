package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class TestBase 
{
//	Object Creations
  public WebDriver driver;
  public Properties prop ;
  
// function load properties file
  public void load_prop() throws IOException {
	  prop = new Properties();
      FileInputStream configFile = new FileInputStream("C:\\Users\\gssar\\Documents\\KKEM_IRP_NOV2024\\src\\test\\resources\\config.properties");
            prop.load(configFile);
  }

	@BeforeTest
	public void setUp() throws IOException{
		load_prop();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features=AutomationControlled");  // Bypass bot detection
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(prop.getProperty("URL"));
	
        System.out.println("Browser opened.");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("Browser closed.");
	}
	
	
	

}
	
