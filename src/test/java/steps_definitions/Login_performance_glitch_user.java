package steps_definitions;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_performance_glitch_user  {
    private WebDriver driver = Hooks.getDriver();


@Given("I am on the main home page of saucedemo")
public void i_am_on_the_main_home_page_of_saucedemo() {
    String tittleHomePage = driver.getTitle();
    Assert.assertEquals("Swag Labs", tittleHomePage);
 
}
@When("I enter in the field UserName: {string}")
public void i_enter_in_the_field_user_name(String performance_glitch_user) {
    WebElement userName = driver.findElement(By.id("user-name"));
    userName.sendKeys("performance_glitch_user"); 
   
}
@When("I enter in the field PassWord: {string}")
public void i_enter_in_the_field_pass_word(String secret_sauce) {
    WebElement passWord = driver.findElement(By.id("password"));
    passWord.sendKeys("secret_sauce");
 
}
@Then("I click in the Login button and the page must load in 2 seconds")
public void i_click_in_the_login_button_and_the_page_must_load_in_2_seconds() {
    StopWatch pageLoad = new StopWatch();
    pageLoad.start();
    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();
    pageLoad.stop();
    long pageLoadTime_ms = pageLoad.getTime();
    long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
       System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
       System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
       double correctPerformance = 2; 
       Assert.assertTrue(correctPerformance >= pageLoadTime_Seconds);
}
@Then("I enter in the Homepage rightly")
public void i_enter_in_the_homepage_rightly() { 
    

    Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
   
      
   
}
}
