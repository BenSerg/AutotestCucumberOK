package Steps;

import Pages.LoginPage;
import Pages.MusicSearchPage;
import Pages.ProfilePage;
import Pages.WaitHelper;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NotionSteps {
    public WebDriver driver;
    public LoginPage loginPage;
    public WaitHelper waitHelper;
    public MusicSearchPage musicSearchPage;
    public ProfilePage profilePage;

    @Дано("Пользователь на домашней странице")
    public void пользователь_на_домашней_странице() {
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage=new LoginPage(driver);
        profilePage=new ProfilePage(driver);
        musicSearchPage=new MusicSearchPage(driver);
        waitHelper=new WaitHelper(driver);
        driver.get("https://ok.ru/dk?st.cmd=anonymMain");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        loginPage.inputLogin("technoPol11");
        loginPage.inputPasswd("technoPolis2022");
        loginPage.clickLoginBtn();

    }
    @Когда("Пользователь нажимает на кнопку заметки")
    public void пользователь_нажимает_на_кнопку_заметки() {
        profilePage.notionBtmClick();
    }

    @Когда("Пользователь вводит заметку {string}")
    public void пользователь_вводит_заметку(String notion) {
        profilePage.sendNotinoText(notion);
    }
    @Когда("Пользователь публикует заметку")
    public void пользователь_публикует_заметку() {
        profilePage.clickPushBtm();
    }

    @Когда("Публикация должна быть {string}")
    public void публикация_должна_быть(String gotNotion) {
        String notion = profilePage.getText();
        Assert.assertEquals(notion, gotNotion);
    }

    @Тогда("удаление заметки")
    public void удаление_заметки() {
        profilePage.deleteNotion();
    }

}
