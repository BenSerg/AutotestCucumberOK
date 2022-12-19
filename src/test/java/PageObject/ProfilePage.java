package PageObject;

import Steps.WaitHelper;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public WebDriver driver;
    public WaitHelper waitHelper;

    public ProfilePage(WebDriver driver)  {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//*[contains(@href, '/post')]")
    WebElement notionBtm;

    @FindBy(xpath = "//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a")
    WebElement userName;

    @FindBy(xpath = "//*[contains(@class, 'posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler')]")
    WebElement notionField;

    @FindBy (xpath = "//*[contains(@data-l, 't,button.submit')]")
    WebElement pushBtm;

    @FindBy(xpath = "/html/body/div[10]/div[5]/div[5]/div[1]/div/div[2]/div[1]/div[3]/div[2]/div[1]/div/div[3]/div/div/div/div[3]/div/div[4]/div[1]/div[1]/div[1]/div/div[3]/div[1]/div/div/div")
    WebElement notionText;
    @FindBy (xpath = "//*[contains(@aria-label, 'Музыка')]")
    WebElement musicToolbar;

    public String getUserName() {
        String name = userName.getText();
        return name;
    }

    @FindBy(xpath = ".//*[@class='feed_menu']")
    WebElement deleteIcon;

    @FindBy (xpath = "/html/body/div[40]/div/ul")
    WebElement menu;

    public void notionBtmClick(){
        notionBtm.click();
    }

    public void sendNotinoText( String author) {
        notionField.sendKeys(author);
    }
    public void clickPushBtm(){
        pushBtm.click();
    }

    public String getText(){
        return notionText.getText();
    }

    public void deleteNotion(){
        Actions action = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(deleteIcon));
        action.moveToElement(deleteIcon).pause(1000).perform();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(menu));
        driver.findElement(By.xpath("/html/body/div[40]/div/ul/li[1]/a")).click();
    }
    public void clickMusicToolbarBtn() {
        waitHelper.WaitForElement(musicToolbar,100);
        musicToolbar.click();
    }
}
