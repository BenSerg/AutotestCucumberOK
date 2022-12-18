package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GroupCardWrapper
{
  By ENTRY_BUTTON_LOCATOR = By.xpath("//*[contains(@class, 'group-join') and contains(@class, 'button')]");
  WebElement gridcard;
  GroupCardWrapper(WebElement element)
  {
    this.gridcard = element;
  }

  public void enter()
  {
    gridcard.findElements(ENTRY_BUTTON_LOCATOR).get(0).click();
  }

}