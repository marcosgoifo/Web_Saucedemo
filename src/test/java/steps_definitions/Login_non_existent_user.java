package steps_definitions;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_non_existent_user {
    private WebDriver driver = Hooks.getDriver();


@Given("I am on the principal HomePage of saucedemo")
public void i_am_on_the_principal_home_page_of_saucedemo() {
    String tittleHomePage = driver.getTitle();
    Assert.assertEquals("Swag Labs", tittleHomePage);

}
@When("I put in the field UserName: {string}")
public void i_put_in_the_field_user_name(String non_existent) {
    WebElement userName = driver.findElement(By.id("user-name"));
    userName.sendKeys("non_existent"); 
}
@When("I put in the field PassWord: {string}")
public void i_put_in_the_field_pass_word(String secret_sauce) {
    WebElement passWord = driver.findElement(By.id("password"));
    passWord.sendKeys("secret_sauce");

}
@Then("I click on the Login button")
public void i_click_on_the_login_button() {
    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

}
@Then("A PopUp should appear with this string: {string}")
public void a_pop_up_should_appear_with_this_string(String string) {
    WebElement popUp = driver.findElement(By.tagName("h3"));
    String popUpText = popUp.getText();
    System.out.println("------>" + popUpText + "<------");
    Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", popUpText);

}
    
}
