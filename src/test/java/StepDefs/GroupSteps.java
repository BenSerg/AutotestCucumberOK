package StepDefs;

import Pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupSteps
{
  private WebDriver driver;
  private static final String DRIVER_NAME = "webdriver.gecko.driver";
  private static final String DRIVER_PATH = "/home/serg/driver/geckodriver";
  private static HomePage homePage;
  private static GroupPage groupPage;
  private static GroupCardWrapper x;
  private static final String EXPECTED_NAME = "123", EXPECTED_THEME = "Автомойка";
  private GroupCreationMenu groupCreationMenu;

  @Given("user is on home page")
  public void user_is_on_home_page()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver = new FirefoxDriver();
    new WebDriverWait(driver, Duration.ofSeconds(30));
    driver.manage().window().maximize();
    LoginPage loginPage = new LoginPage(driver);
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
    Assert.assertEquals(arg, groupPage.getGroupEntranceMessage());
    driver.quit();
  }

  @Then("non-exist message should be visible")
  public void nonExistMessageShouldBeVisible()
  {
    String check = "У Вас нет модерируемых групп.";
    Assert.assertEquals(check, groupPage.getStubEmptyText());
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
    groupCreationMenu = groupPage.goToCreateMenuButton();
  }

  @And("chooses public page")
  public void choosesPublicPage()
  {
    groupCreationMenu.choosePublicPage();
  }

  @And("insert expected_name in name_field")
  public void insertNameInName_field()
  {
    groupCreationMenu.setGroupName(EXPECTED_NAME);
  }

  @And("insert expected_theme in theme_field")
  public void insertThemeInTheme_field()
  {
    groupCreationMenu.setGroupTheme(EXPECTED_THEME);
  }

  @And("clicks on create button")
  public void clicksOnCreateButton()
  {
    groupPage = groupCreationMenu.createGroup();
  }

  @Then("new group name should be equal to expected_name and theme should be equal to expected_theme")
  public void newGroupNameShouldBeEqualToNameInName_fieldAndThemeShouldBeEqualToThemeInTheme_field()
  {
    Assert.assertTrue(EXPECTED_NAME.equals(groupPage.getNewGroupName()) && EXPECTED_THEME.equals(groupPage.getNewGroupTheme()));
    driver.close();
  }
}
