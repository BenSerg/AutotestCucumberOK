package StepDefs;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps
{
  private WebDriver driver;
  private static final String DRIVER_NAME = "webdriver.gecko.driver";
  private static final String DRIVER_PATH = "/home/serg/driver/geckodriver";
  private static final By USERNAME = By.xpath("//*[@data-l = 't,userPage']");
  private static LoginPage loginPage;

  @Given("browser is open on login page")
  public void browserIsOpen()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver = new FirefoxDriver();
    new WebDriverWait(driver, Duration.ofSeconds(30));
    driver.manage().window().maximize();
    loginPage = new LoginPage(driver);
  }

  @Then("^user is navigated to the home page and username should be equal to (.*)$")
  public void userIsNavigatedToTheHomePage(String username)
  {
    Assertions.assertEquals(username, new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(USERNAME)).getText());
    driver.close();
  }

  @When("^user enters(.*) and (.*)$")
  public void userEntersUsernameAndPassword(String username, String password)
  {
    loginPage.typeUsername(username).typePassword(password);
  }

  @And("submit login button")
  public void submitLoginButton()
  {
    loginPage.submitLogin();
  }
}
