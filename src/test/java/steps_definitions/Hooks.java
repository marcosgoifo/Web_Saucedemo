package steps_definitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

  private static WebDriver driver;

  
	

    @Before
	
    public void setUp() {
	    DesiredCapabilities caps= new DesiredCapabilities();
      System.setProperty("webdriver.chrome.driver","./src/drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.navigate().to("https://www.saucedemo.com/");
      driver.manage().window().maximize();
            
    }
	
	

    @After

    public void tearDown(Scenario scenario) {
      if (scenario.isFailed()) {
    
      TakesScreenshot ts = (TakesScreenshot) driver;
      byte[] src = ts.getScreenshotAs(OutputType.BYTES);
      scenario.attach(src, "image/png", "Screenshot");
  
     }

      driver.quit();

    }


    public static WebDriver getDriver() {
		 return driver;	
	  }



	


    
}
