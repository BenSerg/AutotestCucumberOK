package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupCreationMenu
{
  private final WebDriver driver;
  private static final By CREATE_PUBLIC_BUTTON_LOCATOR = By.xpath("//*[contains(@data-l, 'PAGE')]");
  private static final By GROUP_NAME_LOCATOR = By.xpath("//*[@id='field_name']");
  private static final By SELECT_TAG_LOCATOR = By.xpath("//*[contains(@class, 'multi-select_it_cnt')]");
  private static final By CREATE_BUTTON = By.xpath("//*[@id='hook_FormButton_button_create']");

  public GroupCreationMenu(WebDriver driver)
  {
    this.driver = driver;
  }

  public void setGroupName(String name)
  {
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(GROUP_NAME_LOCATOR)).sendKeys(name);
  }

  public void choosePublicPage()
  {
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(CREATE_PUBLIC_BUTTON_LOCATOR)).click();
  }

  public void setGroupTheme(String theme)
  {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(SELECT_TAG_LOCATOR)).click();
    String xpath = "//*[text() = '" + theme + "']";
    By xp = By.xpath(xpath);
    new WebDriverWait(driver, Duration.ofSeconds(7)).until(driver -> driver.findElement(xp)).click();
  }

  public GroupPage createGroup()
  {
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(CREATE_BUTTON)).click();
    return new GroupPage(driver);
  }

}
