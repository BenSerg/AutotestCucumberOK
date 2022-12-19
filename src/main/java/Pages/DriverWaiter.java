package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWaiter
{
  private final WebDriver driver;

  public DriverWaiter(WebDriver driver)
  {
    this.driver = driver;
  }

  public WebElement waitForElement(long timeout, final By locator)
  {
    return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(driver -> driver.findElement(locator));
  }
}
