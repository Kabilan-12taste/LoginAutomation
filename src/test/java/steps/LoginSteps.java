package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.base.BaseClass;
import org.junit.Assert;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass{
    

    @Given("I open the login page")
    public void i_open_login_page() {
    	setupBrowser();
        openUrl("https://www.12taste.com/staging-eu-11-04-2025/my-account/"); // use your real URL
    }

    @When("I enter valid username and password")
    public void i_enter_credentials() {
        driver.findElement(By.id("username")).sendKeys("test_email@12taste.com");
        driver.findElement(By.id("password")).sendKeys("test_email@12taste.com");
        driver.findElement(By.id("login")).click();
    }

    @Then("I should see the homepage")
    public void i_should_see_homepage() {
        Assert.assertTrue(driver.getTitle().contains("Home"));
        driver.quit();
    }
}
