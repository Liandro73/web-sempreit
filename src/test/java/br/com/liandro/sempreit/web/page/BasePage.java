package br.com.liandro.sempreit.web.page;

import io.cucumber.core.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class BasePage {

    WebDriver driver;
    private LoginPageObject loginPageObject;
    private ProductPageObject productPageObject;
    private CartPageObject cartPageObject;
    private Integer timeOut;
    public WebDriverWait waitDriver;
    private final long timeWait = 30;

    {
        this.timeOut = 30;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this);
        this.waitDriver = new WebDriverWait(driver, timeOut);
    }

    //////////////////////////////////////////

    public LoginPageObject getLoginPageObject() {
        if(this.loginPageObject == null) {
            this.loginPageObject = new LoginPageObject(driver);
        }
        return this.loginPageObject;
    }

    public ProductPageObject getProductPageObject() {
        if(this.productPageObject == null) {
            this.productPageObject = new ProductPageObject(driver);
        }
        return this.productPageObject;
    }

    public CartPageObject getCartPageObject() {
        if(this.cartPageObject == null) {
            this.cartPageObject = new CartPageObject(driver);
        }
        return this.cartPageObject;
    }

    //////////////////////////////////////////

    protected WebElement getElementClickable(WebElement element) {
        return waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement getElementVisibleByID(String id) {
        return waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    protected WebElement getElementVisible(WebElement element) {
        return waitDriver.until(ExpectedConditions.visibilityOf(element));
    }

    public void goToURL(String url) {
        driver.get(url);
    }
    public void waitURL(String url) {
        waitDriver.until(ExpectedConditions.urlContains(url));
    }

    public void checkTitlePage(String title) {
        waitDriver.until(ExpectedConditions.titleContains(title));
    }

    public void driverQuit() {
        if(driver != null) {
            driver.quit();
        }
    }

    protected void validateText(WebElement element, String texto) {
        elementExistsAndIsDisplay(element);
        Assert.assertEquals(texto.toUpperCase(), element.getText());

        System.out.println("...........................................");
        System.out.println("Texto Esperado: " + texto);
        System.out.println("Texto Obtido  : " + element.getText());
        System.out.println("...........................................");
    }

    protected void waitVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean elementExistsAndIsDisplay(WebElement element) {
        try {
            waitVisibilityOfElement(element);
            return element.isDisplayed();
        } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException ex) {
            return false;
        }
    }

    protected void clickOnElement(WebElement element) {
        getElementClickable(element);
        element.click();
    }

    protected void sendTextToElement(WebElement element, String text) {
        getElementVisible(element);
        element.sendKeys(text);
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void takeScreenshot(Scenario scenario, String step) {
        LocalDateTime dateTime = LocalDateTime.now();
        File evidencia = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String newNameStep = step
                .toLowerCase()
                .replace("ã", "a")
                .replace("ç", "c")
                .replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                newNameStep = newNameStep + "_" + dateTime + "__FAILED.png";
            } else {
                newNameStep = newNameStep + "_" + dateTime + "__PASSED.png";
            }
            FileUtils.moveFile(evidencia, new File("target/screenshots/" + scenario.getName() + "/" + newNameStep ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int randomNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

}
