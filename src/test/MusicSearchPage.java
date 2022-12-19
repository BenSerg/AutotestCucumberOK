package Pages;

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

    @FindBy(xpath = "//*[contains(@data-tsid,'search_input')]")
    WebElement musicSearch;

    @FindBy(xpath = "//*[contains(@data-tsid,'inner_input')]")
    WebElement searchInput;

    @FindBy (xpath = "//*[contains(@data-tsid,'best_match_artist_name')]")
    WebElement foundAuthor;

    public void clickMusicSearchBtn() {
        waitHelper.WaitForElement(musicSearch,30);
        musicSearch.click();
    }

    public void setSearchAuthor(String author){
        waitHelper.WaitForElement(searchInput,30);
        searchInput.sendKeys(author+"\n");
    }

    public String getAuthorName() {
        waitHelper.WaitForElement(foundAuthor,30);
        String name = foundAuthor.getText();
        return name;
    }
}
