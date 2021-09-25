package gittigidiyor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    private static final By secondPageLocator = By.xpath("//a[@title='2. sayfa' and @role='button']");
    private static final By listOfProductsLocator = By.xpath("//div[@data-testid='content']//li[@class='sc-1nx8ums-0 dyekHG']");
    private static final By addToBasketLocator = By.id("add-to-basket");
    private static final By goToBasketLocator = By.xpath("//div[@class='basket-container robot-header-iconContainer-cart']/a[@class='dIB']");
    private static final By productPriceLocator = By.id("sp-price-lowPrice");

    Random rand = new Random();

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void goToSecondPage() {
        wait.until(ExpectedConditions.elementToBeClickable(secondPageLocator)).click();
    }

    public int checkSecondPage() {
        String currentUrl = driver.getCurrentUrl();
        return Integer.parseInt(currentUrl.substring(currentUrl.length() - 1));
    }

    public void selectRandomProduct() {

        int randNum = rand.nextInt(32) + 1;
        if (randNum == 1) {
            randNum +=2;
        }
        List<WebElement> productList = findAllElements(listOfProductsLocator);
        productList.get(randNum).click();
    }

    public void addToBasketSelectedProduct() throws InterruptedException {
        clickElement(addToBasketLocator);
        Thread.sleep(3000);
    }
    public void goBasketPage() {
        wait.until(ExpectedConditions.elementToBeClickable(goToBasketLocator)).click();
    }

    public String getProductPagePrice() {
        return findElement(productPriceLocator).getText().split(" ")[0];
    }

}
