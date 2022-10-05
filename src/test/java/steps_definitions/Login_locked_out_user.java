package steps_definitions;




import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_locked_out_user  {
    private WebDriver driver = Hooks.getDriver();



@Given("I am on the HomePage of saucedemo")
public void I_am_on_the_HomePage_of_saucedemo() {
    String tittleHomePage = driver.getTitle();
    Assert.assertEquals("Swag Labs", tittleHomePage);
    
}
@When("I enter the UserName: {string}")
 public void I_enter_the_UserName(String locked_out_user) {
    WebElement userName = driver.findElement(By.id("user-name"));
    userName.sendKeys("locked_out_user");  
}
   
@When("I enter the PassWord: {string}")
public void i_enter_the_passWord(String secret_sauce) {
    WebElement passWord = driver.findElement(By.id("password"));
    passWord.sendKeys("secret_sauce");
    
}
@Then("I click button Login")
public void i_click_button_login() {
    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();
}

@Then("A pop up should appear with this string: {string}")
public void a_pop_up_should_appear_with_this_string(String string) {
      WebElement popUp = driver.findElement(By.tagName("h3"));
      String popUpText = popUp.getText();
      System.out.println("------>" + popUpText + "<------");
      Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", popUpText);

}




    
}
