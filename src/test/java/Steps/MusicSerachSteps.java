package Steps;

import Pages.LoginPage;
import Pages.MusicSearchPage;
import Pages.ProfilePage;
import Pages.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MusicSerachSteps{
    public WebDriver driver;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public WaitHelper waitHelper;
    public MusicSearchPage musicSearchPage;
    @Given("user is on home page")
    public void user_is_on_home_page()
    {
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage=new LoginPage(driver);
        profilePage=new ProfilePage(driver);
        musicSearchPage=new MusicSearchPage(driver);
        waitHelper=new WaitHelper(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://ok.ru/dk?st.cmd=anonymMain");
        loginPage.inputLogin("technoPol11");
        loginPage.inputPasswd("technoPolis2022");
        loginPage.clickLoginBtn();
    }

    @When("User clicks on music toolbar")
    public void user_clicks_on_music_toolbar() {
        profilePage.clickMusicToolbarBtn();
    }

    @When("User clicks on search icon")
    public void user_clicks_on_search_icon() {
        musicSearchPage.clickMusicSearchBtn();
    }

    @When("User enter Author as {string}")
    public void userEnterAuthorAs(String arg0) {
        musicSearchPage.setSearchAuthor(arg0);
    }

    @Then("User author should be {string}")
    public void user_author_Should_Be(String foundAuthor) {
        String name= musicSearchPage.getAuthorName();
        Assert.assertEquals(name,foundAuthor);
    }
}
