package PageObject;

import Steps.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MusicSearchPage {
    public WebDriver driver;
    public WaitHelper waitHelper;
    public MusicSearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//*[@id=\"music_layer\"]/header/div/wm-search-form/wm-search-input")
    WebElement musicSearch;

    @FindBy (xpath = "//*[@id=\"music_layer\"]/header/div/wm-search-form/wm-search-input/slot/wm-icon")
    WebElement searchAuthor;

    @FindBy (xpath = "//*[@id=\"music_layer\"]/main/div/div[2]/div/search-page/search-best-match/wm-page-header/slot/div/span/a")
    WebElement foundAuthor;

    @FindBy(xpath = "//*[contains(@data-tsid,'inner_input')]")
    WebElement searchInput;

    public void clickMusicSearchBtn() {
        waitHelper.WaitForElement(musicSearch,100);
        musicSearch.click();
    }
    public void setSearchAuthor(String author){
        waitHelper.WaitForElement(searchInput,100);
        searchInput.sendKeys(author);
    }
    public void clickSearchAuthor(){
        waitHelper.WaitForElement(searchAuthor,100);
        searchAuthor.click();
    }
    public String getAuthorName() {
        waitHelper.WaitForElement(foundAuthor,100);
        String name = foundAuthor.getText();
        return name;
    }
}
