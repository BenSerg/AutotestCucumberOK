package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage
{
  @FindBy(xpath = "//*[@data-l = 't,userAltGroup']")
  WebElement GROUP_PAGE_BUTTON;
  @FindBy(xpath =  "//*[@data-l = 't,userPhotos']")
  WebElement PHOTO_PAGE_BUTTON;
  private final WebDriver driver;

  public HomePage(WebDriver driver)
  {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
  }

  public GroupPage groupButtonClick()
  {
    GROUP_PAGE_BUTTON.click();
    return new GroupPage(driver);
  }

}
