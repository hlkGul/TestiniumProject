package gittigidiyor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasketPage extends BasePage{

    private static final By basketPriceLocator = By.xpath("//div[@class='total-price']/strong");
    private static final By selectProductCountLocator = By.xpath("//div[contains(@class,'gg-input-select')]/select[@class='amount']");
    private static final By clearBasketButtonLocator = By.xpath("//a[@title='Sil' and @class='btn-delete btn-update-item']");
    private static final By emptyBasketLocator = By.id("empty-cart-container");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getSecondPrice() {
        return findElement(basketPriceLocator).getText().split(" ")[0];
    }

    public String changeProductCount(String pCount) {
        Select productDropdown = new Select(findElement(selectProductCountLocator));
        productDropdown.selectByValue(pCount);
        return productDropdown.getFirstSelectedOption().getText();
    }

    public void clearBasket() {
        clickElement(clearBasketButtonLocator);
    }

    public boolean checkBasketIsEmpty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyBasketLocator)).isDisplayed();
    }

}
