package StepDefs;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
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

  public GroupSteps(WebDriver driver)
  {
    this.driver = driver;
  }

  @Given("user is on home page with one group")
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

  @Then("group entrance success should be seen$")
  public void argShouldBeSeen()
  {
    String arg = "Вы в группе";
    Assertions.assertEquals(arg, groupPage.getGroupEntranceMessage());
    driver.close();
  }

  @Then("non-exist message should be visible")
  public void nonExistMessageShouldBeVisible()
  {
    String check = "У Вас нет модерируемых групп.";
    Assertions.assertEquals(check, groupPage.getStubEmptyText());
    driver.close();
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
    Assertions.assertTrue(EXPECTED_NAME.equals(groupPage.getNewGroupName()) && EXPECTED_THEME.equals(groupPage.getNewGroupTheme()));
    driver.close();
  }

  @After
  public void exit()
  {
    driver.close();
  }
}
