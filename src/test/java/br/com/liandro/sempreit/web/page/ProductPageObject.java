package br.com.liandro.sempreit.web.page;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageObject extends BasePage {

    public ProductPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy( xpath = "//button[text()='Add to cart']" )
    private WebElement btnAddToCart;

    @FindBy( className = "shopping_cart_link" )
    private WebElement btnCart;

    public void checkVisibilityAndClickOnProduct(Scenario scenario, String step) {
        int index = randomNumber(6);
        driver.findElement(By.id("item_" + index + "_img_link"));
        scrollToElement(driver.findElement(By.id("item_" + index + "_img_link")));
        takeScreenshot(scenario, step);
        clickOnElement(driver.findElement(By.id("item_" + index + "_img_link")));
    }

    public void clickOnButtonAddToCart() {
        clickOnElement(btnAddToCart);
    }

    public void clickOnButtonCart() {
        clickOnElement(btnCart);
    }

}
