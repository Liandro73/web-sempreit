package br.com.liandro.sempreit.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageObject extends BasePage {

    public CartPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy( className = "title" )
    private WebElement titlePage;

    @FindBy( id = "checkout" )
    private WebElement btnCheckout;

    @FindBy( id = "first-name" )
    private WebElement inputFirstName;

    @FindBy( id = "last-name" )
    private WebElement inputLastName;

    @FindBy( id = "postal-code" )
    private WebElement inputPostalCode;

    @FindBy( id = "continue" )
    private WebElement btnContinue;

    @FindBy( id = "finish" )
    private WebElement btnFinish;

    @FindBy( className = "complete-header" )
    private WebElement msgPurchaseSucess;

    public void checkTitlePageCart(String title) {
        validateText(titlePage, title);
    }

    public void clickOnButtonCheckout() {
        clickOnElement(btnCheckout);
    }

    public void fillInputFirstName(String name) {
        sendTextToElement(inputFirstName, name);
    }

    public void fillInputLastName(String lastName) {
        sendTextToElement(inputLastName, lastName);
    }

    public void fillInputPostalCode(String postalCode) {
        sendTextToElement(inputPostalCode, postalCode);
    }

    public void clickOnButtonContinue() {
        clickOnElement(btnContinue);
    }

    public void clickOnButtonFinish() {
        clickOnElement(btnFinish);
    }

    public void checkMsgPurchaseSucess(String msg) {
        validateText(msgPurchaseSucess, msg);
    }

}
