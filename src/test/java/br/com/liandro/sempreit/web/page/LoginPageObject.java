package br.com.liandro.sempreit.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy( className = "login_logo" )
    private WebElement logoPageLogin;

    @FindBy( id = "user-name" )
    private WebElement inputUsername;

    @FindBy( id = "password" )
    private WebElement inputPassword;

    @FindBy( id = "login-button" )
    private WebElement btnLogin;

    public void checkVisibilityOfLogoPageLogin() {
        waitVisibilityOfElement(logoPageLogin);
    }

    public void fillInputUser(String usuario) {
        sendTextToElement(inputUsername, usuario);
    }

    public void fillInputPassword(String senha) {
        sendTextToElement(inputPassword, senha);
    }

    public void clickOnButtonLogin() {
        clickOnElement(btnLogin);
    }

}
