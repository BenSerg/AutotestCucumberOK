package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GroupCardWrapper
{
  private static final By ENTRY_BUTTON_LOCATOR = By.xpath(("//*[contains(@class, 'button-pro group-join')]"));
  private static WebElement gridcard;

  GroupCardWrapper(WebElement element)
  {
    gridcard = element;
  }

  public void enter()
  {
    gridcard.findElements(ENTRY_BUTTON_LOCATOR).get(0).click();
  }

}