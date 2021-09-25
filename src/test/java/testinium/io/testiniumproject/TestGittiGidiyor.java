package testinium.io.testiniumproject;

import gittigidiyor.BasketPage;
import gittigidiyor.HomePage;
import gittigidiyor.LoginPage;
import gittigidiyor.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class TestGittiGidiyor extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    BasketPage basketPage;

    String _email = "email";
    String _password = "password";
    String _productName = "Bilgisayar";
    String firstPrice;

    @Test
    @Order(1)
    public void isHome() throws Exception {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        basketPage = new BasketPage(driver);
        homePage.acceptCookies();
        Assertions.assertTrue(homePage.isHomePageDisplayed(),"Anasayfa Goruntulunemedi");

    }

    @Test
    @Order(2)
    public void goLoginPage() throws Exception {
        homePage.goToLoginPage();
    }

    @Test
    @Order(3)
    public void login() {
        loginPage.setEmailAndPassword(_email, _password);
        loginPage.clickLogin();

    }

    @Test
    @Order(4)
    public void findProduct() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.typeProductNameOnSearchArea(_productName);
    }

    @Test
    @Order(5)
    public void productsToSecondPage() {
        productsPage.scrollToEnd();
        productsPage.goToSecondPage();
        Assertions.assertEquals(2, productsPage.checkSecondPage(),"Istenilen sayfada degilsiniz");
    }
    @Test
    @Order(6)
    public void selectRandomProduct() throws InterruptedException {
        productsPage.selectRandomProduct();
    }

    @Test
    @Order(7)
    public void goBasket() throws InterruptedException {
        productsPage.addToBasketSelectedProduct();
        firstPrice = productsPage.getProductPagePrice();
        productsPage.goBasketPage();
    }

    @Test
    @Order(8)
    public void comparePrices() {
        Assertions.assertEquals(firstPrice,basketPage.getSecondPrice(),"Fiyatlar Aynı değil");
    }

    @Test
    @Order(9)
    public void changeProductCount() {
        Assertions.assertEquals("2",basketPage.changeProductCount("2"),"Urun miktari degismedi");
    }

    @Test
    @Order(10)
    public void clearBasket() {
        basketPage.clearBasket();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(basketPage.checkBasketIsEmpty(),"Sepet Temizlenemedi");

    }





}
