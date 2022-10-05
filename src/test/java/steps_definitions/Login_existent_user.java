package steps_definitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_existent_user  {
   
    private WebDriver driver = Hooks.getDriver();
    

    
@Given("I am on the home page of saucedemo")
public void i_am_on_the_home_page_of_saucedemo() {
    String tittleHomePage = driver.getTitle();
    Assert.assertEquals("Swag Labs", tittleHomePage);

}

@When("I enter UserName: {string}")
public void i_enter_user_name(String standard_user) {
    WebElement userName = driver.findElement(By.id("user-name"));
    userName.sendKeys("standard_user");
}
   
@When("I enter PassWord: {string}")
public void i_enter_pass_word(String secret_sauce) {
    WebElement passWord = driver.findElement(By.id("password"));
    passWord.sendKeys("secret_sauce");
    
}
@Then("I click Login")
public void i_click_login() {
    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();
    
}
@Then("I enter in the Homepage correctly")
public void i_enter_in_the_homepage_correctly() {

    Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
}

    
}
