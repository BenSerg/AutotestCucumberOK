package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

//здесь поменять
public class GroupPage
{
  By GROUP_LIST_LOCATOR = By.xpath("//*[contains(@class,'ugrid') and contains(@class, 'group')]");
  By MODER_CHAPTER_LOCATOR = By.xpath("//*[contains(@hrefattrs,'Moderate')]");
  By CREATE_GROUP_BUTTON_LOCATOR = By.xpath(("//*[contains(@href, 'create')]"));
  By CREATE_PUBLIC_BUTTON_LOCATOR = By.xpath("//*[contains(@data-l, 'PAGE')]");
  By GROUP_NAME_LOCATOR = By.xpath("//*[@id='field_name']");
  By SELECT_TAG_LOCATOR = By.xpath("/html/body/div[17]/div/div[2]/div[1]/div/div[2]/form/div[1]/div/div[2]/div[2]/div[1]/div/div/span[2]/input");
  By CREATE_BUTTON = By.xpath("//*[@id='hook_FormButton_button_create']");
  By GROUP_NAME = By.xpath("/html/body/div[10]/div[5]/div[5]/div[1]/div/div[2]/div[1]/div[3]/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/h1");
  List<WebElement> GROUP_LIST;
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
    Assertions.assertAll(() -> Assertions.assertNotNull(GROUP_LIST),
                         () -> Assertions.assertNotNull(new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(MODER_CHAPTER_LOCATOR))),
                         () -> Assertions.assertNotNull(new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(CREATE_GROUP_BUTTON_LOCATOR)))
                        );
  }

  public void switchToModerate()
  {
    driver.findElement(MODER_CHAPTER_LOCATOR).click();
  }
  public void createGroup(){
    driver.findElement(CREATE_GROUP_BUTTON_LOCATOR).click();
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver -> driver.findElement(CREATE_PUBLIC_BUTTON_LOCATOR)).click();
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver -> driver.findElement(GROUP_NAME_LOCATOR)).sendKeys("123");
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver -> driver.findElement(SELECT_TAG_LOCATOR)).click();
    By xp = By.xpath("/html/body/div[10]/div[5]/div[5]/div[4]/div/div[3]/div[1]/div[2]/div[2]");
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver -> driver.findElement(xp)).click();
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver -> driver.findElement(CREATE_BUTTON)).click();
  }
  public String getNewGroupName(){
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(GROUP_NAME)).getText();

  }
}
