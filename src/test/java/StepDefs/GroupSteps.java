package StepDefs;

import Pages.*;
import com.beust.ah.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupSteps
{
  private WebDriver driver;
  private static final String DRIVER_NAME = "webdriver.gecko.driver";
  private static final String DRIVER_PATH = "/home/serg/driver/geckodriver";
  public LoginPage loginPage;
  public HomePage homePage;
  public GroupPage groupPage;
  public GroupCardWrapper x;
  @Given("user is on home page")
  public void user_is_on_home_page()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver = new FirefoxDriver();
    new WebDriverWait(driver, Duration.ofSeconds(30));
    driver.manage().window().maximize();
    loginPage = new LoginPage(driver);
    homePage = loginPage.typeUsername("technoPol30").typePassword("technoPolis2022").submitLogin();
  }
  @When("user clicks on group button")
  public void userClicksOnGroupButton()
  {
    groupPage = homePage.groupButtonClick();
  }

  @And("user sees first group")
  public void userSeesFirstGroup()
  {
    x = groupPage.enterGroup();
  }

  @And("clicks on enter button")
  public void clicksOnEnterButton()
  {
    x.enter();
  }

  @Then("^(.*) should be seen$")
  public void argShouldBeSeen(String arg)
  {
    By res = By.xpath("//*[text() = 'Вы в группе']");
    Assert.assertEquals(arg, new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(res)).getText());
    driver.quit();
  }

  @Then("non-exist message should be visible")
  public void nonExistMessageShouldBeVisible()
  {
    By xp = By.xpath("//*[contains(@class,'stub-empty')]");
    Assert.assertEquals(new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(xp)).getText(), "У Вас нет модерируемых групп.");
    driver.quit();
  }

  @And("user enter moderate chapter with no moderate group")
  public void userEnterModelChapter()
  {
    groupPage.switchToModerate();
  }

  @And("user clicks on create group button")
  public void userClicksOnCreateGroupButton()
  {
    groupPage.createGroup();
  }

  @And("chooses public page")
  public void choosesPublicPage()
  {
  }

  @And("insert name in name_field")
  public void insertNameInName_field()
  {
  }

  @And("insert theme in theme_field")
  public void insertThemeInTheme_field()
  {
  }

  @And("clicks on create button")
  public void clicksOnCreateButton()
  {
  }

  @Then("new group name should be equal to name in name_field and theme should be equal to theme in theme_field")
  public void newGroupNameShouldBeEqualToNameInName_fieldAndThemeShouldBeEqualToThemeInTheme_field()
  {
    Assert.assertEquals("123", groupPage.getNewGroupName());
  }
}
