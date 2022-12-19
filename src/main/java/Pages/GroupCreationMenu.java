package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupCreationMenu
{
  private final WebDriver driver;
  private final DriverWaiter driverWaiter;
  private static final By CREATE_PUBLIC_BUTTON_LOCATOR = By.xpath("//*[contains(@data-l, 'PAGE')]");
  private static final By GROUP_NAME_LOCATOR = By.xpath("//*[@id='field_name']");
  private static final By SELECT_TAG_LOCATOR = By.xpath("//*[contains(@class, 'multi-select_it_cnt')]");
  private static final By CREATE_BUTTON = By.xpath("//*[@id='hook_FormButton_button_create']");

  public GroupCreationMenu(WebDriver driver)
  {
    this.driver = driver;
    this.driverWaiter = new DriverWaiter(this.driver);
  }

  public void setGroupName(String name)
  {
    driverWaiter.waitForElement(5, GROUP_NAME_LOCATOR).sendKeys(name);
  }

  public void choosePublicPage()
  {
    driverWaiter.waitForElement(5, CREATE_PUBLIC_BUTTON_LOCATOR).click();
  }

  public void setGroupTheme(String theme)
  {
    driverWaiter.waitForElement(6, SELECT_TAG_LOCATOR).click();
    String xpath = "//*[text() = '" + theme + "']";
    By xpath_theme = By.xpath(xpath);
    driverWaiter.waitForElement(10, xpath_theme).click();
  }

  public GroupPage createGroup()
  {
    driverWaiter.waitForElement(7, CREATE_BUTTON).click();
    return new GroupPage(driver);
  }

}
