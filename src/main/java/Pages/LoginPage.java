package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage
{
  @FindBy(xpath = "//*[@id='field_email']")
  protected static WebElement USERNAME_FIELD;
  @FindBy(xpath = "//*[@id='field_password']")
  protected static WebElement PASSWORD_FIELD;
  @FindBy(xpath = "//*[@value='Войти в Одноклассники']")
  protected static WebElement LOGIN_BUTTON;
  private final WebDriver driver;

  public LoginPage(WebDriver driver)
  {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    String URL = "https://ok.ru/";
    driver.get(URL);
  }

  public LoginPage typeUsername(String username)
  {
    USERNAME_FIELD.sendKeys(username);
    return this;
  }

  public LoginPage typePassword(String password)
  {
    PASSWORD_FIELD.sendKeys(password);
    return this;
  }

  public HomePage submitLogin()
  {
    LOGIN_BUTTON.submit();
    return new HomePage(driver);
  }

}