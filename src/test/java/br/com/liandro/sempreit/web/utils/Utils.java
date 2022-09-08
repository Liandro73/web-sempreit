package br.com.liandro.sempreit.web.utils;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utils {

    public WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/var/.chromedriver/chromedriver");
        ChromeOptions chromeOptions = configureChromeDriver();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    private ChromeOptions configureChromeDriver() {
        return new ChromeOptions()
                .addArguments(
                        "--test-type",
                        "--ignore-certificate-errors",
                        "--enable-popup-blocking",
                        "--disable-infobars",
                        "--disable-default-apps",
                        "--disable-extensions",
                        "--no-sandbox",
                        "--javascriptEnabled",
                        "--applicationCacheEnabled",
                        "--lang=pt-BR",
                        "--incognito",
                        "--disable-translate"
                )
                .setAcceptInsecureCerts(true)
                .setHeadless(true)
                .setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
    }

}
