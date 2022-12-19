package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GroupPage
{
  private static final By GROUP_LIST_LOCATOR = By.xpath("//*[contains(@class,'ugrid') and contains(@class, 'group')]");
  private static final By MODER_CHAPTER_LOCATOR = By.xpath("//*[contains(@hrefattrs,'Moderate')]");
  private static final By CREATE_GROUP_BUTTON_LOCATOR = By.xpath(("//*[contains(@href, 'create')]"));
  private static final By GROUP_NAME = By.xpath("//*[@class = 'group-name_t']");
  private static final By GROUP_THEME = By.xpath("//*[@class = 'group-name_info']");
  private static final By STUB_LOCATOR = By.xpath("//*[contains(@class,'stub-empty')]");
  private static final By GROUP_JOIN_RESULT = By.xpath("//*[contains(@class, 'groups-join-result')]");

  private List<WebElement> GROUP_LIST;
  private final WebDriver driver;

  public GroupPage(WebDriver driver)
  {
    this.driver = driver;
    collect();
    check();
  }

  public void collect()
  {
    GROUP_LIST = new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElements(GROUP_LIST_LOCATOR));
  }

  public GroupCardWrapper enterGroup()
  {
    return new GroupCardWrapper(GROUP_LIST.get(0));
  }

  private void check()
  {
    Assertions.assertAll(
        () -> Assertions.assertNotNull(GROUP_LIST),
        () -> Assertions.assertNotNull(new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(MODER_CHAPTER_LOCATOR))),
        () -> Assertions.assertNotNull(new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(CREATE_GROUP_BUTTON_LOCATOR))));
  }

  public void switchToModerate()
  {
    driver.findElement(MODER_CHAPTER_LOCATOR).click();
  }

  public GroupCreationMenu goToCreateMenuButton()
  {
    driver.findElement(CREATE_GROUP_BUTTON_LOCATOR).click();
    return new GroupCreationMenu(driver);
  }

  public String getNewGroupName()
  {
    return new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(GROUP_NAME)).getText();
  }

  public String getNewGroupTheme()
  {
    return new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(GROUP_THEME)).getText();
  }

  public String getStubEmptyText()
  {
    return new WebDriverWait(driver, Duration.ofSeconds(7)).until(driver -> driver.findElement(STUB_LOCATOR)).getText();
  }

  public String getGroupEntranceMessage()
  {
    return new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(GROUP_JOIN_RESULT)).getText();
  }
}
