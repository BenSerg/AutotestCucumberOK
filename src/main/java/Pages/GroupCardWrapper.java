package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GroupCardWrapper
{
  private static final By ENTRY_BUTTON_LOCATOR = By.xpath(("//*[contains(@class, 'button-pro group-join')]"));
  private static WebElement gridCard;

  GroupCardWrapper(WebElement element)
  {
    gridCard = element;
  }

  public void enter()
  {
    gridCard.findElements(ENTRY_BUTTON_LOCATOR).get(0).click();
  }

}