package steps_definitions;


import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_problem_user {
    private WebDriver driver = Hooks.getDriver();


    @Given("I am on the principal home page of saucedemo")
    public void i_am_on_the_principal_home_page_of_saucedemo() {
        String tittleHomePage = driver.getTitle();
        Assert.assertEquals("Swag Labs", tittleHomePage);
      
    }
    @When("I put UserName: {string}")
    public void i_put_user_name(String problem_user) {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("problem_user"); 
       
    }
    @When("I put PassWord: {string}")
    public void i_put_pass_word(String secret_sauce) {
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        
    }
    @Then("I click Login button")
    public void i_click_login_button() {
        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
        
    }
    @Then("I enter in the Homepage properly")
    public void i_enter_in_the_homepage_properly() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
       
    }
    @Then("I validate that it is a functional page at first sight and have no repeated elements")
    public void i_validate_that_it_is_a_functional_page_at_first_sight_and_have_no_repeated_elements() {


        List<WebElement> srcRuta2 = driver.findElements(By.className("inventory_item"));

        List<String> src_list = new ArrayList<>();
        Boolean repeated = false;

        for (int x=0; x< srcRuta2.size(); x++){
           String path = srcRuta2.get(x).getAttribute("src");
           
           if(src_list.contains(path)){
                repeated = true;
            }else{
                src_list.add(path);
                
            }

            
        }

        Assert.assertEquals(false, repeated);
    
        
    
    
    }
}
