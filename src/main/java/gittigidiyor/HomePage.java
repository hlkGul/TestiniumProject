package gittigidiyor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    WebDriverWait wait;

    private final By isHomePageDisplayedElementWithOutLogin = By.xpath("//a[@title='Sipariş Takibi' and contains(text(),'Sipariş Takibi')]");
    private final By isHomePageDisplayedElementWithLogin = By.xpath("//a[@title='Siparişlerim' and contains(text(),'Siparişlerim')]");
    private final By homePageLoginButton = By.xpath("//a[@data-cy='header-login-button' and @type='button']");
    private final By moveMouseToLoginArea = By.xpath("//*[@data-cy='header-user-menu']/div[@title='Giriş Yap']");
    private final By searchInputBox = By.xpath("//input[@data-cy='header-search-input' and @name='k']");
    private final By searchButton = By.xpath("//button[@data-cy='search-find-button' and @type='submit']");
    private final By acceptCookiesButton = By.xpath("//span[contains(text(),'Kapat')]");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() throws Exception {
        return findElement(this.isHomePageDisplayedElementWithOutLogin).isDisplayed();
    }

    public void goToLoginPage() throws Exception {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(moveMouseToLoginArea)).build().perform();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(homePageLoginButton)).click();
    }

    public boolean isLogin() {
        return findElement(isHomePageDisplayedElementWithLogin).isDisplayed();
    }

    public void typeProductNameOnSearchArea(String productName) {
        clickElement(searchInputBox);
        setText(searchInputBox,productName);
        clickElement(searchButton);
    }

    public void acceptCookies() {
        clickElement(acceptCookiesButton);
    }


}
