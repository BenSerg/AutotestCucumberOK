package PageObject;

import Steps.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    public  WebDriver driver;
    public WaitHelper waitHelper;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        waitHelper=new WaitHelper(driver);
    }
    @FindBy(xpath = "//*[contains(@id,'field_email')]")
    private WebElement loginField;
    //WebElement loginField = driver.findElement(By.id("field_email"));

    @FindBy(xpath = "//*[contains(@value, 'Войти в Одноклассники')]")
    WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@id, 'field_password')]")
     WebElement passwdField;



    public void inputLogin(String login) {
        waitHelper.WaitForElement(loginField,100);
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickLoginBtn() {
        loginBtn.click();
    }


}