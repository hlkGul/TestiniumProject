package gittigidiyor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

     private static final By emailTextBox = By.id("L-UserNameField");
     private static final By passwordTextBox = By.id("L-PasswordField");
     private static final By btnLoginButton = By.id("gg-login-enter");
     private static final By homePageLogo = By.xpath("//div[@class='left']/a[@title='Alışveriş Sitesi']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailAndPassword(String email, String password) {
        setText(emailTextBox, email);
        setText(passwordTextBox, password);
    }
      public void clickLogin(){
        clickElement(btnLoginButton);
        clickElement(homePageLogo);
      }


}
