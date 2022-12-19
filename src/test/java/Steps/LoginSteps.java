package Steps;

import PageObject.LoginPage;
import PageObject.MusicSearchPage;
import PageObject.ProfilePage;
import cucumber.api.java.en.And;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSteps{
    public WebDriver driver;
    public LoginPage loginPage;
    public WaitHelper waitHelper;
    public MusicSearchPage musicSearchPage;
    public ProfilePage profilePage;

    @Given("User Launch Chrome Driver")
    public void user_launch_chrome_driver() {
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage=new LoginPage(driver);
        profilePage=new ProfilePage(driver);
        waitHelper=new WaitHelper(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url){
        driver.get(url);
    }

    @When("User enter Email {string}")
    public void user_enter_email_as(String login){
        loginPage.inputLogin(login);
    }
    @When("User enter Password as {string}")
    public void user_enter_password_as( String password){
        loginPage.inputPasswd(password);
    }

    @When("User clicks on Login")
    public void user_clicks_on_login(){
        loginPage.clickLoginBtn();
    }

    @Then("User name should be {string}")
    public void username_should_be(String userName){
        String getUserName = profilePage.getUserName();
        Assert.assertEquals(userName, getUserName);
    }


}
